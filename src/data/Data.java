package data;
//TO DO: Modificare e aggiungere Javadocs
import java.util.*;

/**
 * La classe Data rappresenta un insieme di dati organzzati in forma taballare con righe che rappresentano
 * le transazioni o tuple, e colonne che rappresentano gli attributi avvalorati
 */
public class Data {

	/**
	 * Inner class Example modella ciascuna singola transazione o tupla
	 * implementa l'intergaccia generica Comparable
	 */
	class Example implements Comparable<Example>{

		/**
		 * ArrayList di Object che rappresentano la singola transazione (o riga di una tabella)
		 */
		private List<Object> example = new ArrayList<Object>();

		/**
		 * Aggiunge l'elemento passato in input in coda ad alla Lista example
		 * @param o elemento da aggiungere in coda alla lista
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
		 * Confronta l'oggetto this con l'oggetto Example passato in input.
		 * Restituisce 0, -1, 1 sulla base del risultato del confronto. 0 se i due esempi includono gli stessi valori.
		 * Altrimenti restituisce il risultato del compareTo() invocato sulla prima coppia di valori in disaccordo.
		 * @param ex lista da confrontare
		 * @return 0 se i valori sono uguali. ALtrimenti -1 o 1 sulla base del risultato del confronto.
		 */
		public int compareTo(Example ex) {
			int i=0;
			for(Object o : ex.example){
				if(!o.equals(this.example.get(i))) {
					if (((Comparable) o).compareTo(this.example.get(i)) > 0)
						return 1;
					else
						return -1;
				}
				i++;
			}
			return 0;

		}

		/**
		 * Restituisce una stringa che descrive lo stato delle tuple
		 * @return una stringa che rappresenta lo stato di example
		 */
		@Override
		public String toString(){
			String str = new String();
			for(Object e : this.example)
				str += e.toString()+" ";
			return str;
		}
	}
	//rimuovere questa classe ed utilizzare quella di database.Example
	//per prendere esempi da un database

	/**
	 * Lista di {@code Example}, rappresenta le transazioni memorizzate
	 */
	private List<Example> data;

	/**
	 * Cardinalità dell’insieme di transazioni
	 */
	private int numberOfExamples;

	/**
	 * Lista di {@code Attribute}, rappresenta gli Attributi modellati nel trainingSet
	 */
	private List<Attribute> attributeSet;

	/**
	 * Costruttore della classe, inizializza i membri dell'ArrayList data con tuple di esempio.
	 * Viene usato per questo un {@code TreeSet<>} per avere elementi ordinati e non duplicati.
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
		 * Viene avvalorato ciascun elemento di {@code attributeSet} con un oggetto {@code DiscreteAttribute}
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
	 * Restituisce la cardinalità dell'insieme di transazioni
	 * @return cardilità dell'insieme di transazioni
	 */
	public int getNumberOfExamples(){
		return numberOfExamples;
	}

	/**
	 * Restituisce la cardinalità dell'insieme degli attributi
	 * @return cardinalità dell'insieme degli attributi
	 */
	public int getNumberOfAttributes(){
		return attributeSet.size();
	}

	/**
	 * Restituisce il valore dell'attributo specificato nella tupla specificata memorizzata in data
	 * @param exampleIndex Indice della tupla specificata
	 * @param attributeIndex Indice dell'attributo specificato
	 * @return Valore memorizzato in data dall'attributo identificato da attributeIndex
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
		for(Attribute a : attributeSet){
			table += a + ",";
		}
		table = table.substring(0, table.length() - 1); //Rimuove la virgola in eccesso
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
	 * Crea e restituisce un oggetto di Tuple che modella come sequenza
	 * di coppie Attributo-valore la i-esima riga in data.
	 * @param index indice di riga
	 * @return un oggetto di Tuple che modella come sequenza
	 * di coppie Attributo-valore la i-esima riga in data.
	 */
	public Tuple getItemSet(int index) {
		Tuple tuple = new Tuple(getNumberOfAttributes());
		for (int i = 0; i < getNumberOfAttributes(); i++)
			if (getAttribute(i) instanceof DiscreteAttribute)
				tuple.add(new DiscreteItem((DiscreteAttribute) getAttribute(i), (String) getAttributeValue(index,i)),i);
			else
				tuple.add(new ContinuousItem(getAttribute(i),(Double) getAttributeValue(index,i)),i);
		return tuple;
	}

	/**
	 * Seleziona k centroidi casuali con l'utilizzo della classa {@code Random} generando un numero
	 * compreso tra 0 e il numero totale di tuple memorizzate.Verifica se il centroide trovato è già memorizzato,
	 * in caso negativo viene memorizzato in in array di interi l'indice del centroide.
	 * @param k numero di centroidi casuali da selezionare
	 * @throws OutOfRangeSamples se k il numero di cluster da generare è maggiore del numero
	 * di cluster generabili o uguale a 0
	 * @return array di k interi contenente gli indici delle tuple corrispondenti ai centroidi selezionati
	 */
	public int[] sampling(int k) throws OutOfRangeSamples{

		if( k == 0 || k > getNumberOfExamples()){
			throw new OutOfRangeSamples("Numero di cluster inserito non valido. Inserire un valore compreso tra 1 e " + getNumberOfExamples() + ".");
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
	 * Confronta due tuple specificate per verificare se sono uguali.
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
	 * Viene utilizzato l'RTTI per calcolare il valore prototipo corrispondente ad una istanza dell' attributo specificato (discreto o continuo)
	 */
	Object computePrototype(Set<Integer> idList, Attribute attribute){
		if(attribute instanceof DiscreteAttribute)
			return computePrototype(idList, (DiscreteAttribute) attribute);
		else
			return computePrototype(idList, (ContinuousAttribute) attribute);
	}

	/**
	 * Determina il valore prototipo come la media dei valori dell'attributo
	 * continuo specificato nelle transazioni di data aventi indice in idList
	 * @param idList insieme degli indici delle tuple su cui calcolare la media
	 * @param attribute attributo continuo specificato
	 * @return la media dei valori dell'attributo specificato nelle transazioni indicate.
	 */
	Double computePrototype(Set<Integer> idList, ContinuousAttribute attribute){
		double media=0.0;
		for(int i : idList){
			media += (double) data.get(i).get(attribute.getIndex());
		}
		return media / (double) idList.size();
	}


	/**
	 * Restituisce il valore prototipo di un attributo discreto, calcolato da un insieme di tuple,
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
	 * Metodo main della classe Data che consente il test delle classi implementate, permetta la stampa dell'insieme di transazioni.
	 * @param args un array di stringhe contenente gli argomenti passati alla riga di comando.
	 */

	public static void main(String args[]){
		Data trainingSet = new Data();
		System.out.println(trainingSet);

	}

}
