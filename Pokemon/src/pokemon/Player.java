package pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		System.out.println(name + "'s Hand:");
		for (int i=0; i < hand.size(); i++){
			int x = i +1;
			System.out.println("At index number " + x + ":");
			hand.get(i).print();
			System.out.println("");
		}
		System.out.println("");
	}
	// play card function separates trainers and pokemon and plays accordingly
	public void playCard(int index, Player opponent, Player me){ //insert self into function for trainer cards
		Card card = hand.get(index);
		hand.remove(index);
		if (card.isPokemon() == true){
			Pokemon cardy = (Pokemon) card;
			if ((me.field.bench.size() >= 6) && (me.field.arena != null)){// returns card to hand
				me.hand.add(cardy);
				System.out.println("Sorry, your field is full. Pokemon returned to hand");
			}
			else {// adds pokemon to field
				System.out.println("You've chosen to play a " + cardy.name + " card!\n");
				field.addField(cardy);
			}
		}
		else{
			Trainer cardie = (Trainer) card;
			System.out.println("You've chosen to play a " + cardie.name + " card");
			cardie.play(me, opponent);//plays trainer
		}
	}
	// turn sequence that gives players command options
	public boolean turnSequence(Player opponent, Player me){
		// starts by drawing card from deck if possible
		if (me.deck.getDecksize() == 0){
			System.out.println(me.name + ", it is your turn!");
		}
		else{
			me.hand.add(deck.draw());
			System.out.println(me.name + ", it is your turn!");
			System.out.println(me.name + " draws a card!\n");
		}
		String command;
		while (true){ // keeps while loop open
			command = Io.getCommand(me);// call io function to get command
			//print field
			if(command.equals("print field")){
				opponent.field.printField(opponent);
				me.field.printField(me);
			}
			else if(command.equals("print hand")){
				// print hand & deck sizes
				me.printHand();
				int ds = me.deck.getDecksize();
				System.out.println(me.name + "'s deck has " + ds + " cards in it.");
				int dso = opponent.deck.getDecksize();
				System.out.println(opponent.name + "'s deck has " + dso + " cards in it.");
				System.out.println("");
			}
			else if(command.equals("attack")){
				if (me.field.arena != null && me.field.arena.experience != 0){ // if we can attack
					if (opponent.field.arena == null){ // if the opponent's arena is empty, then game over
						int attack = me.field.arena.attack(0);
						if (attack <= 0){
							System.out.println("You cannot defeat your opponent because your pokemon has 0 attack damage");
							return true;
						}
						else{
							System.out.println("Player " + me.name + " is the winner!");
							return false;//game over
						}
					}
					else{ // get compareTo, attack, and be attack to carry out attack
						if (me.field.arena.name.equals("Abra")){
							Random r  = new Random();
							int x = r.nextInt(me.field.bench.size());
							me.field.swap(x, me);
						}
						int compare = me.field.arena.compareTo(opponent.field.arena);
						int attack = me.field.arena.attack(compare);
						if (attack > 0){
							opponent.field.arena.beattacked(attack);
						}
						else{
							attack = 0;
							opponent.field.arena.beattacked(0);
						}
						// print depending if opponent is dead or not
						if (opponent.field.arena.hp <= 0){
							System.out.println(me.name + "'s " + me.field.arena.name + " " + me.field.arena.movename + " " + opponent.field.arena.name + ". " + opponent.field.arena.name + " IS SENTTENCED TO THE SHADOW ZONE!");
							if (me.field.arena.hp <=0){
								System.out.println(me.name + " is also SENTTENCED TO THE SHADOW ZONE!");
							}
							// clear dead
							opponent.field.clearDead(opponent);
							me.field.clearDead(me);
							me.field.upExperience(me);
							System.out.println("");
							return true;
						}
						else{
							System.out.println(me.name + "'s " + me.field.arena.name + " " + me.field.arena.movename + " " + opponent.field.arena.name + ". " + opponent.field.arena.name + " loses " + attack + " health.\n");
							// clear dead
							opponent.field.clearDead(opponent);
							me.field.clearDead(me);
							me.field.upExperience(me);
							return true;
						}
					}
				}
				else{ // if no attack
					System.out.println("You are in no position to attack!\n");
				}
			}
			else if(command.equals("switch")){
				//if we can swap with someone on bench
				if (me.field.bench.size() != 0){
					boolean x = true;
					while (x == true){
						// get number for switch from io; must return #
						int index = Io.getSwitch(me, opponent);
						if ((index <= me.field.bench.size()) && (index >0)){// valid number
							me.field.swap(index-1, me);
							me.field.upExperience(me);
							return true;
						}	
						else if (index == -1){//escape function
							x = false;
						}
						else{// number is not valid
							System.out.println("Not a valid bench position!\n");
						}
					}
				}
				else{
					System.out.println("You have no pokemon on your bench to put in your arena.\n");
				}
			}
			else if(command.equals("play")){
				if (me.hand.size() != 0){
					boolean x = true;
					while (x == true){
						// get number from io to play; must return #
						int index = Io.getPlay(me);
						if ((index <= hand.size()) && (index > 0)){// valid #
							me.playCard(index-1, opponent, me);
							x = false;
						}
						else if(index == -1){//escape function
							x = false;
						}
						else{//non-valid #
							System.out.println("Not a valid hand position\n");
						}
					}
				}
				else{
					System.out.println("You have no cards in your hand to play");
				}
			}
			else if(command.equals("pass")){// up experience and end turn
				me.field.upExperience(me);
				System.out.println(me.name + " ends turn\n");
				return true;
			}
			else{
				System.out.println("Please enter a valid response! \n");
			}
		}
	}
}