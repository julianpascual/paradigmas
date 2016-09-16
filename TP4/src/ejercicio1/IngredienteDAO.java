package ejercicio1;

import java.sql.*;

/**
 * Created by Julian on 14/9/16.
 */
public class IngredienteDAO {
    public static String connectionString = "jdbc:h2:~/IdeaProjects/paradigmas/DB_TP_4/DB_H2";


    //altaIngrediente(nombre, tipo)
    //borrarIngrediente(nombre)
    //modificarIngrediente(nombreViejo, nombreNuevo, tipoNuevo)
    //devolverIngredientes que devuelve una lista de Strings con los nombres de los ingredientes
    //devolverLasVerduras que devuelve solo las verduras

    public static void altaIngrediente(String nombre, String tipo){

        try{

            Connection con = getConnection();
            PreparedStatement insertIng = con.prepareStatement(
                    "INSERT INTO INGREDIENTE (NOMBRE,TIPO) VALUES (?,?)"
            );
            insertIng.setString(1,nombre);
            insertIng.setString(2,tipo);
            insertIng.executeUpdate();

        } catch (Exception ex) {
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
