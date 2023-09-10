package CI_306.Shyryi.Lab3.models;

import CI_306.Shyryi.Lab3.BoatMovingFunctions;
import CI_306.Shyryi.Lab3.FileUtil;

/**
 * Moves the boat forward by rowing with both oars.
 *
 * @param sailer The sailor controlling the oars
 * @return True if the boat successfully moved forward; otherwise, false
 */
public class PairOfOars implements BoatMovingFunctions
{
	private Oar rightOar;
	private Oar leftOar;
	
    public PairOfOars() {
    	System.out.print("\nПуста пара весел була створенна");
    	
    	FileUtil.appendToFile("Логи.txt", "Пара весел була створенна");
    }

    public PairOfOars(Oar rightOar, Oar leftOar) {
        this.rightOar = rightOar;
        this.leftOar = leftOar;
        
        FileUtil.appendToFile("Логи.txt", "Пара весел була створенна");
    }

    public PairOfOars(PairOfOars other) {
        this.rightOar = new Oar(other.rightOar);
        this.leftOar = new Oar(other.leftOar);
        
        FileUtil.appendToFile("Логи.txt", "Пара весел була створенна");
    }

    {
        this.rightOar = new Oar();
        this.leftOar = new Oar();
    }
    
    /**
     * Moves the boat forward by rowing with both oars.
     *
     * @param sailer The sailer controlling the boat.
     * @param boat   The boat to be moved.
     * @return True if the boat moves forward successfully; otherwise, false.
     */
    public Boolean MoveForward(Sailer sailer, Boat boat) {
        return leftOar.Rowing(sailer, boat) & rightOar.Rowing(sailer, boat);
    }

    /**
     * Moves the boat backward by rowing with both oars.
     *
     * @param sailer The sailer controlling the boat.
     * @param boat   The boat to be moved.
     * @return True if the boat moves backward successfully; otherwise, false.
     */
    public Boolean MoveBackward(Sailer sailer, Boat boat) {
        return leftOar.Rowing(sailer, boat) & rightOar.Rowing(sailer, boat);
    }

    /**
     * Moves the boat to the left by rowing with the right oar.
     *
     * @param sailer The sailer controlling the boat.
     * @param boat   The boat to be moved.
     * @return True if the boat moves left successfully; otherwise, false.
     */
    public Boolean MoveLeft(Sailer sailer, Boat boat) {
        return rightOar.Rowing(sailer, boat);
    }

    /**
     * Moves the boat to the right by rowing with the left oar.
     *
     * @param sailer The sailer controlling the boat.
     * @param boat   The boat to be moved.
     * @return True if the boat moves right successfully; otherwise, false.
     */
    public Boolean MoveRight(Sailer sailer, Boat boat) {
        return leftOar.Rowing(sailer, boat);
    }

    public Oar getRightOar() {
        return rightOar;
    }

    public void setRightOar(Oar rightOar) {
        this.rightOar = rightOar;
    }

    public Oar getLeftOar() {
        return leftOar;
    }

    public void setLeftOar(Oar leftOar) {
        this.leftOar = leftOar;
    }
    
    public String toHtml() {
        return "<p>Праве весло:</p>" + this.rightOar.toHtml()
        		+ "<p>Ліве весло:</p>" + this.leftOar.toHtml() ;
    }
}
