package ejercicio1;

/**
 * Created by julianpascual on 9/5/16.
 */
public class ExpresionesAritmeticas {

    public double resolverExpresion(String expresion) {

        int operando1, operando2;
        String[] result = expresion.split(" ");

        try {
            operando1 = Integer.parseInt(result[0].trim());
            operando2 = Integer.parseInt(result[2].trim());

            switch (result[1]) {
                case "+" : return operando1 + operando2;
                case "-" : return operando1 - operando2;
                case  "*" : return operando1 * operando2;
                case "/" : return operando1 / operando2;
                default: return -1;
            }
        } catch (Exception ex){
            return -1;
        }
    }
}
