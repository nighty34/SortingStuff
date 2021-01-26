/**
 Tester - Prüfung03 | SortierAlgorithmen

 @Author:   Felix Reiniger
 @Date:     16/01/2020
 @Version:  1.0
 */
import java.util.ArrayList;
import java.util.List;

public class Tester {

    private List<SortierAlgorithmen> data; //Liste für die Referenzen aller Algorithmen
    private Displayer display; //Display referenz
    private int[] maxWert; //Array für die maxWerte


    /**
     * Constructor
     */
    public Tester(){
        this.display = new Displayer();
        this.data = new ArrayList<>();
        maxWert = new int[3];
    }


    /**
     * Ruft die einzelnen Algorithmen auf und führt diese aus
     * @param array das Array, welches zum Testen genutzt wird
     * @param name Name des zu testenden Algorithmus
     */
    public void test(int[] array, String name){
        SortierAlgorithmen algorithmus = getAlg(name);
        String output = "";

        if(algorithmus != null) {   //Wenn algorithmus = null dann alle Testen sonst nur die Referez (agorithmus) testen
            algorithmus.sort(array);
            calcMax(algorithmus.getDataArray());
            data.add(algorithmus);

            display.printData(algorithmus, maxWert);
            display.printTable(algorithmus);
        }else{
            for (SortierAlgorithmen s:data) {
                s.sort(array.clone());
                calcMax(s.getDataArray()); //calcMax for analyizing
            }

            for (SortierAlgorithmen s:data) {
                display.printData(s, maxWert);
                output = output + display.printTable(s) + "\n";
            }
            System.out.println("\n\n Name          Zeit    Schleifendurchläufe   Swaps"); //Tabellen Header
            System.out.println(output);
        }
    }


    /**
     * Fügt einen Algorithmus in die data liste hinzu
     * @param algorithmen Referenz zu dem Algorithmus
     */
    public void addSortAlg(SortierAlgorithmen algorithmen){
        data.add(algorithmen);
    }


    /**
     * Gibt die Referenz für einen Algorithmus zurück nach Namen.
     * @param name Name des gesuchten Algorithmus
     * @return  Referenz zum Algorithmus
     */
    private SortierAlgorithmen getAlg(String name){
        for (SortierAlgorithmen s:data) {
            if(s.getClass().getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Ermittelt den MaximalWert alles Tests
     * @param data  data Array des getesteten Sortieralgorithmus
     */
    private void calcMax(int[] data){
        for(int i=0; i<data.length; i++){
            if(data[i]>maxWert[i]){
                maxWert[i]=data[i];
            }
        }
    }
}
