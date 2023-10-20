import data.Data;
import mining.KMeansMiner;
import static keyboardinput.Keyboard.*;
import data.OutOfRangeSamples;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws OutOfRangeSamples {

		Data data = new Data();
		System.out.println(data);
		char scelta,c;
		do{
			System.out.println("Vuoi caricare l'ultimo salvataggio? y/n ");
			scelta = readChar();
			switch (scelta) {
				case 'y':
					try {
						KMeansMiner kmeans = new KMeansMiner("data.dat");
						System.out.println(kmeans.getC().toString(data));
					} catch (FileNotFoundException fl) {
						System.out.println(fl);
					} catch (IOException io) {
						System.out.println(io);
					} catch (ClassNotFoundException io) {
						System.out.println(io);
					}
					break;
				case 'n':

					System.out.println("Inserire il numero di k: ");
					int num = readInt();
					KMeansMiner kmeans = new KMeansMiner(num);
					try {
						int countIter = kmeans.kmeans(data);
						System.out.println("Numero di Iterazione:" + countIter);
						System.out.println(kmeans.getC().toString(data));
					} catch (OutOfRangeSamples error) {
						System.err.println(error);
					}
					try {
						kmeans.salva("data.dat");
					}catch (FileNotFoundException f){
						System.out.println("f");
					}catch (IOException io){
						System.out.println(io);
					}
					break;
				default:
					System.out.println("Carattere non valido");
					break;
			}
			do{
				System.out.println("Vuoi ripetere l'opearazione? y/n: ");
				c=readChar();
				if(c!='y' && c!='n');
			}while(c!= 'y' && c!= 'n');
		} while (c == 'y');
	}
}

//Ho aggiustato il fatto della serializzazione che non andava. SPOILER: non andava perché non salvavo,
//quindi per forza non potevo caricare qualcosa che non era salvato e mi dava errore, genio.
