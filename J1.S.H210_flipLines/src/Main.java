
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vu Duc Tien
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream("D:\\test.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line1;
            String line2;
            while ((line1 = bufferedReader.readLine()) != null
                    && (line2 = bufferedReader.readLine()) != null) {
                System.out.println(line2);
                System.out.println(line1);
            }
            if (line1 != null) {
                System.out.println(line1);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("File error");
        } finally {
            try {
                bufferedReader.close();
                fileInputStream.close();
            } catch (IOException ex) {
                System.out.println("File error");
            }
        }
    }
}
