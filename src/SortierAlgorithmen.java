/**
 Oberklasse für die Sortieralgorithmen.

 @Author:   Felix Reiniger , Noah Altenburger
 @Date:     23.01.2020
 @Version:  V1.1
 */
public abstract class SortierAlgorithmen {
    protected int counterS; //Anzahl Schleifendurchgänge
    protected int counterV; //Anzahl Vergleiche
    protected int duration; //Dauer
    protected int[] dataArray = {counterS, duration, counterV}; //Zusammenfassung der durchgeführeten Test | [0] = SchleifenCnt, [1] = Zeit, [2] = SwapCnt

    /**
     * Hauptaufruf des Algorithmus
     * @param array das zu sortierende Array
     */
    public abstract void sort(int[] array);


    public int[] getDataArray() {
        return dataArray;
    }
}