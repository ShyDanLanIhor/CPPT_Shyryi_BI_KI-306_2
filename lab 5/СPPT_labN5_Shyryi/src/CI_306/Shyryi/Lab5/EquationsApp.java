package CI_306.Shyryi.Lab5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class EquationsApp {
    /**
     * Entry point for the application.
     *
     * @param args Command-line arguments (not used).
     */
	/**
	* The static main method is the entry point into the program
	* 
	* @param args
	* @throws FileNotFoundException
	* 
	*/
	/**
	* The static main method is the entry point into the program
	* 
	* @param args
	 * @throws IOException 
	* 
	*/
	public static void main(String[] args) throws IOException
	{
		String filler;
		Scanner in = new Scanner(System.in);
		File dataFile = new File("Matrix.txt");
		PrintWriter fout = new PrintWriter(dataFile);
		RandomAccessFile file = new RandomAccessFile("sample.txt", "rw");
		file.seek(0);
		System.out.print("Введіть розмір квадратної матриці: ");
		char[][] arr = new char[in.nextInt()][];
		in.nextLine();
		fout.print("Розмір квадратної матриці: " + arr.length);
		System.out.print("\nВведіть символ-заповнювач: ");
		filler = in.nextLine();
		fout.print("\nСимвол-заповнювач: " + filler);
		if(filler.length() > 1)
		{
			System.out.print("\nВи ввели більше ніж один символ!\nЗавершення програми.");
			fout.print("\nВи ввели більше ніж один символ!\nЗавершення програми.");
			closeProgram(fout);
		}
		if(filler.isEmpty())
		{
			System.out.print("\nВи не ввели символ-заповнювач!\nЗавершення програми.");
			fout.print("\nВи не ввели символ-заповнювач!\nЗавершення програми.");
			closeProgram(fout);
		}
		
		System.out.print("\n");
		fout.print("\n");
		
		int num;
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = new char[((i + 1)*2 < arr.length) ? ((i + 1)*2) : 
				((i + 1)*2 > arr.length + 2) ? ((arr.length - i)*2) : arr.length];
		}
		System.out.print("\n");
		
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				num = 0;
				if( (arr[i].length/ 2 > j) || (arr.length / 2 == i) ||
						((arr[i].length/ 2 + j >= arr.length)))
				{
					file.writeUTF(arr[i][num] + " ");
					arr[i][num] = (char)filler.codePointAt(0);;
					System.out.print(arr[i][num] + " ");
					fout.print(arr[i][num] + " ");
					num++;
				}
				else
				{
					file.writeUTF("  ");
					System.out.print("  ");
					fout.print("  ");
				}
			}
			file.writeUTF("\n");
			System.out.print("\n");
			fout.print("\n");
		}
		fout.flush();
		fout.close();
		file.close();
	}
	/**
	* The closeProgram static method terminates writing to a file and running the program
	* 
	* @param args
	* 
	*/
    private static void closeProgram(PrintWriter fout) {
        fout.flush();
        fout.close();
        System.exit(0);
    }
}
