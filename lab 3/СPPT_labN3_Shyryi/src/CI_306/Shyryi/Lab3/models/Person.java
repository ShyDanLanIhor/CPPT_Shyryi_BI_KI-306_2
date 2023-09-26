package CI_306.Shyryi.Lab3.models;

import CI_306.Shyryi.Lab3.FileUtil;

/**
 * A class representing a person with a first name, last name, and age.
 */
public class Person
{
	private String firstname;
	private String lastname;
	private Integer years;
	
	public static Integer num = 0;
	
    public Person() {
    	System.out.print("\nПуста людина була створена");
    	
    	if((this.firstname.charAt(0) == 'А') && (this.years < 15)) {num++; }
    	
    	FileUtil.appendToFile("Логи.txt", "Була створена " + this.toString());
    }

    public Person(String firstname, String lastname, Integer years) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.years = years;
        
        
        if((this.firstname.charAt(0) == 'А') && (this.years < 15)) {num++; }
        
        FileUtil.appendToFile("Логи.txt", "Була створена " + this.toString());
    }

    public Person(Person other) {
        this.firstname = other.firstname;
        this.lastname = other.lastname;
        this.years = other.years;
        
        if((this.firstname.charAt(0) == 'А') && (this.years < 15)) {num++; }
        
        FileUtil.appendToFile("Логи.txt", "Була створена " + this.toString());
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }
    
    public String toHtml()
    {
    	return "ім'я=" + firstname +", прізвище=" + lastname + ", вік=" + years;
    }

	@Override
	public String toString() {
		return "Людина{" +
				"ім'я='" + firstname + '\'' +
				", прізвище='" + lastname + '\'' +
				", вік=" + years +
				'}';
	}
}
