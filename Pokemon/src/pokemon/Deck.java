package pokemon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck{ //creates a deck from the given file name
	private static String filename;
	private static List<Card> deck = new ArrayList<Card>(); //creates an empty list called deck

	public Deck(String filename){
		this.filename = filename; 
		create_deck(); //calls on the deck function which will add the cards to the empty list
	}

	public static void create_deck(){ //WILL CREATE CARDS

		// This will reference one line at a time
		String line = null;

		try {

			// FileReader reads text files in the default encoding.
			FileReader fileReader = 
					new FileReader(filename);


			// Always wrap FileReader in BufferedReader. //BufferedReader reads lines
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) { //as long as the file is full it goes through
				String cn = line; //gets the name of the card 
				if (cn.equals("Charmander")){
					deck.add(new Charmander()); //adds the card to the deck
				}
				if (cn.equals("Growlithe")){
					deck.add(new Growlithe());
				}
				if (cn.equals("Squirtle")){
					deck.add(new Squirtle());
				}
				if (cn.equals("Magikarp")){
					deck.add(new Magikarp());
				}
				if (cn.equals("Bulbasaur")){
					deck.add(new Bulbasaur());
				}
				if (cn.equals("Oddish")){
					deck.add(new Oddish());
				}
				if (cn.equals("Magnemite")){
					deck.add(new Magnemite());
				}
				if (cn.equals("Voltorb")){
					deck.add(new Voltorb());
				}
				if (cn.equals("Potion")){
					deck.add(new Potion());
				}
				if (cn.equals("Hpup")){
					deck.add(new Hpup());
				}
				if (cn.equals("Helpfrommom")){
					deck.add(new Helpfrommom());
				}
				if (cn.equals("Evolutionstone")){
					deck.add(new Evolutionstone());
				}
				if (cn.equals("Gustofwind")){
					deck.add(new Gustofwind());
				}


			}   
			// Always close files.
			bufferedReader.close(); 
			return; //returns to end the function
		}
		catch(FileNotFoundException ex){
			System.out.println("No Text File Found");
			//can't find the text file
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file"); //if there is an error reading the list, it quits the program
		}
	}


Random generator = new Random(); //makes a random number generator, instance of the class random

public Card draw(){
	int randomNumber = generator.nextInt((deck.size())); //next int sets it from 0 to size, have to create an int to store the value
	 Card drawn_card = deck.get(randomNumber); //gets a random card from the deck list
	deck.remove(randomNumber);
	return drawn_card;
}
}