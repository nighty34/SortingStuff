/**
 *
 * Beschreibung: Binary Tree Sort Algorithmus
 *
 *  @Author: Danial Vaezi
 *  @Date: 23/01/2020
 *  @Version: 1.0
 */
class TreeSort extends SortierAlgorithmen
{

    class Zweig
    {
        int key;
        Zweig links, rechts;

        public Zweig(int item)
        {
            key = item;
            links = rechts = null;
        }
    }


    Zweig wurzel;
    static int schleifen = 0;
    static int vergleiche = 0;


    TreeSort()
    {
        wurzel = null;
    }


    void einfügen(int key)
    {
        wurzel = newkey(wurzel, key);
    }


    Zweig newkey(Zweig wurzel, int key)
    {


        if (wurzel == null)
        {
            wurzel = new Zweig(key);
            return wurzel;
        }


        if (key < wurzel.key) {
            wurzel.links = newkey(wurzel.links, key);
        }
        else if (key > wurzel.key)
            wurzel.rechts = newkey(wurzel.rechts, key);


        return wurzel;
    }

    void treeins(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            einfügen(arr[i]);
            schleifen ++;
        }

    }


    void reihenfolge(Zweig wurzel)
    {
        if (wurzel != null)
        {
            reihenfolge(wurzel.links);
            vergleiche++;
            reihenfolge(wurzel.rechts);
        }
    }


   /* public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        TreeSort tree = new Treesort();
        int arr[] = {3, 5, 4, 7, 2, 11, 100, 12, 13, 18, 25, 99, 55, 2, 654,65, 68, 64, 35123, 6468, 553187, 5135};
        tree.sort(arr);
        long ende = System.currentTimeMillis();
        long zeit = ende - start;
        System.out.println("Anzahl schleifendurchgänge:" + schleifen);
        System.out.println("Benötigte Zeit:" + zeit + " Millisekunden");
        System.out.println("Anzahl swaps:" + vergleiche);
    }*/

    public void sort(int[] array){
        long startTime = System.nanoTime();
        treeins(array);
        reihenfolge(wurzel);
        long endTime = System.nanoTime();
        dataArray[1] = (int) (endTime - startTime)/1000;
        dataArray[0] = schleifen;
        dataArray[2] = vergleiche;


    }
}