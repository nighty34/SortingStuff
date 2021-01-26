/**
 Dieser Code sortiert Werte mithilfe des InsertionSort Algorithmus.

 @Author:   Noah Altenburger
 @Date:     23.01.2020
 @Version:  V1.3
 */
public class InsertionSort extends SortierAlgorithmen {

    public void sort(int array[]){
        long startTime = System.nanoTime(); //Startzeit wird gespeichert.
        int letzteZ = array.length; //Der letzte Array
        for(int i = 1; i < letzteZ; i++){ //Geht jede Zahl im Array durch
            counterS++;
            int aZahl = array[i]; //Aktuelle Zahl wird zwischengespeichert
            int lZahl = i - 1; //Zahl vor der aktuellen Zahl

            while(lZahl >= 0 && array[lZahl] > aZahl){ //Solange die aktuelle nicht die letzte und nicht grösser als die Zahl bevor ist.
                dataArray[0]++; //Anzahl Schlaufendurchläufe
                dataArray[2]++; //Anzahl Vergleiche erhöht sich.
                array[lZahl + 1] = array[lZahl]; //Die grössere Zahl wird an Position der aktuellen Zahl gespeichert.
                lZahl = lZahl - 1; //Die nächste Zahl wird mit der aktuellen Zahl verglichen.
            }
            counterV++;
            array[lZahl + 1] = aZahl; //Die aktuelle Zahl wird am Platz von der letzten verglichenen Zahl gespeichert.
        }
        long endTime = System.nanoTime(); //Die Endzeit wird gespeichert.
        dataArray[1] = (int)(endTime - startTime) / 1000;// Der Unterschied zwischen der Start und Endzeit wird ausgerechnet, in Milisekunden umgewandelt und in einem Integer umgewandelt.
    }
}
