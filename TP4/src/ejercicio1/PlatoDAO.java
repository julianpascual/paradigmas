package ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static helpers.Helpers.getConnection;

/**
 * Created by Julian on 14/9/16.
 */
public class PlatoDAO {
    private static Connection connection = getConnection();

    public static void altaPlato(String nombre, ArrayList<String> ingredientes, int precio) throws Exception{
            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO PLATO (NOMBRE,PRECIO) VALUES (?,?)"
            );
            st.setString(1,nombre);
            st.setInt(2, precio);
            st.executeUpdate();
            agregarRelacionPlatoIngrediente(nombre, ingredientes);
    }

    public static int bajaPlato(String nombre) throws Exception{
        limpiarRelacionesPlato(nombre);
        PreparedStatement st =  connection.prepareStatement(
                "DELETE FROM PLATO WHERE NOMBRE = ? "
        );
        st.setString(1,nombre);
        return st.executeUpdate();
    }

    public static void modificarPlato(String nombreViejo, String nombreNuevo, ArrayList<String> ingredientesNuevo, int precioNuevo) throws Exception{
        limpiarRelacionesPlato(nombreViejo);
        PreparedStatement st = connection.prepareStatement(
                "UPDATE PLATO SET NOMBRE = ?," +
                        "PRECIO = ?" +
                        "WHERE NOMBRE = ?"
        );
        st.setString(1, nombreNuevo);
        st.setInt(2, precioNuevo);
        st.setString(3, nombreViejo);
        st.executeUpdate();
        agregarRelacionPlatoIngrediente(nombreNuevo, ingredientesNuevo);
    }

    public static ArrayList<String> devolverPlatos() throws Exception{
        ArrayList<String> platos = new ArrayList<>();
        Statement st =  connection.createStatement();
        String query = "SELECT * FROM PLATO";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            platos.add(rs.getString("NOMBRE"));
        }
        return platos;
    }

    public static void limpiarTablaPlatos() throws Exception{
            Statement st =  connection.createStatement();
            String query = "DELETE FROM PLATO_INGREDIENTE";
            st.execute(query);
            query = "DELETE FROM PLATO";
            st.execute(query);
    }

    private static void agregarRelacionPlatoIngrediente(String nombre, ArrayList<String> ingredientes) throws Exception{
        PreparedStatement st;
        for (String ingrediente : ingredientes) {
            st = connection.prepareStatement(
                    "INSERT INTO PLATO_INGREDIENTE (ID_PLATO, ID_INGREDIENTE) " +
                            "SELECT p.ID, i.ID " +
                            "FROM PLATO p, INGREDIENTE i " +
                            "WHERE p.NOMBRE = ? AND i.NOMBRE = ?"
            );
            st.setString(1, nombre);
            st.setString(2, ingrediente);
            st.executeUpdate();
        }
    }

    private static void limpiarRelacionesPlato(String nombre) throws Exception{
        PreparedStatement st;
        st = connection.prepareStatement(
                "DELETE FROM PLATO_INGREDIENTE " +
                        "WHERE ID_PLATO IN (SELECT ID FROM PLATO WHERE NOMBRE = ?)"
        );
        st.setString(1,nombre);
        st.execute();
    }
}
