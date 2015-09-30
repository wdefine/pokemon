package pokemon;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		System.out.print("Welcome to the world of Pokemon!\n" 
				+ "Lets see which trainer has what it takes to be the very best!\n");
		String x = "Player1";
		String playerone_name = Io.getName(x);
		Deck deck1 = createDeck(playerone_name);
		String y = "Player2";
		String playertwo_name = Io.getName(y);
		Deck deck2 = createDeck(playertwo_name);

		Player player1 = new Player(playerone_name, deck1); //constructs the player 1
		
		for(int i=0; i < 6 ;i++){ //creating the starting hand for player one
			if (player1.deck.getDecksize() == 0){
				break;
			}
			//System.out.println(player1.deck.getDecksize());
			player1.hand.add(player1.deck.draw());
			//System.out.println(player1.deck.getDecksize());
		}
		Player player2 = new Player(playertwo_name, deck2); //constructs the player 2

		for(int i=0; i < 3 ;i++){ //creating the starting hand for player two
			if (player1.deck.getDecksize() == 0){
				break;
			}
			player2.hand.add(player2.deck.draw());
		} 

		while(true){ //keeps the game moving until someone wins
			Player me = player1; //keeps track of whose turn it is
			Player opponent = player2;
			player1.turnSequence(opponent, me);
			me = player2;
			opponent = player1;
			player2.turnSequence(opponent, me);
		}

	}
	public static Deck createDeck(String name){
		while (true){
			String file = Io.getDeck(name);
			if (Deck.isFile(file).equals("x")){
			}
			else{
				Deck deck1 = new Deck(file);
				return deck1;
			}
		}
	}
}