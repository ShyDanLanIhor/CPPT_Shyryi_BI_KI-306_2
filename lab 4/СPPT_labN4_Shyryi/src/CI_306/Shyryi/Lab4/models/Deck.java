package CI_306.Shyryi.Lab4.models;

import CI_306.Shyryi.Lab4.FileUtil;

/**
 * This class represents a boat's deck configuration, including the capacity for sailors and passengers.
 * The deck can have specific capacities for sailors and passengers.
 */
public class Deck
{
	private Integer passengerCapacity;
	
	 public Deck() {
		 System.out.print("\nПуста палуба була створенна");
		 
		 FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    public Deck(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
        
        FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    public Deck(Deck other) {
        this.passengerCapacity = other.passengerCapacity;
        
        FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    {
        this.passengerCapacity = 0;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
    
    public String toHtml() {
        return "<p>Палуба: </p>" +
                "<p>кількість пасажирів=" + passengerCapacity + "</p>";
    }
    
    @Override
    public String toString() {
        return "Палуба{" +
                "кількість пасажирів='" + passengerCapacity + '\'' +
                '}';
    }
}
