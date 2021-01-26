/**
 Displayer - Prüfung03 | SortierAlgorithmen

 @Author:   Felix Reiniger
 @Date:     23/01/2020
 @Version:  1.0
 */

public class Displayer {

    private static final double DATALENGHT = 50;

    public Displayer(){
    }


    /**
     * Stellt ein Produkt zum Test eines Algorithmus zusammen.
     * @param s         Referenz zum getesteten Algrorithmus
     * @param maxWert   Array mit den maximalen Werten aller Tests
     */
    public void printData(SortierAlgorithmen s, int[] maxWert){
        System.out.println("\n" + s.getClass().getName());
        System.out.println("Schleifendurchläufe:" + fillString(24, (int) DATALENGHT) + s.dataArray[0]);
        printStatistic(s.getDataArray(), 0, maxWert[0]);
        System.out.println("Zeit (Mikrosekunden):" + fillString(25, (int) DATALENGHT) + s.dataArray[1]);
        printStatistic(s.getDataArray(), 1, maxWert[1]);
        System.out.println("Swaps:" + fillString(10, (int) DATALENGHT)+  s.dataArray[2]);
        printStatistic(s.getDataArray(), 2, maxWert[2]);
    }


    /**
     * Gibt einen Effektivitätsstrahl aus
     * @param data  datenArray mit den Ergebnisen der Tests
     * @param index index des darzustellenden Wertes
     * @param max   der maximale Wert des Tests
     */
    private void printStatistic(int[] data, int index, int max){
        double pro = data[index]*DATALENGHT/max; //Calcs: value/overAllMaxValue*Beamlenght

        System.out.print("[");
        for(int i  = (int) pro; i>0; i--){
            System.out.print("=");
        }
        for(int i = (int) pro; i<DATALENGHT; i++){
            System.out.print("-");
        }
        System.out.println("]") ;
    }


    /**
     *  Gibt einen String mit Leerzeichen aus (Format)
     * @param already   länge des bereits exestierenden Strings
     * @param max       maximale länge
     * @return          String mit den fehlenden Leerzeichen
     */
    private String fillString(int already, int max){
        String output = "";
        for(int i = 0; i<max-already-String.valueOf(already).length(); i++){
            output = output + " ";
        }
        return output;
    }

    /**
     * Gibt eine Zeile einer Tabelle aus
     * @param s Referenz Algorithmus
     * @return  Tabellen String
     */
    public String printTable(SortierAlgorithmen s){
        int[] data = s.getDataArray();
        return " " + s.getClass().getName() + fillString(s.getClass().getName().length(), 14) +  " | " + data[1] +
                fillString(String.valueOf(data[1]).length(), 5) + " | " + data[0] + fillString(String.valueOf(data[0]).length(), 20)
                + " | " + data[2] + fillString(String.valueOf(data[2]).length(), 6);
    }

}
