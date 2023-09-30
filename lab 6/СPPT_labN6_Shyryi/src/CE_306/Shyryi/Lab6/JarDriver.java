package CE_306.Shyryi.Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * A driver class that demonstrates the usage of the Jar class for storing and manipulating
 * items of different types (Integer and String).
 */
public class JarDriver {
    public static void main(String[] args) {
    	/*
        JFrame frame = new JFrame("Item Jar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        Jar<Integer> intJar = new Jar<>();
        Jar<String> strJar = new Jar<>();

        JLabel itemsLabel = new JLabel();

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter an item:");
                if (input != null && !input.isEmpty()) {
                    intJar.addItem(Integer.parseInt(input));
                    strJar.addItem(input);
                }
            }
        });

        JButton removeButton = new JButton("Remove Item");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(JOptionPane
                		.showInputDialog("Enter the index to remove:"));
                intJar.removeItem(index);
                strJar.removeItem(index);
            }
        });

        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intJar.shuffle();
                strJar.shuffle();
            }
        });

        JButton findMinButton = new JButton("Find Min");
        findMinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Min Integer: " + intJar.findMinItem() +
                        "\nMin String: " + strJar.findMinItem());
            }
        });

        JButton findMaxButton = new JButton("Find Max");
        findMaxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Max Integer: " + intJar.findMaxItem() +
                        "\nMax String: " + strJar.findMaxItem());
            }
        });

        JButton showItemsButton = new JButton("Show Items");
        showItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemsLabel.setText(
                "<html>" 
                + "<p>" + "Integer Items: " + intJar.getItems().toString() + "</p>" 
                + "<p>" + "String Items: " + strJar.getItems().toString() + "</p>" 
                + "</html>");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(shuffleButton);
        panel.add(findMinButton);
        panel.add(findMaxButton);
        panel.add(showItemsButton);
        panel.add(itemsLabel);

        frame.add(panel);
        frame.setVisible(true);
        */
    	Jar<Integer> intJar = new Jar<>(Integer.class);
    	Jar<Integer> int2Jar = new Jar<>(Integer.class);
    	Jar<String> strJar = new Jar<>(String.class);
    	Jar<String> str2Jar = new Jar<>(String.class);
    	Jar<String> str3Jar = new Jar<>(String.class);
    	Jar<Double> sdbl3Jar = new Jar<>(Double.class);
    	
    	System.out.print(Jar.num);
    }
}

