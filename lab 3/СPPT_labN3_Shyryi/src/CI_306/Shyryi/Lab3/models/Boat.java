package CI_306.Shyryi.Lab3.models;

import CI_306.Shyryi.Lab3.FileUtil;

/**
 * This class represents a boat with a deck and body.
 * The boat can have various configurations for its deck and body.
 */
public class Boat 
{
	private Deck deck;
	private Body body;

    public Boat() {
    	System.out.print("\nЧовен був створений");
    	
    	FileUtil.appendToFile("Логи.txt", "Човен був створений");
    }

    public Boat(Deck deck, Body body) {
        this.deck = deck;
        this.body = body;
        
        FileUtil.appendToFile("Логи.txt", "Човен був створений");
    }

    public Boat(Boat other) {
        this.deck = new Deck(other.deck);
        this.body = new Body(other.body);
        
        FileUtil.appendToFile("Логи.txt", "Човен був створений");
    }

    {
        this.deck = new Deck();
        this.body = new Body();
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

}
