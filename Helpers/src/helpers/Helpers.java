package helpers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by julianpascual on 9/4/16.
 */
public final class Helpers {
    private static String connectionString = "jdbc:h2:~/IdeaProjects/paradigmas/DB_TP_4/DB_H2";

    public static boolean esPrimo(int num) {
        int cantDivisores = 0;
        for (int i = 1; i <= num ; i++) {
            if (num % i == 0) {
                cantDivisores ++;
            }
        }
        if (cantDivisores == 2) {
            return true;
        } else {
            return false;
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
