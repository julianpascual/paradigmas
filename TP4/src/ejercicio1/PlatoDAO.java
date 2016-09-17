package ejercicio1;

import com.apple.eawt.AppEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static helpers.Helpers.getConnection;

/**
 * Created by Julian on 14/9/16.
 */
public class PlatoDAO {
    private static Connection connection = getConnection();

    public static void altaPlato(String nombre, ArrayList<String> ingredientes, int precio) {
        try{

            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO PLATO (NOMBRE,PRECIO) VALUES (?,?)"
            );
            st.setString(1,nombre);
            st.setInt(2, precio);
            st.executeUpdate();

            agregarRelacionPlatoIngrediente(nombre, ingredientes);

        } catch (Exception ex) {
        }
    }

    public static void bajaPlato(String nombre) {

    }

    public static void modificarPlato(String nombreViejo, ArrayList<String> ingredientesNuevo, int precioNuevo) {

    }

    public static ArrayList<String> devolverPlatos() {
        ArrayList<String> platos = new ArrayList<>();
        try{
            Statement st =  connection.createStatement();
            String query = "SELECT * FROM PLATO";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                platos.add(rs.getString("NOMBRE"));
            }
        }catch (Exception ex){

        } finally {
            return platos;
        }
    }

    public static void limpiarTablaPlatos() {
        try{
            Statement st =  connection.createStatement();
            String query = "DELETE FROM PLATO_INGREDIENTE";
            st.execute(query);
            query = "DELETE FROM PLATO";
            st.execute(query);
        }catch (Exception ex){
        }
    }

    public static void agregarRelacionPlatoIngrediente(String nombre, ArrayList<String> ingredientes) throws Exception{
        PreparedStatement st;
        for (String ingrediente : ingredientes) {
            st = connection.prepareStatement(
                    "INSERT INTO PLATO_INGREDIENTE (ID_PLATO, ID_INGREDIENTE)" +
                            "SELECT p.ID, i.ID" +
                            "FROM PLATO p, INGREDIENTE i" +
                            "WHERE p.NOMBRE = ? AND i.NOMBRE = ?"
            );
            st.setString(1, nombre);
            st.setString(2, ingrediente);
            st.executeUpdate();
        }
    }
}
