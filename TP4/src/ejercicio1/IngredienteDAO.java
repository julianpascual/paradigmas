package ejercicio1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 14/9/16.
 */
public class IngredienteDAO {
    private static String connectionString = "jdbc:h2:~/IdeaProjects/paradigmas/DB_TP_4/DB_H2";
    private static Connection con = getConnection();

    //modificarIngrediente(nombreViejo, nombreNuevo, tipoNuevo)

    public static int altaIngrediente(String nombre, String tipo){

        try{

            PreparedStatement insertIng = con.prepareStatement(
                    "INSERT INTO INGREDIENTE (NOMBRE,TIPO) VALUES (?,?)"
            );
            insertIng.setString(1,nombre);
            insertIng.setString(2,tipo);
            return insertIng.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
    }

    public static int bajaIngrediente(String nombre){
        try{
            PreparedStatement st =  con.prepareStatement(
                    "DELETE FROM INGREDIENTE WHERE NOMBRE = ?"
            );
            st.setString(1,nombre);
            return st.executeUpdate();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static List<String> devolverIngredientes(){
        List<String> ingredientes = new ArrayList<String>();
        try{
            Statement st =  con.createStatement();
            String query = "SELECT * FROM INGREDIENTE";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                ingredientes.add(rs.getString("NOMBRE"));
            }
        }catch (Exception ex){

        } finally {
            return ingredientes;
        }
    }

    public static ResultSet devolverLasVerduras(){
        ResultSet verduras = null;
        try{
            Statement st =  con.createStatement();
            String query = "SELECT * FROM INGREDIENTE WHERE TIPO = 'verdura'";
            verduras = st.executeQuery(query);
        }catch (Exception ex){

        } finally {
            return verduras;
        }
    }

    public static void limpiarTablaIngredientes() {
        try{
            Statement st =  con.createStatement();
            String query = "DELETE FROM INGREDIENTE";
            st.execute(query);
        }catch (Exception ex){
        }
    }

    public static Connection getConnection(){
        Connection dbConnection = null;
        try {
            Class.forName("org.h2.Driver");
            dbConnection = DriverManager.getConnection(connectionString,"julian","");
            return dbConnection;
        } catch (Exception ex) {
            return dbConnection;
        }
    }

}
