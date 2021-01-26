/**
 BubbleSort - Prüfung03 | SortierAlgorithmen

 @Author:   Felix Reiniger
 @Date:     23/01/2020
 @Version:  1.0
 */
public class BubbleSort extends SortierAlgorithmen{


    public BubbleSort(){
    }

    public void sort(int[] intArray) {
        long startTime = System.nanoTime();//start Zeitmessung
        Boolean fertig = false;
        int j = intArray.length;
        while(!fertig){
            fertig = true;
            for(int i = 0; i < j-1; i++){
                dataArray[0]++; //count
                if(intArray[i]>intArray[i+1]){
                    int tempint = intArray[i];
                    intArray[i] = intArray[i + 1];
                    intArray[i+1] = tempint;
                    fertig = false;
                    dataArray[2]++; //Zähle Swaps
                }
            }
            j=j-1;
        }
        long endTime = System.nanoTime();//ende Zeitmessung
        dataArray[1] = (int) (endTime - startTime)/1000;

    }
}
