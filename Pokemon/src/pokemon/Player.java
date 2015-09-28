package pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	public void playCard(int index, Player opponent, Player me){ //insert self into function for trainer cards
		Card card = hand.get(index);
		hand.remove(index);
		if (card.isPokemon() == true){
			Pokemon cardy = (Pokemon) card;
			field.addField(cardy);
		}
		else{
			Trainer cardie = (Trainer) card;
			if (cardie.recipient == 1){
				cardie.play(me);//trainer card needs players for here
			}
			else{
				cardie.play(opponent);// or here
			}
		}
	}
	public boolean turnSequence(Player opponent, Player me){
		hand.add(deck.draw());
		Scanner turn_response = new Scanner(System.in);
		while (true){
			System.out.println("Here is your list of commands!\n" + 
		"(print field) will show pokemon in the field and their hp status\n" +
					"(print hand) will reveal your hand and the number of cards left in each deck\n" +
		"(attack) causes your pokemon in the arena to attack the opponent\n" +
					"(switch) allows you to switch the pokemon in the arena with you bench pokemon\n" +
		"(play) allows you to play a card from you hand\n" + 
					"(pass) allows you to skip your turn/end it");
			
			
			if(turn_response.nextLine().equals("print field")){
				opponent.field.printField();
				me.field.printField();
			}
			if(turn_response.nextLine().equals("print hand")){
				me.printHand();
				int ds = me.deck.getDecksize();
				System.out.println("My deck has " + ds + " cards in it.");
				int dso = opponent.deck.getDecksize();
				System.out.println("My Opponent's deck has " + dso + " cards in it.");
			}
			if(turn_response.nextLine().equals("attack")){
				int compare = me.field.arena.compareTo(opponent.field.arena);
				int attack = me.field.arena.attack(compare);
				if (opponent.field.arena == null){
					System.out.println("Player " + me.name + " is the winner!");
					return false;//game over
				}
				else{
					opponent.field.arena.beattacked(attack);
					opponent.field.clearDead();
					me.field.clearDead();
					me.field.upExperience();
					return true;
				}
			}
			if(turn_response.nextLine().equals("switch")){
				System.out.println("Which bench player do you want to move to the arena");
				String line = turn_response.nextLine();
				int index = Integer.parseInt(line);
				if (index < 7 && index >0){
					me.field.swap(index-1);
					me.field.upExperience();
					return true;
				}	
				else{
					System.out.println("Not a valid bench position");
				}
			}
			if(turn_response.nextLine().equals("play")){
				System.out.println("Pick a card from your hand to play.");
				String line = turn_response.nextLine();
				int index = Integer.parseInt(line);
				if (index < hand.size()+1 && index > 0){
					me.playCard(index-1, opponent, me);
				}
			}
			if(turn_response.nextLine().equals("pass")){
				me.field.upExperience();
				return true;
			}
			else{
				System.out.println("Please enter a valid response! \n");
			}
		}
	}
}