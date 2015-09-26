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
		this.field = new Field(name);
	}
	public void printHand(){
		System.out.println("Player" + name + "'s Hand:");
		for (int i=0; i < hand.size(); i++){
			int x = i +1;
			System.out.println("At index number " + x + ":");
			hand.get(i).print();
		}
	}
	public void playCard(int index){
		Card card = hand.get(index);
		hand.remove(index);
		if (card.isPokemon() == true){
			Pokemon cardy = (Pokemon) card;
			field.addField(cardy);
		}
		else{
			Trainer cardie = (Trainer) card;
			
		}
	}
	public void turnSequence(){
		while (true){
			
		}
	}
}
