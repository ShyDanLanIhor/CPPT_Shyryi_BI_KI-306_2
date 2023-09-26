package CI_306.Shyryi.Lab2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import CI_306.Shyryi.Lab2.models.Boat;
import CI_306.Shyryi.Lab2.models.BoatOnOars;
import CI_306.Shyryi.Lab2.models.Body;
import CI_306.Shyryi.Lab2.models.Deck;
import CI_306.Shyryi.Lab2.models.Oar;
import CI_306.Shyryi.Lab2.models.PairOfOars;
import CI_306.Shyryi.Lab2.models.Person;
import CI_306.Shyryi.Lab2.models.Sailer;

/**
 * The `BoatOnOarsDriver` class is the main entry point for the BoatOnOars application.
 * It demonstrates the creation of a boat on oars and simulates rowing actions.
 */
public class BoatOnOarsDriver 
{
    /**
     * The main method of the application. It creates a boat on oars and simulates rowing actions.
     *
     * @param args The command-line arguments (not used in this application)
     * @throws FileNotFoundException If a file is not found while reading
     */
	 public static void main(String[] args) throws FileNotFoundException 
	 {
		 List<Person> people = new ArrayList<>();
		 people.add(new Person("Святослав", "Куйзалізо", 30));
		 people.add(new Person("Іван", "Розлука", 25));
		BoatOnOars boat= new BoatOnOars(
				"Повітряний змій", new Boat(new Deck(2,2), new Body("Дерево", 1000, 80, 1000, "Sport")), 
				new PairOfOars[] {
				new PairOfOars(new Oar("Дерево", 1000, 50, 1050, "Тесак"), new Oar("Дерево", 1000, 50, 1050, "Тесак")),
				new PairOfOars(new Oar("Дерево", 2000, 40, 2050, "Тесак"), new Oar("Дерево", 2000, 60, 2050, "Тесак"))},
				new Sailer[] {
				new Sailer("Роман", "Поворозник", 30, 1000, 50, 3, 1000),
				new Sailer("Данило", "Хмілевський", 25, 1000, 45, 2, 1000),}, 
				people);
		
		boat.Rowing();

		
	 }
}
