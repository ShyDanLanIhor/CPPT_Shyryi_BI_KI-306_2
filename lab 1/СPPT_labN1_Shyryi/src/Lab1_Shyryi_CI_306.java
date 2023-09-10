import java.io.*;
import java.util.*;

/**
 * The Lab2_Shyryi_CI_306 class implements a program for generating and inferring a jagged array of characters.
 * 
 * @author Bohdan Shyryi
 * @version 1.0
 * @since version 1.0
 */
public class Lab1_Shyryi_CI_306 {
	/**
	* The static main method is the entry point into the program
	* 
	* @param args
	* @throws FileNotFoundException
	* 
	*/
	public static void main(String[] args) throws FileNotFoundException
	{
		String filler;
		Scanner in = new Scanner(System.in);
		File dataFile = new File("Matrix.txt");
		PrintWriter fout = new PrintWriter(dataFile);
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
		/*
		for(int i = 0; i < arr.length; i++)
		{
			if((i + 1)*2 < arr.length)
			{ arr[i] = new char[(i + 1)*2]; }
			else if ((i + 1)*2 > arr.length + 2)
			{ arr[i] = new char[(arr.length - i)*2]; }
			else { arr[i] = new char[arr.length]; }
		}
		*/
		/*
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = ((i + 1)*2 < arr.length) ? new char[(i + 1)*2] :
					((i + 1)*2 > arr.length + 2) ? new char[(arr.length - i)*2] : new char[arr.length];
		}
		*/
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
					arr[i][num] = (char)filler.codePointAt(0);;
					System.out.print(arr[i][num] + " ");
					fout.print(arr[i][num] + " ");
					num++;
				}
				else
				{
					System.out.print("  ");
					fout.print("  ");
				}
			}
			System.out.print("\n");
			fout.print("\n");
		}
		fout.flush();
		fout.close();
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
