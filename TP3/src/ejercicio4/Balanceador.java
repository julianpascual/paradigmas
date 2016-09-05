package ejercicio4;

import java.util.*;
/**
 * Created by julianpascual on 9/5/16.
 */
public class Balanceador {
    public Stack evaluar;

    public boolean expresionBalanceada(String expresion ) {
        evaluar = new Stack();
        int i = 0;

        while ( i < expresion.length() ) {
            if ( expresion.charAt(i) == '(' ) {
                evaluar.push( "(" );
            } else if ( expresion.charAt( i ) == ')' ) {
                quitarDePila();
            }

            if ( expresion.charAt( i ) == '[' ) {
                evaluar.push( "[" );
            } else if ( expresion.charAt( i ) == ']' ) {
                quitarDePila();
            }

            if ( expresion.charAt( i ) == '{' ) {
                evaluar.push( "{" );
            } else if ( expresion.charAt( i ) == '}' ) {
                quitarDePila();
            }
            i++;
        }
        if ( evaluar.isEmpty() ) {
            return true;
        } else {
            return false;
        }
    }

    public void quitarDePila() {
        if (!evaluar.isEmpty() ) {
            try {
                evaluar.pop();
            } catch ( Exception e ) {
            }
        } else {
            //agrego uno en caso de que esta vacio para retornar false en la funcion
            evaluar.push( "]" );
        }
    }

}
