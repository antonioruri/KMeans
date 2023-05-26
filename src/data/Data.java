package data;
//TO DO: Modificare e aggiungere Javadocs
import java.util.*;

/**
 * Classe che modella l'insieme di transazioni o tuple
 */
public class Data {
	class Example implements Comparable<Example>{

		/**
		 * Array di object che rappresentano la singola transazione (o riga di una tabella)
		 */
		private List<Object> example = new ArrayList<Object>();

		/**
		 * Aggiunge in coda ad example
		 * @param o membro da aggiungere in coda
		 */
		void add(Object o){
			example.add(o);
		}

		/**
		 * Restituisce l'elemento alla posizione specificata nella lista
		 * @param i indice dell'elemento da restituire
		 * @return l'elemento alla posizione specificata nella lista
		 */
		private Object get(int i){
			return example.get(i);
		}

		/**
		 * Restituisce 0, -1, 1 sulla base del risultato del confronto. 0 se i due esempi includono gli stessi valori.
		 * Altrimenti il risultato del compareTo(...) invocato sulla prima coppia di valori in disaccordo.
		 * @param ex lista da confrontare
		 * @return 0 se i valori sono uguali. ALtrimenti -1 o 1 sulla base del risultato de l confronto.
		 */
		public int compareTo(Example ex) {
			Iterator<Object> thisIt = this.example.iterator();
			Iterator<Object> exIt = ex.example.iterator();

			while(thisIt.hasNext() && exIt.hasNext()) {
				Object thisObj = thisIt.next();
				Object exObj = exIt.next();

				if (!thisObj.equals(exObj)) {
					if( ((Comparable) thisObj).compareTo(exObj) > 1)
						return 1;
					else
						return -1;
				}
			}
			return 0;
		}

		@Override
		public String toString(){
			String str = new String();
			for(Object e : this.example)
				str += e.toString()+" ";
			return str;
		}
	}


	/**
	 * Matrice di <code>Object</code> con numero di righe pari al numero di transazioni da memorizzare
	 * e numero di colonne pari al numero di attributi in ciascuna transazione
	 */
	private List<Example> data;

	/**
	 * Cardinalità dell’insieme di transazioni (numero di righe in data)
	 */
	private int numberOfExamples;

	/**
	 * Vettore degli attributi in ciascuna tupla che sono avvalorati in ciscuna transione (schema della tabella di dati)
	 */
	private List<Attribute> attributeSet;

	/**
	 * Costruttore: inizializza la matrice data [ ][ ] con transazioni di esempio
	 * Inizializza attributeSet creando cinque oggetti di tipo DiscreteAttribute, uno per ciascun attributo
	 * Inizializza numberOfExamples
	 */
	public Data(){
		
		//data = new Object[14][5];
		TreeSet<Example> tempData = new TreeSet<Example>();

		Example ex0 = new Example();
		Example ex1 = new Example();
		Example ex2 = new Example();
		Example ex3 = new Example();
		Example ex4 = new Example();
		Example ex5 = new Example();
		Example ex6 = new Example();
		Example ex7 = new Example();
		Example ex8 = new Example();
		Example ex9 = new Example();
		Example ex10 = new Example();
		Example ex11 = new Example();
		Example ex12 = new Example();
		Example ex13 = new Example();

		ex0.add("sunny");
		ex1.add("sunny");
		ex2.add("overcast");
		ex3.add("rain");
		ex4.add("rain");
		ex5.add("rain");
		ex6.add("overcast");
		ex7.add("sunny");
		ex8.add("sunny");
		ex9.add("rain");
		ex10.add("sunny");
		ex11.add("overcast");
		ex12.add("overcast");
		ex13.add("rain");

		ex0.add(37.5);
		ex1.add(38.7);
		ex2.add(37.5);
		ex3.add(20.5);
		ex4.add(20.7);
		ex5.add(21.2);
		ex6.add(20.5);
		ex7.add(21.2);
		ex8.add(21.2);
		ex9.add(19.8);
		ex10.add(3.5);
		ex11.add(3.6);
		ex12.add(3.5);
		ex13.add(3.2);

		ex0.add("high");
		ex1.add("high");
		ex2.add("high");
		ex3.add("high");
		ex4.add("normal");
		ex5.add("normal");
		ex6.add("normal");
		ex7.add("high");
		ex8.add("normal");
		ex9.add("normal");
		ex10.add("normal");
		ex11.add("high");
		ex12.add("normal");
		ex13.add("high");

		ex0.add("weak");
		ex1.add("strong");
		ex2.add("weak");
		ex3.add("weak");
		ex4.add("weak");
		ex5.add("strong");
		ex6.add("strong");
		ex7.add("weak");
		ex8.add("weak");
		ex9.add("weak");
		ex10.add("strong");
		ex11.add("strong");
		ex12.add("weak");
		ex13.add("strong");

		ex0.add("no");
		ex1.add("no");
		ex2.add("yes");
		ex3.add("yes");
		ex4.add("yes");
		ex5.add("no");
		ex6.add("yes");
		ex7.add("no");
		ex8.add("yes");
		ex9.add("yes");
		ex10.add("yes");
		ex11.add("yes");
		ex12.add("yes");
		ex13.add("no");

		tempData.add(ex0);
		tempData.add(ex1);
		tempData.add(ex2);
		tempData.add(ex3);
		tempData.add(ex4);
		tempData.add(ex5);
		tempData.add(ex6);
		tempData.add(ex7);
		tempData.add(ex8);
		tempData.add(ex9);
		tempData.add(ex10);
		tempData.add(ex11);
		tempData.add(ex12);
		tempData.add(ex13);

		data = new ArrayList<Example>(tempData);
		numberOfExamples = tempData.size();

		attributeSet = new LinkedList<>();


		/**
		 * Viene avvalorato ciascun elemento di <code>attributeSet</code> con un oggetto della classe <code>DiscreteAttribute</code>
		 * che modella il corrispondente attributo (e.g. outlook, temperature, humidity etc.)
		 */
		TreeSet<String> outLookValues = new TreeSet<String>();
		outLookValues.add("overcast");
		outLookValues.add("rain");
		outLookValues.add("sunny");
		attributeSet.add(new DiscreteAttribute("Outlook",0, outLookValues));

		attributeSet.add(new ContinuousAttribute("Temperature",1, 3.2,38.7));

		TreeSet<String> humidityValues = new TreeSet<String>();
		humidityValues.add("normal");
		humidityValues.add("high");
		attributeSet.add(new DiscreteAttribute("Humidity",2, humidityValues));

		TreeSet<String> windValues = new TreeSet<>();
		windValues.add("strong");
		windValues.add("weak");
		attributeSet.add(new DiscreteAttribute("Wind",3, windValues));

		TreeSet<String> playTennisValue =new TreeSet<>();
		playTennisValue.add("yes");
		playTennisValue.add("no");
		attributeSet.add(new DiscreteAttribute("PlayTennis",4, playTennisValue));
		
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
		return attributeSet.size();
	}

	/**
	 * Restituisce il valore dell'attributo <code>attributeIndex</code> per la tupla <code>exampleIndex</code> memorizzata in data
	 * @param exampleIndex Indice di riga della matrice data[][] che corrisponde ad una determinata transazione
	 * @param attributeIndex Indice di colonna in riferimento alla matrice memorizzata in data
	 * @return Valore assunto dall'attributo identificato da attributeIndex
	 * nella tupla identificata da exampleindex nel membro data
	 */
	public Object getAttributeValue(int exampleIndex, int attributeIndex){
		return data.get(exampleIndex).get(attributeIndex);
	}

	/**
	 * Restiusce l'attributo in posizone index di attributeSet
	 * @param index posizione di un attributo in attributeSet
	 * @return attributo con indice index in attributeSet
	 */
	private Attribute getAttribute(int index){
		return attributeSet.get(index);
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
				table = table +  getAttributeValue(i,j) + (j == getNumberOfAttributes() - 1 ? "" : ",");
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
	public Tuple getItemSet(int index) {
		Tuple tuple = new Tuple(getNumberOfAttributes());
		for (int i = 0; i < getNumberOfAttributes(); i++)
			if (getAttribute(i) instanceof DiscreteAttribute)
				tuple.add(new DiscreteItem((DiscreteAttribute) getAttribute(i), (String) getAttributeValue(index, i)), i);
			else //if(getAttribute(i) instanceof ContinuousAttribute)
				tuple.add(new ContinuousItem((ContinuousAttribute) getAttribute(i),(Double) getAttributeValue(index,i)),i);
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
		if(k > getNumberOfExamples()){
			throw new OutOfRangeSamples("Numero k maggiore del numero di cluster generabili");
		}else if(k == 0){
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
	 * Restituisce computePrototype(idList, (DiscreteAttribute)attribute)
	 * @param idList indici delle tuple da considerare nel calcolo del prototipo
	 * @param attribute attributo rispetto al quale calcolare il prototipo (centroide)
	 * @return valore dell'attributo più frequente
	 */
	Object computePrototype(Set<Integer> idList, Attribute attribute){
		if(attribute instanceof DiscreteAttribute)
			return computePrototype(idList, (DiscreteAttribute) attribute);
		else
			return computePrototype(idList, (ContinuousAttribute) attribute);
	}

	Double computePrototype(Set<Integer> idList, ContinuousAttribute attribute){
		double media=0.0;
		for(int i : idList){
			media += (double) data.get(i).get(attribute.getIndex());
		}
		return media / (double) idList.size();
	}


	/**
	 * Restituisce il prototipo di un attributo discreto, calcolato da un insieme di tuple,
	 * corrisponde al valore discreto che compare più frequentemente tra le tuple di <code>idList</code>
	 * @param idList indici delle tuple da considerare nel calcolo del prototipo
	 * @param attribute attributo discreto di cui calcolare il prototipo
	 * @return il valore dell'attributo discreto più frequente
	 */
	private String computePrototype(Set<Integer> idList,DiscreteAttribute attribute) {
		String mostFrequentValue = "";
		String currentValue;
		int maxFreq=0;
		int currentFreq;
		for(String v : attribute) {
			currentFreq=attribute.frequency(this, idList, v);
			currentValue=v;
			if(currentFreq>=maxFreq) {
				maxFreq=currentFreq;
				mostFrequentValue=currentValue;
			}
		}
		return mostFrequentValue;
	}

	/**
	 * Metodo main della classe data.Data che consente il test delle classi implementate, permetta la stampa dell'insieme di transazioni.
	 * @param args un array di stringhe contenente gli argomenti passati alla riga di comando.
	 */

	public static void main(String args[]){
		Data trainingSet = new Data();
		System.out.println(trainingSet);

	}

}
