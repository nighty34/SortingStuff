/**
 MergeSort

 @Author:   Sairam Vijayakumar
 @Date:     23.01.2020
 @Version:  2.0
 */
public class MergeSort extends SortierAlgorithmen {

    //In Main wird Array[l..r] sortiert durch merge()
    void mergeSort(int arr[], int l, int r) {
        counterV++;
        if (l < r) {
            //finde die Mitte
            int m = (l+r)/2;
            //sortiert erste und zweite Hälften
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            //Zusammenführen der sortierten Hälften
            merge(arr, l, m, r);
        }
    }

    void merge(int arr[], int l, int m, int r) {
        // Finden Sie Größen von zwei zusammenzuführenden Subarrays
        int n1 = m - l + 1;
        int n2 = r - m;
        //Temporäre Arrays erstellen
        int L[] = new int [n1];
        int R[] = new int [n2];
        //Daten in temporäre Arrays kopieren
        for (int i=0; i<n1; ++i) {
            L[i] = arr[l + i];
            counterS++;
        }
        for (int j=0; j<n2; ++j){
            counterS++;
            R[j] = arr[m + 1+ j];
        }

        //Zusammenführen der Temporären Arrays

        //Intialisieren der ersten und zweiten Subarrays
        int i = 0, j = 0;
        //Initialisiere index des zusammengeführten Subarrys
        int k = l;
        while (i < n1 && j < n2) {
            counterS++;
            counterV++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // kopiren der restlichen Elemente von L[]
        while (i < n1) {
            counterS++;
            arr[k] = L[i];
            i++;
            k++;
        }
        // kopieren der restlichen Elemente von L[]
        while (j < n2) {
            counterS++;
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void sort(int[] array) {
        counterS = 0;
        counterV = 0;
        long startTime = System.nanoTime();
        mergeSort(array, 0, array.length-1);
        long endTime = System.nanoTime();
        dataArray[0] = counterS;
        dataArray[1] = (int) (endTime-startTime) / 1000;
        dataArray[2] = counterV;
    }
}
