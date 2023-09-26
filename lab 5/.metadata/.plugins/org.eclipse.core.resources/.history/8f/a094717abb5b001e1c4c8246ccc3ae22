package KI306.Bokalo.Lab4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Дана програма є класом драйвером який тестує роботу класу Calco
 * @author Petro Bokalo KI-306
 * @version 1.0
 * @since version 1.0
*/

public class Lab4BokaloKI306 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		double x = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Input your X : ");
		
		if(input.hasNextDouble())
		{
		x = input.nextDouble();
		}else
		{
			System.out.print("Invalid data inputed \n");
		}
							
		Calco c = new Calco(x);
		try
		{
			System.out.print("Ctg of x = " + c.result() + "\n");
		}
		catch(ArithmeticException ex)
		{
			System.out.print(ex.getMessage());
		}
		c.in_file();
		c.close_file();
		input.close();
		
	}
}
