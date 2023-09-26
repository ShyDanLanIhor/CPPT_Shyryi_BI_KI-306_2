package CI_306.Shyryi.Lab3.models;

import CI_306.Shyryi.Lab3.BoatMovingFunctions;
import CI_306.Shyryi.Lab3.FileUtil;

/**
 * A class representing a motor for a boat, implementing BoatMovingFunctions.
 */
public class Motor extends Object implements BoatMovingFunctions
{
	public String manufacturer;
	public Motor() {
		System.out.print("\nПусте весло було створене");
		
		FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    public Motor(String material, Integer durability, Integer quality, Integer maxDurability, String manufacturer) {
    	super(material, durability, quality, maxDurability);
    	this.manufacturer  = manufacturer;
    	
    	FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    public Motor(Motor other) {
    	super(other);
    	this.manufacturer = other.manufacturer;
    	
    	FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    {
    	this.manufacturer = "Greenworks";
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    /**
     * Moves the boat forward by rowing with the motor.
     *
     * @param helmsman The helmsman controlling the motorboat.
     * @param boat     The boat to be moved.
     * @return True if the boat moves forward successfully; otherwise, false.
     */
    public Boolean MoveForward(Helmsman helmsman, Boat boat) {
        return Rowing(helmsman, boat);
    }
    
    /**
     * Moves the boat backward by rowing with the motor.
     *
     * @param helmsman The helmsman controlling the motorboat.
     * @param boat     The boat to be moved.
     * @return True if the boat moves backward successfully; otherwise, false.
     */
    public Boolean MoveBackward(Helmsman helmsman, Boat boat) {
        return Rowing(helmsman, boat);
    }
    
    /**
     * Moves the boat to the left by rowing with the motor.
     *
     * @param helmsman The helmsman controlling the motorboat.
     * @param boat     The boat to be moved.
     * @return True if the boat moves left successfully; otherwise, false.
     */
    public Boolean MoveLeft(Helmsman helmsman, Boat boat) {
        return Rowing(helmsman, boat);
    }
    
    /**
     * Moves the boat to the right by rowing with the motor.
     *
     * @param helmsman The helmsman controlling the motorboat.
     * @param boat     The boat to be moved.
     * @return True if the boat moves right successfully; otherwise, false.
     */
    public Boolean MoveRight(Helmsman helmsman, Boat boat) {
        return Rowing(helmsman, boat);
    }
    
    /**
     * Simulates rowing action, reducing the durability of the oar, stamina of the helmsman, and boat's body durability.
     *
     * @param helmsman The helmsman performing the rowing.
     * @param boat   The boat in which rowing is taking place.
     * @return True if rowing is successful and all conditions are met; otherwise, false.
     */
    public Boolean Rowing(Helmsman helmsman, Boat boat) {
        if (super.durability > 0 && helmsman.getStamina() > 0 && boat.getBody().getDurability() > 0) {
            // Reduce oar's durability
            super.durability -= ((int) (Math.random() * 11) * 100) / super.quality;

            // Reduce sailer's stamina
            helmsman.setStamina(helmsman.getStamina() - (((int) (Math.random() * 11) * 100) / helmsman.getPower()));

            // Reduce boat's body durability
            boat.getBody().setDurability(boat.getBody().getDurability() -
                    ((int) (Math.random() * 11) * 100) / boat.getBody().getQuality());

            return true;
        }
        return false;
    }

    
    public String toHtml() {
        return "<p> виробник = " + manufacturer + ", матеріал = " + this.getMaterial() + "</p>" +
               "<p> справність = " + this.getDurability() + ", якість = " + this.getQuality() + "</p>";
    }
    
    @Override
    public String toString() {
        return "Мотор{" +
                "виробник='" + manufacturer + '\'' +
                ", матеріал='" + super.getMaterial() + '\'' +
                ", справність=" + super.getDurability() +
                ", maxCправність=" + super.getMaxDurability() +
                ", якість=" + super.getQuality() +
                '}';
    }
}