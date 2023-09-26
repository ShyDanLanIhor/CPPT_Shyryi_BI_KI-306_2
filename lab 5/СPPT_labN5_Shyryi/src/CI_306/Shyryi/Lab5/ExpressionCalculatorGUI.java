package CI_306.Shyryi.Lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A GUI application for an expression calculator.
 */
public class ExpressionCalculatorGUI {
    private JTextField xTextField;
    private JTextField fileNameTextField;
    private JButton calculateButton;
    private JButton openTextButton;
    private JButton readTextButton;
    private JButton readBinaryButton;
    private JTextArea resultTextArea;
    JCheckBox checkBox = new JCheckBox("π"); 

    /**
     * Constructs the GUI for the expression calculator.
     */
    public ExpressionCalculatorGUI() {
    	JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(460, 170);
        
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JLabel xLabel = new JLabel("Enter the value of x:");
        xTextField = new JTextField();
        JLabel fileNameLabel = new JLabel("Enter the file name:");
        fileNameTextField = new JTextField();
        calculateButton = new JButton("Calculate");
        openTextButton = new JButton("Open Text");
        readTextButton = new JButton("Read Text");
        readBinaryButton = new JButton("Read Binary");
        
        inputPanel.add(xLabel);
        inputPanel.add(xTextField);
        inputPanel.add(calculateButton);
        inputPanel.add(fileNameLabel);
        inputPanel.add(fileNameTextField);
        inputPanel.add(checkBox);
        inputPanel.add(openTextButton);
        inputPanel.add(readTextButton);
        inputPanel.add(readBinaryButton);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateExpression();
            }
        });

        openTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String fileName = fileNameTextField.getText();
            	resultTextArea.setText(!fileName.isEmpty() ?
            			FileManager.openFile(fileName + ".txt") :
            				"Specify the name of the text file to open.");
            }
        });

        readTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameTextField.getText();
            	resultTextArea.setText(!fileName.isEmpty() ?
            			FileManager.readText(fileName + ".txt") :
            				"Specify the name of the text file to read.");
            }
        });

        readBinaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameTextField.getText();
            	resultTextArea.setText(!fileName.isEmpty() ?
            			FileManager.readBinary(fileName + ".dat") :
            				"Specify the name of the binary file to read.");
            }
        });

        frame.setVisible(true);
    }

    /**
     * Calculates the expression based on user input and writes the result to a file.
     */
    private void calculateExpression() {
        try {
            double x = Double.parseDouble(xTextField.getText());
            double result = 1 / ((checkBox.isSelected() && ((Math.abs(4 * x) == 0.5) ||
        						(((4 * x - 0.5) % 1) == 0))) ?
        						0 : Math.cos(4 * x));
            
			if (result == Double.NaN 
				|| result == Double.NEGATIVE_INFINITY 
				|| result == Double.POSITIVE_INFINITY)
				{ throw new ArithmeticException(); }
			
			
            String fileName = fileNameTextField.getText();
            if (fileName.isEmpty()) {
                fileName = "result";
            }
            
            FileManager.writeText(fileName + ".txt", x, result);
            FileManager.writeBinary(fileName + ".dat", x, result);
            
            resultTextArea.setText("Calculation result written to file '" + fileName + "'");
           
            
        } catch (NumberFormatException e) {
            resultTextArea.setText("Error: Invalid input format");
        } catch (ArithmeticException e) {
        	resultTextArea.setText("Division by zero: cos(4x) equals zero.");
        }
    }
}