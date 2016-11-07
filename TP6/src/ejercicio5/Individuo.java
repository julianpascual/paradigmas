package ejercicio5;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by julianpascual on 11/7/16.
 */
public class Individuo {

    GenomaHumano genomaHumano = GenomaHumano.getInstancia();
    List<Gen> genes = genomaHumano.clonar();
    List<String> valoresPosibles = new ArrayList<String>();

    public Individuo() {
        darValorANucleotidos();
    }

    private List<Gen> getGenes() {
        return genes;
    }

    public void setGenes(List<Gen> genes) {
        this.genes = genes;
    }

    private List<String> getValoresPosibles() {
        return valoresPosibles;
    }

    private void setValoresPosibles(List<String> valoresPosibles) {
        this.valoresPosibles = valoresPosibles;
        this.valoresPosibles.add("A");
        this.valoresPosibles.add("C");
        this.valoresPosibles.add("G");
        this.valoresPosibles.add("T");
    }

    List<Gen> genesIguales(Individuo otroIndividuo) {
        List<Gen> listaGenesIguales= new ArrayList<Gen>();
        int contadorGen=0;
        for (int i=0;i<25000;i++){
            boolean sonIguales=false;
            Gen gen= this.getGenes().get(i);
            while (!sonIguales && contadorGen<otroIndividuo.getGenes().size()){
                Gen otroGen = otroIndividuo.getGenes().get(contadorGen);
                sonIguales=compararGen(gen, otroGen);
                contadorGen++;
            }

            if (sonIguales){
                listaGenesIguales.add(gen);
            }
        }

        return listaGenesIguales;
    }

    private boolean compararGen(Gen genIndividuo, Gen genOtroIndividuo){
        boolean esIgual=false;
        int contador=0;
        if (genIndividuo.getCantidadNucleotidos()==genOtroIndividuo.getCantidadNucleotidos()){
            for (int i=0;i<genIndividuo.getCantidadNucleotidos();i++){
                String nucleotidoIndividuo = genIndividuo.getListaNucleotidos().get(i);
                String nucleotidoOtroIndividuo = genOtroIndividuo.getListaNucleotidos().get(i);
                if(nucleotidoIndividuo==nucleotidoOtroIndividuo){
                    contador++;
                }
            }
            if (contador==genIndividuo.getCantidadNucleotidos()){
                esIgual=true;
            }
        }
        return esIgual;
    }

    private void darValorANucleotidos(){
        setValoresPosibles(this.valoresPosibles);
        for (Gen gen:this.getGenes()){
            for (int i=0;i<=gen.getCantidadNucleotidos()-1;i++){
                Random random = new Random();
                int valor= random.nextInt(getValoresPosibles().size());
                gen.agregarNucleotido(getValoresPosibles().get(valor));
            }
        }
    }

}
