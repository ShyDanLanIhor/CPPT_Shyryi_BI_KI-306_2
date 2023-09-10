package CI_306.Shyryi.Lab4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import CI_306.Shyryi.Lab4.models.Boat;
import CI_306.Shyryi.Lab4.models.Body;
import CI_306.Shyryi.Lab4.models.Deck;
import CI_306.Shyryi.Lab4.models.Helmsman;
import CI_306.Shyryi.Lab4.models.Motor;
import CI_306.Shyryi.Lab4.models.Motorboat;
import CI_306.Shyryi.Lab4.models.Person;
/**
 * A class representing a driver program for the Motorboat simulation.
 */
public class MotorboatDriver {
	/**
     * The main entry point of the program.
     *
     * @param args Command line arguments (not used in this program).
     * @throws FileNotFoundException If an error occurs while accessing files (not used in this program).
     */
	public static void main(String[] args) throws FileNotFoundException 
	 {
		 List<Person> people = new ArrayList<>();
		 people.add(new Person("Святослав", "Куйзалізо", 30));
		 people.add(new Person("Іван", "Розлука", 25));
		 Motorboat boat= new Motorboat(
				"Сталевий дракон", new Boat(new Deck(2), new Body("Легка сталь", 1000, 80, 1000, "Воєнний")), 
				new Motor("Залізо", 1000, 50, 1050, "Greenworks"),
				new Helmsman("Данило", "Хмілевський", 25, 1000, 45, 2, 1000), 
				people);
		boat.Rowing();
	 }
}
