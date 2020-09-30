import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class p2 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        boolean[] bit;
        bit = new boolean[10000000];

        try {
            File file = new File("C:/Users/USER/Desktop/data.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                int i = Integer.parseInt(line.trim());
                bit[i] = true;
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (final FileWriter writer = new FileWriter("C:/Users/USER/Desktop/result.txt", false))
        {
            for (int i = 0; i < bit.length; ++i)
            {
                if(bit[i] == true){
                    final String s = Integer.toString(i);
                    writer.write(s);
                    writer.write(System.lineSeparator());
                }

            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);

    }
}
