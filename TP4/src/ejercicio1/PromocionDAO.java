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
public class PromocionDAO {
    private static Connection connection = getConnection();

    public static void altaPromocion(String nombre, ArrayList<String> platos, String bebida,String tamañoBebida, int precio) throws Exception {

        PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO PROMOCION(NOMBRE, ID_BEBIDA, PRECIO) " +
                            "SELECT ?, b.ID, ? " +
                            "FROM BEBIDA b " +
                            "WHERE b.NOMBRE = ? AND b.TAMAÑO = ?"
        );
        st.setString(1, nombre);
        st.setInt(2, precio);
        st.setString(3, bebida);
        st.setString(4, tamañoBebida);
        st.executeUpdate();

        agregarRelacionPlatosPromocion(nombre, platos);
    }

    private static void agregarRelacionPlatosPromocion(String nombre, ArrayList<String> platos) throws Exception{
        PreparedStatement st;
        for (String plato : platos) {
            st = connection.prepareStatement(
                    "INSERT INTO PROMOCION_PLATO (ID_PROMOCION, ID_PLATO) " +
                            "SELECT pr.ID, pl.ID " +
                            "FROM PLATO pl, PROMOCION pr " +
                            "WHERE pr.NOMBRE = ? AND pl.NOMBRE = ?"
            );
            st.setString(1, nombre);
            st.setString(2, plato);
            st.executeUpdate();
        }
    }

    private static void limpiarRelacionesPromocion(String nombre) throws Exception{
        PreparedStatement st;
        st = connection.prepareStatement(
                "DELETE FROM PROMOCION_PLATO " +
                        "WHERE ID_PROMOCION IN (SELECT ID FROM PROMOCION WHERE NOMBRE = ?)"
        );
        st.setString(1,nombre);
        st.execute();
    }

    public static void bajaPromocion(String nombre) throws Exception {
        limpiarRelacionesPromocion(nombre);
        PreparedStatement st = connection.prepareStatement(
                "DELETE FROM PROMOCION WHERE NOMBRE = ?"
        );
        st.setString(1, nombre);
        st.executeUpdate();
    }

    public static void modificarPromocion(String nombreViejo, String nombreNuevo,ArrayList<String> platosNuevos,
                                          String bebidaNueva, String tamañoNuevaBebida, int precioNuevo) throws Exception {

        limpiarRelacionesPromocion(nombreViejo);
        PreparedStatement st = connection.prepareStatement(
                "UPDATE PROMOCION " +
                        "SET NOMBRE = ?, " +
                        "  PRECIO = ?, " +
                        "  ID_BEBIDA = (SELECT ID FROM BEBIDA WHERE BEBIDA.NOMBRE = ? AND TAMAÑO = ?) " +
                        "WHERE NOMBRE = ? "
        );
        st.setString(1, nombreNuevo);
        st.setInt(2, precioNuevo);
        st.setString(3, bebidaNueva);
        st.setString(4, tamañoNuevaBebida);
        st.setString(5, nombreViejo);
        st.executeUpdate();

        agregarRelacionPlatosPromocion(nombreNuevo, platosNuevos);

    }

    public static ArrayList<String> devolverPromociones() throws Exception{
        ArrayList<String> promociones = new ArrayList<>();
        Statement st =  connection.createStatement();
        String query = "SELECT * FROM PROMOCION";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            promociones.add(rs.getString("NOMBRE"));
        }
        return promociones;
    }

    public static void limpiarTablaPromociones() throws Exception{
        Statement st =  connection.createStatement();
        String query = "DELETE FROM PROMOCION_PLATO";
        st.execute(query);
        query = "DELETE FROM PROMOCION";
        st.execute(query);
    }
}
