package ejercicio1;

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
public class BebidaDAO {
    private static Connection connection = getConnection();

    public static int altaBebida(String nombre, String tamaño, int precio) throws Exception{
        PreparedStatement insertIng = connection.prepareStatement(
                "INSERT INTO BEBIDA (NOMBRE,TAMAÑO,PRECIO) VALUES (?,?,?)"
        );
        insertIng.setString(1,nombre);
        insertIng.setString(2,tamaño);
        insertIng.setInt(3, precio);
        return insertIng.executeUpdate();
    }

    public static int bajaBebida(String nombre, String tamaño) throws Exception{
        PreparedStatement st =  connection.prepareStatement(
                "DELETE FROM BEBIDA WHERE NOMBRE = ? " +
                        "AND TAMAÑO = ?"
        );
        st.setString(1,nombre);
        st.setString(2,tamaño);
        return st.executeUpdate();
    }

    public static List<String> devolverBebidas() throws Exception{
        List<String> bebidas = new ArrayList<String>();
        Statement st =  connection.createStatement();
        String query = "SELECT * FROM BEBIDA";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            bebidas.add(rs.getString("NOMBRE"));
        }
        return bebidas;
    }

    public static ResultSet devolverBebida(String nombre, String tamaño) throws Exception{
        ResultSet rs;
        PreparedStatement st =  connection.prepareStatement(
                "SELECT * FROM BEBIDA WHERE NOMBRE = ? AND TAMAÑO = ?"
        );
        st.setString(1,nombre);
        st.setString(2,tamaño);
        rs = st.executeQuery();
        return rs;
    }

    public static int modificarBebida(String nombreViejo, String nombreNuevo, String tamañoViejo, String tamañoNuevo,int precioNuevo) throws Exception {
        PreparedStatement st = connection.prepareStatement(
                "UPDATE BEBIDA SET NOMBRE = ?," +
                        "TAMAÑO = ?," +
                        "PRECIO = ?" +
                        "WHERE NOMBRE = ?" +
                        "AND TAMAÑO = ?"
        );

        st.setString(1, nombreNuevo);
        st.setString(2, tamañoNuevo);
        st.setInt(3, precioNuevo);
        st.setString(4, nombreViejo);
        st.setString(5, tamañoViejo);

        return st.executeUpdate();
    }

    public static void limpiarTablaBebidas() throws Exception{
        Statement st =  connection.createStatement();
        String query = "DELETE FROM BEBIDA";
        st.execute(query);
    }
}
