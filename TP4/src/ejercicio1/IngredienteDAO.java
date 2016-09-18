package ejercicio1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static helpers.Helpers.getConnection;

/**
 * Created by Julian on 14/9/16.
 */
public class IngredienteDAO {
    private static Connection con = getConnection();


    public static int altaIngrediente(String nombre, String tipo) throws Exception {
        PreparedStatement insertIng = con.prepareStatement(
                "INSERT INTO INGREDIENTE (NOMBRE,TIPO) VALUES (?,?)"
        );
        insertIng.setString(1,nombre);
        insertIng.setString(2,tipo);
        return insertIng.executeUpdate();
    }

    public static int bajaIngrediente(String nombre) throws Exception{
        PreparedStatement st =  con.prepareStatement(
                "DELETE FROM INGREDIENTE WHERE NOMBRE = ?"
        );
        st.setString(1,nombre);
        return st.executeUpdate();
    }

    public static List<String> devolverIngredientes() throws Exception{
        List<String> ingredientes = new ArrayList<String>();
        Statement st =  con.createStatement();
        String query = "SELECT * FROM INGREDIENTE";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            ingredientes.add(rs.getString("NOMBRE"));
        }
        return ingredientes;
    }

    public static int modificarIngrediente(String nombreViejo, String nombreNuevo, String tipoNuevo) throws Exception{
        PreparedStatement st = con.prepareStatement(
                "UPDATE INGREDIENTE SET NOMBRE = ?," +
                        "TIPO = ? " +
                        "WHERE NOMBRE LIKE ?"
        );

        st.setString(1, nombreNuevo);
        st.setString(2, tipoNuevo);
        st.setString(3, nombreViejo);

        return st.executeUpdate();
    }

    public static ResultSet devolverLasVerduras() throws Exception{
        ResultSet verduras = null;
        Statement st =  con.createStatement();
        String query = "SELECT * FROM INGREDIENTE WHERE TIPO = 'verdura'";
        verduras = st.executeQuery(query);
        return verduras;
    }

    public static void limpiarTablaIngredientes() throws Exception{
            Statement st =  con.createStatement();
            String query = "DELETE FROM INGREDIENTE";
            st.execute(query);
    }


}
