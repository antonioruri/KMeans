package mining;

import data.Data;
import data.OutOfRangeSamples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class KMeansMiner implements Serializable {
    ClusterSet C;

    public KMeansMiner(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream inFile = new FileInputStream(fileName);
        ObjectInputStream inStream = new ObjectInputStream(inFile);
        KMeansMiner k = (KMeansMiner) inStream.readObject();
        C=k.getC();
        inStream.close();
    }

    public void salva(String filename) throws FileNotFoundException, IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(this);
        out.close();
    }

    public KMeansMiner(int k) throws OutOfRangeSamples {
        if(k < 0)
           throw new OutOfRangeSamples("Il numero di cluster non può essere negativo");
        C = new ClusterSet(k);
    }

    public ClusterSet getC(){
        return C;
    }

    public int kmeans(Data data) throws OutOfRangeSamples {
        int numberOfIterations=0;
        //STEP 1
        C.initializeCentroids(data);
        boolean changedCluster = false;
        do{
            numberOfIterations++;
            //STEP 2
            changedCluster=false;
            for(int i=0;i<data.getNumberOfExamples();i++){

                Cluster nearestCluster = C.nearestCluster(data.getItemSet(i));
                Cluster oldCluster=C.currentCluster(i);
                boolean currentChange=nearestCluster.addData(i);
                if(currentChange)
                    changedCluster=true;
                //rimuovo la tupla dal vecchio cluster
                if(currentChange && oldCluster!=null)
                    oldCluster.removeTuple(i); //il nodo va rimosso dal suo vecchio cluster
            }
            //STEP 3
            C.updateCentroids(data);
        }while(changedCluster);
        return numberOfIterations;
    }

}


