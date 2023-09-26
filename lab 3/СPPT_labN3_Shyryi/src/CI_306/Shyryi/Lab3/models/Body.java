package CI_306.Shyryi.Lab3.models;

import CI_306.Shyryi.Lab3.FileUtil;

/**
 * This class represents the body of a boat, including its material, durability, quality, and purpose.
 * The body can be configured with specific material, durability, quality, and purpose.
 */
public class Body extends Object {
    private String purpose;

    public Body() {
        super();
        System.out.print("\nПустий корпус був створенний");
        
        FileUtil.appendToFile("Логи.txt", "Був створений " + this.toString());
    }

    public Body(String material, Integer durability, Integer quality, Integer maxDurability, String purpose) {
        super(material, durability, quality, maxDurability);
        this.purpose = purpose;
        
        FileUtil.appendToFile("Логи.txt", "Був створений " + this.toString());
    }

    public Body(Body other) {
        super(other);
        this.purpose = other.purpose;
        
        FileUtil.appendToFile("Логи.txt", "Був створений " + this.toString());
    }

    {
        this.purpose = "За замовчуванням";
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    public String toHtml() {
        return "<p>Корпус:</p>" +
                "<p>призначення = " + purpose + ", матеріал = " + this.getMaterial() + "</p>" +
                "<p> справність = " + this.getDurability() + ", якість = " + this.getQuality() + "</p>";
    }
    
    @Override
    public String toString() {
        return "Корпус{" +
                "призначення='" + purpose + '\'' +
                ", матеріал='" + super.getMaterial() + '\'' +
                ", справність=" + super.getDurability() +
                ", maxCправність=" + super.getMaxDurability() +
                ", якість=" + super.getQuality() +
                '}';
    }
}
