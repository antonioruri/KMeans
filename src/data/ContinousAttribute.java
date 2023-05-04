package data;


/**
 * Estende la classe data.Attribute e modella un attributo continuo. Include i metodi per la “normalizzazione”
 * del dominio dell'attributo nell'intervallo [0,1]
 * al fine da rendere confrontabili attributi aventi domini diversi
 */
class ContinousAttribute extends Attribute {

    //estremi dell'intervallo di valori (dominio) che l'attributo può reamente assumere
    /**
     * Estremo destro del dominio
     */
    private double max;

    /**
     * Estremo sinistro del dominio
     */
    private double min;

    /**
     * Costruttore: Invoca il costruttore della superclasse e
     * avvalora i membri min e max aggiunti per estensione con i parametri in input
     * @param name nome simbolico dell'attributo
     * @param index identificativo numerico dell'attributo
     * @param min estremo sinistro dell'intervallo di dominio dell'attributo
     * @param max estremo destro dell'intervallo di dominio dell'attributo
     */
    private ContinousAttribute(String name, int index, double min, double max){
        super(name,index);
        this.min = min;
        this.max = max;
    }

    /**
     * Calcola e restituisce il valore normalizzato del parametro passato in input.
     * La normalizzazione ha come codominio l'intervallo [0,1]
     * @param v valore da normalizzare
     * @return valore normalizzato
     */
    private double getScaledValue(double v){
        return (v-min)/(max-min);
    }

}
