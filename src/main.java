/**
 Main - Prüfung03 | SortierAlgorithmen

 @Author:   Felix Reiniger
 @Date:     16/01/2020
 @Version:  1.0
 */

import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.util.Scanner;

public class main {

    /**
     * Main-Klasse
     * @param args
     */
    public static void main(String[] args) {
        Tester tester = new Tester();
        FileReader fileReader = new FileReader();

        Scanner scanner = new Scanner(System.in);


        System.out.println("Wählen Sie was getestet werden soll: (ALL, BubbleSort, QuickSort, TreeSort, MergeSort, InsertionSort)");
        String alg = scanner.next();

        System.out.println("Mit wie vielen Einträgen soll getestet werden?: (10/100/1000)");
        File file = new File(scanner.next()+ "Digits.dat");

        try {
            int[] array = fileReader.readFile(file);

            tester.addSortAlg(new BubbleSort());
            tester.addSortAlg(new QuickSort());
            tester.addSortAlg(new TreeSort());
            tester.addSortAlg(new MergeSort());
            tester.addSortAlg(new InsertionSort());

            tester.test(array, alg);




        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
