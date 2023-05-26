package mining;

import data.Data;
import data.OutOfRangeSamples;

public class KMeansMiner {
    ClusterSet C;

    public KMeansMiner(int k) throws OutOfRangeSamples {
        if(k < 0)
           throw new OutOfRangeSamples("Il numero di cluster non può essere negativo");
        C = new ClusterSet(k);
    }

    public ClusterSet getC(){
        return C;
    }

    public int kmeans(Data data) throws OutOfRangeSamples {
        //System.out.println("qua");
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


