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
		System.out.println("You have " + hand.size() + " cards in your hand");
		System.out.println("You have " + deck.getDecksize() + " cards in your deck");
		System.out.println(name + "'s Hand:");
		for (int i=0; i < hand.size(); i++){
			int x = i +1;
			System.out.println("At index number " + x + ":");
			hand.get(i).print();
		}
	}
	public void playCard(int index, Player opponent, Player me){ //insert self into function for trainer cards
		Card card = hand.get(index);
		hand.remove(index);
		if (card.isPokemon() == true){
			Pokemon cardy = (Pokemon) card;
			System.out.println("You've chosen to play a " + cardy.name + " card");
			field.addField(cardy);
		}
		else{
			Trainer cardie = (Trainer) card;
			System.out.println("You've chosen to play a " + cardie.name + " card");
			if (cardie.recipient == 1){
				cardie.play(me);//trainer card needs players for here
			}
			else{
				cardie.play(opponent);// or here
			}
		}
	}
	public boolean turnSequence(Player opponent, Player me){
		if (me.deck.getDecksize() == 0){
		}
		else{
			me.hand.add(deck.draw());
		}
		String command;
		while (true){
			command = Io.getCommand(me);
			if(command.equals("print field")){
				opponent.field.printField(opponent);
				me.field.printField(me);
			}
			else if(command.equals("print hand")){
				me.printHand();
				int ds = me.deck.getDecksize();
				System.out.println("My deck has " + ds + " cards in it.");
				int dso = opponent.deck.getDecksize();
				System.out.println("My Opponent's deck has " + dso + " cards in it.");
			}
			else if(command.equals("attack")){
				if (me.field.arena != null && me.field.arena.experience != 0){
					if (opponent.field.arena == null){
						System.out.println("Player " + me.name + " is the winner!");
						return false;//game over
					}
					else{
						int compare = me.field.arena.compareTo(opponent.field.arena);
						int attack = me.field.arena.attack(compare);
						opponent.field.arena.beattacked(attack);
						opponent.field.clearDead();
						me.field.clearDead();
						me.field.upExperience();
						return true;
					}
				}
				else{
					System.out.println("You are in no position to attack");
				}
			}
			else if(command.equals("switch")){
				Io.promptField(me);
				int index = Io.getSwitch();
				if (index < me.deck.getDecksize() && index >0){
					me.field.swap(index-1, me);
					me.field.upExperience();
					return true;
				}	
				else{
					System.out.println("Not a valid bench position.");
				}
			}
			else if(command.equals("play")){
				int index = Io.getPlay(me);
				if (index < hand.size()+1 && index > 0){
					me.playCard(index-1, opponent, me);
				}
			}
			else if(command.equals("pass")){
				me.field.upExperience();
				return true;
			}
			else{
				System.out.println("Please enter a valid response! \n");
			}
		}
	}
}