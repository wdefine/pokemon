package pokemon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner response = new Scanner(System.in);  //creating the universal scanner
		System.out.println("Welcome to the world of Pokemon!\n" 
				+ "Lets see which trainer has what it takes to be the very best!\n"
				+ "Player one what is your name?");

		String playerone_name = response.next(); //gets player one's name
		System.out.println("What is your deck " + playerone_name + "?"); 
		String fileName1 = response.next(); 
		//takes in the file name to construct the deck for player one
		Deck deck1 = new Deck(fileName1);
		System.out.println("Player two what is your name?"); //gets player two's name
		String playertwo_name = response.next();
		System.out.println("What is your deck " + playertwo_name + "?");
		String fileName2 = response.next(); 
		//takes in the file name to construct the deck for player two
		Deck deck2 = new Deck(fileName2);

		Player player1 = new Player(playerone_name, deck1); //constructs the player 1

		for(int i=0;i<7;i++){ //creating the starting hand for player one
			player1.hand.add(player1.deck.draw());
		}

		Player player2 = new Player(playertwo_name, deck2); //constructs the player 2
		for(int i=0;i<7;i++){ //creating the starting hand for player two
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

}
