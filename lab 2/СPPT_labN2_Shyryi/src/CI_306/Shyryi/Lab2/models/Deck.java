package CI_306.Shyryi.Lab2.models;

import CI_306.Shyryi.Lab2.FileUtil;

/**
 * This class represents a boat's deck configuration, including the capacity for sailors and passengers.
 * The deck can have specific capacities for sailors and passengers.
 */
public class Deck
{
	private Integer sailorsCapacity;
	private Integer passengerCapacity;
	
	 public Deck() {
		 System.out.print("\nПуста палуба була створенна");
		 
		 FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    public Deck(Integer sailorsCapacity, Integer passengerCapacity) {
        this.sailorsCapacity = sailorsCapacity;
        this.passengerCapacity = passengerCapacity;
        
        FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    public Deck(Deck other) {
        this.sailorsCapacity = other.sailorsCapacity;
        this.passengerCapacity = other.passengerCapacity;
        
        FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    {
        this.sailorsCapacity = 0;
        this.passengerCapacity = 0;
    }

    public Integer getSailorsCapacity() {
        return sailorsCapacity;
    }

    public void setSailorsCapacity(Integer sailorsCapacity) {
        this.sailorsCapacity = sailorsCapacity;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
    
    public String toHtml() {
        return "<p>Палуба: </p>" +
                "<p>кількість веслярів = " + sailorsCapacity + "</p>" +
                "<p>кількість пасажирів=" + passengerCapacity + "</p>";
    }
    
    @Override
    public String toString() {
        return "Палуба{" +
                "кількість веслярів='" + sailorsCapacity + '\'' +
                ", кількість пасажирів='" + passengerCapacity + '\'' +
                '}';
    }
}
