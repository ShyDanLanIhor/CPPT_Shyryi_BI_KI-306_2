package CI_306.Shyryi.Lab3.models;

import CI_306.Shyryi.Lab3.FileUtil;

/**
 * This class represents an oar used for rowing a boat. It includes information about the oar's material,
 * durability, quality, and blade type.
 */
public class Oar extends Object
{
	public String blade;
	public Oar() {
		System.out.print("\nПусте весло було створене");
		
		FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    public Oar(String material, Integer durability, Integer quality, Integer maxDurability, String blade) {
    	super(material, durability, quality, maxDurability);
    	this.blade  = blade;
    	
    	FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    public Oar(Oar other) {
    	super(other);
    	this.blade = other.blade;
    	
    	FileUtil.appendToFile("Логи.txt", "Було створене " + this.toString());
    }

    {
    	this.blade = "Тесак";
    }
    
    public String getBlade() {
        return blade;
    }

    public void seBlade(String blade) {
        this.blade = blade;
    }
    
    /**
     * Simulates rowing action, reducing the durability of the oar, stamina of the sailer, and boat's body durability.
     *
     * @param sailer The sailer performing the rowing.
     * @param boat   The boat in which rowing is taking place.
     * @return True if rowing is successful and all conditions are met; otherwise, false.
     */
    public Boolean Rowing(Sailer sailer, Boat boat) {
        if (super.durability > 0 && sailer.getStamina() > 0 && boat.getBody().getDurability() > 0) {
            // Reduce oar's durability
            super.durability -= ((int) (Math.random() * 11) * 100) / super.quality;

            // Reduce sailer's stamina
            sailer.setStamina(sailer.getStamina() - (((int) (Math.random() * 11) * 100) / sailer.getPower()));

            // Reduce boat's body durability
            boat.getBody().setDurability(boat.getBody().getDurability() -
                    ((int) (Math.random() * 11) * 100) / boat.getBody().getQuality());

            return true;
        }
        return false;
    }

    
    public String toHtml() {
        return "<p> лопать = " + blade + ", матеріал = " + this.getMaterial() + "</p>" +
               "<p> справність = " + this.getDurability() + ", якість = " + this.getQuality() + "</p>";
    }
    
    @Override
    public String toString() {
        return "Весло{" +
                "лопать='" + blade + '\'' +
                ", матеріал='" + super.getMaterial() + '\'' +
                ", справність=" + super.getDurability() +
                ", maxCправність=" + super.getMaxDurability() +
                ", якість=" + super.getQuality() +
                '}';
    }
}
