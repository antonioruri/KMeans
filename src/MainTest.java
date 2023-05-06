import data.Data;
import mining.KMeansMiner;
import keyboardinput.Keyboard;
import data.OutOfRangeSamples;


public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args){

		Data data = new Data();
		System.out.println(data);
		do{
			System.out.println("Inserire il numero di k: ");
			try {
				int num = Keyboard.readInt();
				KMeansMiner kmeans = new KMeansMiner(num);
				int countIter = kmeans.kmeans(data);

				System.out.println("Numero di Iterazione:" + countIter);
				System.out.println(kmeans.getC().toString(data));
			}catch (OutOfRangeSamples error){
				System.err.println(error);

			}
			System.out.println("Vuoi ripetere l'opearazione? y/n: ");
		} while (Keyboard.readChar() == 'y');
	}
}
