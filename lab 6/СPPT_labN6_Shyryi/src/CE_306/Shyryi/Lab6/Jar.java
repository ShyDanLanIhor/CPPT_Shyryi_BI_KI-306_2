package CE_306.Shyryi.Lab6;

import javax.swing.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class representing a "jar" that can hold objects of type T.
 * Objects in the jar can be ordered using comparison, implemented through the Comparable<T> interface.
 * 
 * @param <T> The type of objects that can be stored in the jar and compared.
 */
public class Jar<T extends Comparable<T>> extends JPanel {
    private List<T> items;
    private Class<T> type;
    public static String str = "";
    public static Integer num = 0;
    /**
     * Default constructor. Creates an empty jar.
     */
	public Jar(Class<T> type) {
        items = new ArrayList<>();
        this.type = type;
        if(this.str.contains(type.getSimpleName()) == false)
        {
        	this.str += type.getSimpleName();
        	this.num++;
        }
    }

    /**
     * Constructor that initializes the jar with a list of items.
     *
     * @param items The list of items for the initial filling of the jar.
     */
    public Jar(List<T> items, Class<T> type) {
        this.items = new ArrayList<>(items);
        if(this.str.contains(type.getSimpleName()) == false)
        {
        	this.str += type.getSimpleName();
        	this.num++;
        }
    }

    /**
     * Copy constructor. Creates a copy of the jar based on another jar.
     *
     * @param otherJar Another jar object to be copied.
     */
    public Jar(Jar<T> otherJar,  Class<T> type) {
        this.items = new ArrayList<>(otherJar.items);
        if(this.str.contains(type.getSimpleName()) == false)
        {
        	this.str += type.getSimpleName();
        	this.num++;
        }
    }

    /**
     * Adds an object to the jar.
     *
     * @param item The object to add to the jar.
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Removes an object from the jar at a specified index.
     *
     * @param index The index of the object to remove.
     * @return The removed object or null if the index is invalid.
     */
    public T removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.remove(index);
        } else {
            return null;
        }
    }

    /**
     * Randomly shuffles the objects in the jar.
     */
    public void shuffle() {
        Collections.shuffle(items);
    }

    /**
     * Finds the minimum object in the jar.
     *
     * @return The minimum object or null if the jar is empty.
     */
    public T findMinItem() {
        if (items.isEmpty()) {
            return null;
        }
        return Collections.min(items);
    }

    /**
     * Finds the maximum object in the jar.
     *
     * @return The maximum object or null if the jar is empty.
     */
    public T findMaxItem() {
        if (items.isEmpty()) {
            return null;
        }
        return Collections.max(items);
    }
    
    /**
     * Returns a list of objects in the jar (unmodifiable).
     *
     * @return An unmodifiable list of objects in the jar.
     */
    public List<T> getItems() {
        return Collections.unmodifiableList(items);
    }
}
