/**
 FileReader - Prüfung03 | SortierAlgorithmen

 @Author:   Felix Reiniger
 @Date:     16/01/2020
 @Version:  1.0
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {


    public FileReader() {

    }


    /**
     * Liest die Files aus und wandelt diese in ein Array um
     * @param file File Input
     * @return  Array mit allen Werten aus dem File
     * @throws IOException
     */
    public int[] readFile(File file) throws IOException {
        List<Integer> dataList = new ArrayList<>();

        try{
            FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            while(dataInputStream.available()>0){
                String input = dataInputStream.readLine().replace(" ", "");
                if(input.length()>0) { //Validate
                    dataList.add(Integer.parseInt(input));
                }
            }
        }
        catch (FileNotFoundException e){
        }

        int[] arr = dataList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return arr;
    }
}
