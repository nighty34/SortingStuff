/**
 QuickSort - Prüfung03 | SortierAlgorithmen

 @Author:   Felix Reiniger
 @Date:     23/01/2020
 @Version:  1.0
 */

public class QuickSort extends SortierAlgorithmen{

    public QuickSort(){

    }

    public void sort(int[] array) {
        long startTime = System.nanoTime(); //start Zeitmessung
        quicksort(0, array.length-1, array);
        long endTime = System.nanoTime(); //ende Zeitmessung
        dataArray[1] = (int) (endTime - startTime)/1000;
    }


    private void quicksort(int low, int high, int[] array) {
        int i = low, j = high;

        int pivot = array[low + (high - low) / 2]; //Definiere Pivot
        while (i <= j) {
            while (array[i] < pivot) { //suche nach Zahl grösser als pivot
                dataArray[0]++;
                i++;
            }
            while (array[j] > pivot) { //suche nach Zahl kleiner als pivot
                dataArray[0]++;
                j--;
            }
            if (i <= j) {               //wenn i kleiner/gleich j ist tausche tausche i mit j
                exchange(i, j, array);
                i++;
                j--;
            }
        }
        if (low < j)                    //rekursiver Aufruf der subarrays wenn low kleiner als j
            quicksort(low, j, array);
        if (i < high)
            quicksort(i, high, array);         //rekursiver Aufruf der subarrays wenn i kleiner als high
    }


    /**
     * Tauscht position i mit j in array
     * @param i Position der zu tauschenden Stelle
     * @param j Position der zu tauschenden Stelle
     * @param array Array in welchem getauscht werden soll
     */
    private void exchange(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        dataArray[2]++;
    }

}
