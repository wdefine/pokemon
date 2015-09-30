package pokemon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck{ //creates a deck from the given file name
	private List<Card> deck = new ArrayList<Card>(); //creates an empty list called deck

	public Deck(String filename){ //WILL CREATE CARDS

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
				if (cn.equals("HP UP")){
					deck.add(new Hpup());
				}
				if (cn.equals("Help from Mom")){
					deck.add(new Helpfrommom());
				}
				if (cn.equals("Evolution Stone")){
					deck.add(new Evolutionstone());
				}
				if (cn.equals("Gust of Wind")){
					deck.add(new Gustofwind());
				}


			}   
			// Always close files.
			bufferedReader.close(); 
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
		int x = this.getDecksize();
		int randomNumber = generator.nextInt((x)); //next int sets it from 0 to size, have to create an int to store the value
		Card drawn_card = deck.get(randomNumber); //gets a random card from the deck list
		deck.remove(randomNumber);
		return drawn_card;
	}
	public int getDecksize(){
		return deck.size();
	}
	public static String isFile(String filename){
		try {
			FileReader fileReader = 
					new FileReader(filename);
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);
			bufferedReader.close();
			return filename;
		}
		catch(FileNotFoundException ex){
			return "x";
		}
		catch(IOException ex) {
			return "x";
		}
	}
}