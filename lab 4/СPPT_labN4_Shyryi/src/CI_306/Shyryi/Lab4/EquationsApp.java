package CI_306.Shyryi.Lab4;

import javax.swing.SwingUtilities;

public class EquationsApp {
    /**
     * The main method that creates an instance of ExpressionCalculatorGUI and
     * initializes the GUI within the Swing event dispatch thread.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExpressionCalculatorGUI();
            }
        });
    }
}
