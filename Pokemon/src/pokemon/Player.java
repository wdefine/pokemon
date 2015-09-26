package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Player {
	public String name;
	public List<Card> hand = new ArrayList<Card>();
	public Deck deck;
	public Field field;
	
	public Player(String name,Deck deck){
		this.name = name;
		this.deck = deck;
		this.field = new Field();
	}
	public void turnSequence(){
		
	}
}
