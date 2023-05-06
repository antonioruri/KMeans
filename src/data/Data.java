package data;

import utility.ArraySet;
import java.util.Random;

/**
 * Classe che modella l'insieme di transazioni o tuple
 */
public class Data {

	/**
	 * Numero di tuple distinte nel dataset
	 */
	private int distinctTuple;
	/**
	 * Matrice di <code>Object</code> con numero di righe pari al numero di transazioni da memorizzare
	 * e numero di colonne pari al numero di attributi in ciascuna transazione
	 */
	private Object data[][];

	/**
	 * Cardinalità dell’insieme di transazioni (numero di righe in data)
	 */
	private int numberOfExamples;

	/**
	 * Vettore degli attributi in ciascuna tupla che sono avvalorati in ciscuna transione (schema della tabella di dati)
	 */
	private Attribute attributeSet[];

	/**
	 * Costruttore: inizializza la matrice data [ ][ ] con transazioni di esempio
	 * Inizializza attributeSet creando cinque oggetti di tipo DiscreteAttribute, uno per ciascun attributo
	 * Inizializza numberOfExamples
	 */
	public Data(){
		
		data = new Object[14][5];


		data[0][0]=new String ("sunny");
		data[1][0]=new String ("sunny");
		data[2][0]=new String ("overcast");
		data[3][0]=new String ("rain");
		data[4][0]=new String ("rain");
		data[5][0]=new String ("rain");
		data[6][0]=new String ("overcast");
		data[7][0]=new String ("sunny");
		data[8][0]=new String ("sunny");
		data[9][0]=new String ("rain");
		data[10][0]=new String ("sunny");
		data[11][0]=new String ("overcast");
		data[12][0]=new String ("overcast");
		data[13][0]=new String ("rain");
		
		data[0][1]=new String ("hot");
		data[1][1]=new String ("hot");
		data[2][1]=new String ("hot");
		data[3][1]=new String ("mild");
		data[4][1]=new String ("cool");
		data[5][1]=new String ("cool");
		data[6][1]=new String ("cool");
		data[7][1]=new String ("mild");
		data[8][1]=new String ("cool");
		data[9][1]=new String ("mild");
		data[10][1]=new String ("mild");
		data[11][1]=new String ("mild");
		data[12][1]=new String ("hot");
		data[13][1]=new String ("mild");
		
		data[0][2]=new String ("high");
		data[1][2]=new String ("high");
		data[2][2]=new String ("high");
		data[3][2]=new String ("high");
		data[4][2]=new String ("normal");
		data[5][2]=new String ("normal");
		data[6][2]=new String ("normal");
		data[7][2]=new String ("high");
		data[8][2]=new String ("normal");
		data[9][2]=new String ("normal");
		data[10][2]=new String ("normal");
		data[11][2]=new String ("high");
		data[12][2]=new String ("normal");
		data[13][2]=new String ("high");

		data[0][3]=new String ("weak");
		data[1][3]=new String ("strong");
		data[2][3]=new String ("weak");
		data[3][3]=new String ("weak");
		data[4][3]=new String ("weak");
		data[5][3]=new String ("strong");
		data[6][3]=new String ("strong");
		data[7][3]=new String ("weak");
		data[8][3]=new String ("weak");
		data[9][3]=new String ("weak");
		data[10][3]=new String ("strong");
		data[11][3]=new String ("strong");
		data[12][3]=new String ("weak");
		data[13][3]=new String ("strong");

		data[0][4]=new String ("no");
		data[1][4]=new String ("no");
		data[2][4]=new String ("yes");
		data[3][4]=new String ("yes");
		data[4][4]=new String ("yes");
		data[5][4]=new String ("no");
		data[6][4]=new String ("yes");
		data[7][4]=new String ("no");
		data[8][4]=new String ("yes");
		data[9][4]=new String ("yes");
		data[10][4]=new String ("yes");
		data[11][4]=new String ("yes");
		data[12][4]=new String ("yes");
		data[13][4]=new String ("no");

		// numberOfExamples
		 numberOfExamples=14;		 

		//explanatory Set
		/**
		 * Inizializza attributeSet creando cinque oggetti di tipo <code>DiscreteAttribute</code>, uno per ciascun attributo
		 */
		attributeSet = new Attribute[5];

		/**
		 * Viene avvalorato ciascun elemento di <code>attributeSet</code> con un oggetto della classe <code>DiscreteAttribute</code>
		 * che modella il corrispondente attributo (e.g. outlook, temperature, humidity etc.)
		 */
		String outLookValues[]=new String[3];
		outLookValues[0]="overcast";
		outLookValues[1]="rain";
		outLookValues[2]="sunny";
		attributeSet[0] = new DiscreteAttribute("Outlook",0, outLookValues);

		String temperatureValues[]=new String[3];
		temperatureValues[0]="cool";
		temperatureValues[1]="mild";
		temperatureValues[2]="hot";
		attributeSet[1] = new DiscreteAttribute("Temperature",1, temperatureValues);

		String humidityValues[]=new String[2];
		humidityValues[0]="normal";
		humidityValues[1]="high";
		attributeSet[2] = new DiscreteAttribute("Humidity",2, humidityValues);

		String windValues[]=new String[2];
		windValues[0]="strong";
		windValues[1]="weak";
		attributeSet[3] = new DiscreteAttribute("Wind",3, windValues);

		String playTennisValue[]=new String[2];
		playTennisValue[0]="yes";
		playTennisValue[1]="no";
		attributeSet[4] = new DiscreteAttribute("PlayTennis",4, playTennisValue);

		distinctTuple=countDistinctTuples();
		
	}

	/**
	 * Restituisce il valore del membro <code>numberOfExamples</code>
	 * @return cardilità dell'insieme di transazioni
	 */
	public int getNumberOfExamples(){
		return numberOfExamples;
	}

	/**
	 * Restituisce la cardinalità del membro <code>attributeSet</code>
	 * @return cardinalità dell'insieme degli attributi
	 */
	public int getNumberOfAttributes(){
		return attributeSet.length;
	}

	/**
	* Restituisce attributeSet
	* @return schema dei dati
	*/
	private Attribute[] getAttributeSchema(){
		return attributeSet;
	}
	//TO DO: getAttributeSchema() e getAttribute(int index) sono la stessa cosa?
	// nel pdf c'è scritto getAttributeSchema nella classe data.Data ma nel suo file c'è getAttribute() di tipo Attribute (non è presente getAttributeSchema)

	/**
	 * Restituisce il valore dell'attributo <code>attributeIndex</code> per la tupla <code>exampleIndex</code> memorizzata in data
	 * @param exampleIndex Indice di riga della matrice data[][] che corrisponde ad una determinata transazione
	 * @param attributeIndex Indice di colonna in riferimento alla matrice memorizzata in data
	 * @return Valore assunto dall'attributo identificato da attributeIndex
	 * nella tupla identificata da exampleindex nel membro data
	 */
	public Object getAttributeValue(int exampleIndex, int attributeIndex){
		return data[exampleIndex][attributeIndex];
	}

	/**
	 * Restiusce l'attributo in posizone <code>index</code> di <code>attributeSet</code>
	 * @param index posizione di un attributo in attributeSet
	 * @return attributo con indice index in attributeSet
	 */
	private Attribute getAttribute(int index){
		return attributeSet[index];
	}

	@Override
	public String toString(){
		String table = new String();

		table += getAttribute(0);
		for(int i=1; i < getNumberOfAttributes(); i++){
			table += ","+ getAttribute(i);
		}
		table += "\n";
		for(int i=0; i < getNumberOfExamples(); i++){
			table += i+1+ ": ";
			for(int j=0; j < getNumberOfAttributes(); j++ ){
				table = table +  getAttributeValue(i,j) + (j == attributeSet.length - 1 ? "" : ",");
			}
			table += "\n";
		}
		return table;
	}


	/**
	 * Crea e restituisce un oggetto di <code>data.Tuple</code> che modella
	 * come sequenza di coppie Attributo-valore la i-esima riga in <code>data</code>
	 * @param index indice di riga
	 * @return
	 */
	public Tuple getItemSet(int index){
		Tuple tuple=new Tuple(getNumberOfAttributes());
		for(int i = 0; i < getNumberOfAttributes(); i++)
			tuple.add(new DiscreteItem((DiscreteAttribute) getAttribute(i), (String)getAttributeValue(index,i)), i);
		return tuple;
	}

	/**
	 * Seleziona <code>k</code> centroidi casuali da un insieme di dati, utilizza un oggetto
	 * <code>Random</code> per generare numeri casuali. Per selezionare ogni centroide viene
	 * controllato con un ciclo <code>do-while</code> un numero casuale generato compreso tra 0 e il
	 * numero totale di righe della matrice di dati se corrisponde ad un centroide già selezionato e
	 * memorizzato in <code>centroidIndexes</code>
	 * @param k numero di centroidi casuali da selezionare da un insieme di dati
	 * @throws OutOfRangeSamples se k il numero di cluster da generare è maggiore del numero
	 * di cluster generabili o troppo piccolo
	 * @return array di k interi contenente gli indici di riga in data per le
	 * tuple corrispondenti ai centroidi selezionati
	 */
	public int[] sampling(int k) throws OutOfRangeSamples{
		//choose k random different centroids in data.

		//lancia un'ecczione se k non è valido
		if(k > distinctTuple){
			throw new OutOfRangeSamples("Numero k maggiore del numero di cluster generabili");
		}else if(k <= 0){
				throw new OutOfRangeSamples("Numero k troppo piccolo");
		}


		int centroidIndexes[]=new int[k];
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < k; i++){
			boolean found = false;
			int c;
			do{
				found = false;
				c = rand.nextInt(getNumberOfExamples());
				// verify that centroid[c] is not equal to a centroide already stored in CentroidIndexes
				for(int j = 0; j < i; j++)
					if(compare(centroidIndexes[j],c)){
						found = true;
						break;
					}
			}while(found);
			centroidIndexes[i]=c;
		}
		return centroidIndexes;
	}

	/**
	 * Confronta due tuple del dataset per verificare se sono uguali.
	 * @param i indice di tupla
	 * @param j indice di tupla
	 * @return true se gli elementi delle tuple sono uguali, false altrimenti
	 */
	private boolean compare(int i, int j){
		for(int k = 0; k < getNumberOfAttributes(); k++){
			if(!getAttributeValue(i,k).equals(getAttributeValue(j,k))){
				return false;
			}
		}
		return true;
	}

	/**
	 * Conta il numero di transazioni distinte memorizzate in data.
	 * @return Numero di transazioni distinte
	 */

	private int countDistinctTuples() {
		boolean[] seen = new boolean[getNumberOfExamples()];
		int count = 0;
		for (int i = 0; i < getNumberOfExamples(); i++) {
			if (!seen[i]) {
				count++;
				for (int j = i + 1; j < getNumberOfExamples(); j++) {
					if (!seen[j] && compare(i, j)) {
						seen[j] = true;
					}
				}
			}
			seen[i] = true;
		}
		return count;
	}

	/**
	 * Restituisce computePrototype(idList, (DiscreteAttribute)attribute)
	 * @param idList indici delle tuple da considerare nel calcolo del prototipo
	 * @param attribute attributo rispetto al quale calcolare il prototipo (centroide)
	 * @return valore dell'attributo più frequente
	 */
	Object computePrototype(ArraySet idList, Attribute attribute){
		return computePrototype(idList, (DiscreteAttribute)attribute);
	}

	/**
	 * Restituisce il prototipo di un attributo discreto, calcolato da un insieme di tuple,
	 * corrisponde al valore discreto che compare più frequentemente tra le tuple di <code>idList</code>
	 * @param idList indici delle tuple da considerare nel calcolo del prototipo
	 * @param attribute attributo discreto di cui calcolare il prototipo
	 * @return il valore dell'attributo discreto più frequente
	 */
	private String computePrototype(ArraySet idList, DiscreteAttribute attribute){
		int maxFreq = attribute.frequency(this, idList, attribute.getValue(0));
		int currentFreq;
		String mostFrequentValue = attribute.getValue(0);
		for(int i = 1; i < attribute.getNumberOfDistinctValues(); i++){
			currentFreq = attribute.frequency(this, idList, attribute.getValue(i));
			if(currentFreq > maxFreq){
				maxFreq = currentFreq;
				mostFrequentValue = attribute.getValue(i);
			}
		}
		return mostFrequentValue;
	}

	/**
	 * Metodo main della classe data.Data che consente il test delle classi implementate, permetta la stampa dell'insieme di transazioni.
	 * @param args un array di stringhe contenente gli argomenti passati alla riga di comando.
	 */

	public static void main(String args[]){
		Data trainingSet=new Data();
		System.out.println(trainingSet);

	}

}
