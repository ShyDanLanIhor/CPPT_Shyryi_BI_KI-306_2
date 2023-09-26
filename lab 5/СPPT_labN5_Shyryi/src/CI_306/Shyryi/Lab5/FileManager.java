package CI_306.Shyryi.Lab5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A utility class for managing files and performing read/write operations.
 */
public class FileManager {
    
    /**
     * Writes text data to a text file.
     *
     * @param fileName The name of the file to write to.
     * @param x The value of x.
     * @param result The result to be written.
     */
    public static void writeText(String fileName, double x, double result) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Значення y при x = " + x + " дорівнює " + result);
        } catch (IOException e) {
            System.err.println("Помилка запису в текстовий файл: " + e.getMessage());
        }
    }

    /**
     * Writes binary data to a binary file.
     *
     * @param fileName The name of the file to write to.
     * @param x The value of x.
     * @param result The result to be written.
     */
    public static void writeBinary(String fileName, double x, double result) {
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeDouble(x);
            outputStream.writeDouble(result);
        } catch (IOException e) {
            System.err.println("Помилка запису в двійковий файл: " + e.getMessage());
        }
    }

    /**
     * Reads text data from a text file.
     *
     * @param fileName The name of the file to read from.
     * @return A string containing the read data.
     */
    public static String readText(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return "Помилка: Файл не існує.";
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Pattern pattern = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+");
            Matcher matcher = pattern.matcher(reader.readLine());
            
            if (matcher.find()) {
                String numberStr1 = matcher.group();
                if (matcher.find()) {
                    String numberStr2 = matcher.group();
                    double x = Double.parseDouble(numberStr1);
                    double result = Double.parseDouble(numberStr2);
                    return "У текстовому файлі: у = " + result + ", a x =" + x;
                } else {
                    return "Помилка: Немає другого числа в першому рядку файла.";
                }
            } else {
                return "Помилка: Немає першого числа в першому рядку файла.";
            }
        } catch (IOException | NumberFormatException e) {
        	return "Помилка читання з текстового файлу: " + e.getMessage();
        }
    }

    /**
     * Reads binary data from a binary file.
     *
     * @param fileName The name of the file to read from.
     * @return A string containing the read data.
     */
    public static String readBinary(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return "Помилка: Файл не існує.";
        }

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(file))) {
            double x = inputStream.readDouble();
            double result = inputStream.readDouble();
            return "У бінарному файлі: у = " + result + ", a x =" + x;
        } catch (IOException | NumberFormatException e) {
        	return "Помилка читання з двійкового файлу: " + e.getMessage();
        }
    }

    /**
     * Opens a file using the default system application.
     *
     * @param fileName The name of the file to open.
     * @return A string indicating the result of the operation.
     */
    public static String openFile(String fileName) {
    	 File file = new File(fileName);
         if (!file.exists()) {
             return "Помилка: Файл не існує.";
         }

         try {
             java.awt.Desktop.getDesktop().open(file);
         } catch (IOException e) {
             return "Помилка відкриття файлу: " + e.getMessage();
         }
         return "Файл " + fileName + " відкрито";
     }
}