package CI_306.Shyryi.Lab3.models;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CI_306.Shyryi.Lab3.FileUtil;

/**
 * A class representing a motorboat with various attributes and functionalities.
 */
public class Motorboat {
	private String name;
	private Boat boat;
	private Motor motor;
	private Helmsman helmsman;
	private List<Person> passengers = new ArrayList<>();
	
	/**
     * Enum representing possible movement directions for the motorboat.
     */
	public enum MoveDirection {
	    LEFT,
	    RIGHT,
	    FORWARD,
	    BACKWARD
	}
	
    /**
     * Creates an empty rowing boat.
     */
    public Motorboat() {
    	System.out.print("\nПустий моторний човен був створений");
    	
    	FileUtil.appendToFile("Логи.txt", "Був створений " + this.name);
    }
    
    /**
     * Creates a Motorboat with specified parameters.
     *
     * @param name       The name of the motorboat.
     * @param boat       The boat component of the motorboat.
     * @param motor      The motor component of the motorboat.
     * @param helmsman   The helmsman steering the motorboat.
     * @param passengers The list of passengers on board.
     */
    public Motorboat(String name, Boat boat, Motor motor, Helmsman helmsman, List<Person> passengers) {
        this.name = name;
        this.boat = boat;
        this.motor = motor;
        this.helmsman = helmsman;
        this.passengers.addAll(passengers);
    }

    /**
     * Creates a copy of a Motorboat object.
     *
     * @param other The Motorboat object to copy.
     */
    public Motorboat(Motorboat other) {
        this.name = other.name;
        this.boat = new Boat(other.boat);
        this.motor = new Motor(other.motor);
        this.helmsman = new Helmsman(other.helmsman);
        this.passengers = new ArrayList<>(other.passengers);
    }

    /**
     * This initialization block sets initial values for the rowing boat.
     */
    {
        this.name = "";
        this.boat = new Boat();
        this.motor = new Motor();
        this.helmsman = new Helmsman();
    }
    
    /**
     * Initiates rowing when interacting with keys. Displays the movement state in a window.
     */
    public void Rowing()
    {
    	JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);
		frame.setFocusable(true);

		JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
		JLabel page = new JLabel();
		panel.add(page);
		page.setText("<html>" + getBoatInHtml() + "<br/>" +
				getHelmsmanInHtml() + "<br/>" +
				getPassengersInHtml() + "<br/>" +
				"Руху ще не було спричинено" + "</html>");

		frame.addKeyListener((KeyListener) new KeyListener() {

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					page.setText("<html>" + getBoatInHtml() + "<br/>" +
							getHelmsmanInHtml() + "<br/>" +
							getPassengersInHtml() + "<br/>" +
							(isRowingAbleTo(MoveDirection.FORWARD) ? 
							"Моторний човен проплив вперед" : "У човна проблеми") + "</html>");
					FileUtil.appendToFile("Логи.txt", "Моторний човен " + name + " проплив вперед");
					break;
				case KeyEvent.VK_DOWN:
					page.setText("<html>" + getBoatInHtml() + "<br/>" +
							getHelmsmanInHtml() + "<br/>" +
							getPassengersInHtml() + "<br/>" +
							(isRowingAbleTo(MoveDirection.BACKWARD) ? 
							"Моторний човен проплив назад": "У човна проблеми") + "</html>");
					FileUtil.appendToFile("Логи.txt", "Моторний човен " + name + " проплив назад");
					break;
				case KeyEvent.VK_RIGHT:
					page.setText("<html>" + getBoatInHtml() + "<br/>" +
							getHelmsmanInHtml() + "<br/>" +
							getPassengersInHtml() + "<br/>" +
							(isRowingAbleTo(MoveDirection.RIGHT) ? 
							"Моторний човен проплив вправо" : "У човна проблеми") + "</html>");
					FileUtil.appendToFile("Логи.txt", "Моторний човен " + name + " проплив вправо");
					break;
				case KeyEvent.VK_LEFT:
					page.setText("<html>" + getBoatInHtml() + "<br/>" +
							getHelmsmanInHtml() + "<br/>" +
							getPassengersInHtml() + "<br/>" +
							(isRowingAbleTo(MoveDirection.LEFT) ? 
							"Моторний човен проплив вліво" : "У човна проблеми") + "</html>");
					FileUtil.appendToFile("Логи.txt", "Моторний човен " + name + " проплив вліво");
					break;
				case KeyEvent.VK_R:
					motor.Repair();
					boat.getBody().Repair();
					helmsman.Rest();
					page.setText("<html>" + getBoatInHtml() + "<br/>" +
							getHelmsmanInHtml() + "<br/>" + getPassengersInHtml() 
							+ "<br/>Ремонт та відпочинок здійснено</html>");
					FileUtil.appendToFile("Логи.txt", "Ремонт та відпочинок здійснено");
					break;
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		frame.add(panel);
    }
    
    /**
     * Checks if the rowing boat is able to move in the specified direction.
     *
     * @param moveDirection The direction in which the boat should move (FORWARD, BACKWARD, RIGHT, or LEFT).
     * @return True if the boat is able to move in the specified direction; otherwise, false.
     */
    public Boolean isRowingAbleTo(MoveDirection moveDirection)
    {
        switch (moveDirection) 
        {
        case FORWARD:
        	if(!motor.MoveForward(helmsman, boat)){ return false; }
            break;
        case BACKWARD:
        	if(!motor.MoveBackward(helmsman, boat)){ return false; }
            break;
        case RIGHT:
        	if(!motor.MoveRight(helmsman, boat)){ return false; }
            break;
        case LEFT:
    		if(!motor.MoveLeft(helmsman, boat)){ return false; }
            break;
        }
    	return true;
    }
    
    /**
     * Generates an HTML representation of the boat and its characteristics.
     *
     * @return An HTML string containing information about the boat's name and characteristics.
     */
    public String getBoatInHtml()
    {
    	return "<p> Ви пливете на " + this.name + " </p> " 
    			+ "<p> Характеристики: </p> " 
    			+ this.getBoat().getBody().toHtml() 
    			+ this.getBoat().getDeck().toHtml();
    }
    
    /**
     * Generates an HTML representation of the sailors and their associated oars.
     *
     * @return An HTML string containing information about sailors and their oars.
     */
    public String getHelmsmanInHtml()
    {
    	return "<p> Керманич: </p>" 
				+ helmsman.toHtml()
				+ "<p> Мотор: </p>" 
				+ motor.toHtml();
    }
    
    /**
     * Generates an HTML representation of the passengers.
     *
     * @return An HTML string containing information about passengers
     */
    public String getPassengersInHtml()
    {
    	String htmlRaw = "";
    	for (int i = 0; i < getBoat().getDeck().getPassengerCapacity(); i++)
    	{
    		htmlRaw += "<p> Пасажир " + i + ": </p>" + this.passengers.get(i).toHtml();
    	}
    	return htmlRaw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Helmsman getHelmsman() {
        return helmsman;
    }

    public void setHelmsman(Helmsman helmsman) {
        this.helmsman = helmsman;
    }

    public List<Person> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Person> passengers) {
        this.passengers = passengers;
    }
}
