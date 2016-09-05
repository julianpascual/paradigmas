package ejercicio4;

import java.util.*;
/**
 * Created by julianpascual on 9/5/16.
 */
public class Balanceador {

    public static boolean checkExpression(String expression ) {
        Stack evalue;
        evalue = new Stack();
        int i = 0;

        while ( i < expression.length() ) {
            if ( expression.charAt(i) == '(' ) {
                evalue.push( "(" );
            } else if ( expression.charAt( i ) == ')' ) {
                if ( !evalue.isEmpty() ) {
                    try {
                        evalue.pop();
                    } catch ( Exception e ) {
                        return false;
                    }
                } else {
                    evalue.push( "]" );
                    return false;
                }
            }

            if ( expression.charAt( i ) == '[' ) {
                evalue.push( "[" );
            } else if ( expression.charAt( i ) == ']' ) {
                if ( !evalue.isEmpty() ) {
                    try {
                        evalue.pop();
                    } catch ( Exception e ) {
                        return false;
                    }
                } else {
                    evalue.push( "]" );
                    return false;
                }
            }
            i++;
        }

        if ( evalue.isEmpty() ) {
            return true;
        } else {
            return false;
        }
    }


}
