package mining;

import data.Data;
import data.Tuple;

import java.util.HashSet;
import java.util.Set;


/**
 * La classe mining.Cluster rappresenta un cluster, ovvero un gruppo di tuple che sono
 * simili tra di loro, e viene utilizzata per contenere le tuple assegnate ad ogni cluster.
 * Ogni cluster ha un centroide, ovvero un punto nello spazio degli attributi che rappresenta il centro del cluster.
 */
public class Cluster {
	/**
	 * Rappresenta la media delle tuple del cluster
	 */
	private Tuple centroid;
	/**
	 * Insieme di identificatori di tuple che appartengono al cluster
	 */
	private Set<Integer> clusteredData;

	/**
	 * Costruttore di classe. Inizializza il membro <code>centroid</code> con il valore passato in input
	 * e il membro <code>clusteredData</code> con un nuovo oggetto di tipo <code>utility.ArraySet</code>
	 * @param centroid centroide rappresentante la media delle tuple del cluster
	 */
	Cluster(Tuple centroid){
		this.centroid = centroid;
		clusteredData =new HashSet<Integer>();
		
	}

	/**
	 * Restituisce il valore di <code>centroid</code>
	 * @return il valore del centroide
	 */
	Tuple getCentroid(){
		return centroid;
	}

	/**
	 * Calcola il nuovo centroide del cluster
	 * @param data matrice di attributi e valori del dataset
	 */
	void computeCentroid(Data data){
		for(int i = 0; i < centroid.getLength(); i++){
			centroid.get(i).update(data,clusteredData);
		}
		
	}

	/**
	 *  Aggiunge una tupla al cluster corrente
	 * @param id indice della tupla da aggiungere
	 * @return true se la tupla è aggiunta con successo, false altrimenti
	 */
	boolean addData(int id){
		return clusteredData.add(id);
		
	}

	/**
	 * Controlla se la tupla è presente nel cluster
	 * @param id indice della tupla da cercare
	 * @return true se la tupla è presente, false altrimenti
	 */
	boolean contain(int id){
		return clusteredData.contains(id);
	}


	/**
	 * Rimuove la tupla dal cluster
	 * @param id indice della tupla da rimuovere
	 */
	void removeTuple(int id){
		clusteredData.remove(id);
		
	}

	/**
	 * Restituisce una rappresentazione testuale del centroide
	 * @return riga testuale del centroide
	 */
	@Override
	public String toString(){
		String str = "Centroid=(";
		for(int i = 0; i < centroid.getLength(); i++)
			str+=" "+centroid.get(i);
		str+=")";
		return str;
		
	}

	/**
	 * Ovverride del metodo String, restituisce una rappresetazione testuale del cluster
	 * e i suoi dati clusterizzati, mostrando anche la distanza media tra i dati del cluster e il centroide
	 * @param data oggetto contenente gli esempi del dataset
	 * @return stringa del cluster e distanza media
	 */
	
	public String toString(Data data){
		String str = "Centroid=( ";
		for(int i = 0; i < centroid.getLength(); i++)
			str += centroid.get(i)+ " ";
		str += ")\n\nExamples:\n";
		Integer array[]= new Integer[clusteredData.size()];
		clusteredData.toArray(array);
		for(int i = 0; i<array.length;  i++){
			str+="[";
			for( int j=0;j<data.getNumberOfAttributes(); j++)
				str += data.getAttributeValue(array[i], j)+ " ";
			str += "] dist="+getCentroid().getDistance(data.getItemSet(array[i])) + "\n";
			
		}
		str += "\nAvgDistance=" + getCentroid().avgDistance(data, array)+"\n";
		return str;
		
	}
}
