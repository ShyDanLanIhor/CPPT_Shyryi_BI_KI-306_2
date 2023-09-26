package CI_306.Shyryi.Lab3.models;

import CI_306.Shyryi.Lab3.FileUtil;

/**
 * The `Sailer` class represents a sailor who can row a boat. It extends the `Person` class.
 */
public class Sailer extends Person
{
	private Integer stamina;
	private Integer maxStamina;
	private Integer power;
	private Integer experience;
	
    public Sailer() {
        super();
        System.out.print("\nПустий весляр був створений");
        
        FileUtil.appendToFile("Логи.txt", "Був створений " + this.toString());
    }

    public Sailer(String firstname, String lastname, Integer years, Integer stamina, 
    		Integer power, Integer experience, Integer maxStamina) {
        super(firstname, lastname, years);
        this.stamina = stamina;
        this.power = power;
        this.experience = experience;
        this.maxStamina = maxStamina;
        
        FileUtil.appendToFile("Логи.txt", "Був створений " + this.toString());
    }

    public Sailer(Sailer other) {
        super(other);
        this.stamina = other.stamina;
        this.power = other.power;
        this.experience = other.experience;
        this.maxStamina = other.maxStamina;
        
        FileUtil.appendToFile("Логи.txt", "Був створений " + this.toString());
    }

    {
        this.stamina = 0;
        this.power = 0;
        this.experience = 0;
        this.maxStamina = 0;
    }
    
    /**
     * Restores the sailor's stamina to its maximum value.
     */
    public void Rest()
    {
    	this.stamina = this.maxStamina;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String toHtml()
    {
    	return "<p>" + " ім'я = " + getFirstname() + ", прізвище = " + getLastname() + ",</p>" +
        		"<p>" + "вік = " + getYears() +", енергія = " + stamina + ",</p>" +
        		"<p>" + "потужність = " + power + ", досвід = " + experience + "</p>";
    }
    
    @Override
    public String toString() {
        return "Весляр{" +
                "ім'я='" + getFirstname() + '\'' +
                ", прізвище='" + getLastname() + '\'' +
                ", вік=" + getYears() +
                ", енергія=" + stamina +
                ", maxЕнергія=" + maxStamina +
                ", потужність=" + power +
                ", досвід=" + experience +
                '}';
    }
}
