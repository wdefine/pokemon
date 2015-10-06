package pokemon;

import java.util.Scanner;

public class Io {//class for all of the scanners in the game so only one scanner is opened

	public static Scanner io = new Scanner(System.in);
	
	public static int playPotion(Player me, Player opponent){ ///sets up unique play for potion card
		String x = "Chose the index of the card to play potion on";
		int target = getInt(x, "Potion", me, opponent);
		return target;
	}
	public static int playGustofWind(Player me, Player opponent){
		String x = "Insert index number of bench member of opponent that you wish to move to arena";
		int target = getInt(x,"Gust of Wind", me, opponent);
		return target;
	}
	public static int playHpup(Player me, Player opponent){
		String x = "Insert index number of pokemon you wish to heal";
		int target = getInt(x,"HP UP", me, opponent);
		return target;
	}
	public static int playEvolutionstone(Player me, Player opponent){
		String x = "Insert index number of pokemon you wish to evolve";
		int target = getInt(x,"Evolution Stone", me, opponent);
		return target;
	}
	public static String getName(String name){ ///starting game
		System.out.println(name + ", what is your name!");
		String nombre = io.nextLine();
		return nombre;
	}
	public static String getDeck(String name){// starting game
		System.out.println(name + ", enter your deck file!");
		String nombre = io.nextLine();
		return nombre;
	}
	public static String getCommand(Player player){ // starts each turn sequence 
		System.out.println(player.name + ": Here is your list of commands!\n" + 
				"(print field) will show pokemon in the field and their hp status!\n" +
							"(print hand) will reveal your hand and the number of cards left in each deck!\n" +
				"(attack) causes your pokemon in the arena to attack the opponent!\n" +
							"(switch) allows you to switch the pokemon in the arena with you bench pokemon!\n" +
				"(play) allows you to play a card from you hand!\n" + 
							"(pass) allows you to skip your turn/end it!");
		String command = io.nextLine();
		return command;
	}
	public static int getSwitch(Player me, Player opponent){ //returns int to switch
		String string = "Do you want to print the field before choosing a bench card to switch? (yes) or (no)";
		while (true){
			promptField(me, opponent, string);
			System.out.println("Insert index number of card to switch or insert -1 to cancel switch");
			String line = io.nextLine();
			try{
				int index = Integer.parseInt(line);
				return index;
			}
			catch (NumberFormatException index){
				System.out.println("Pick a valid number\n");
			}
		}
	}
	public static int getPlay(Player player){// returns intto play from hand
		while (true){
			System.out.println("Do you want to print your hand first? (yes) or (no)");
			String res = io.nextLine();
			if (res.equals("yes")){
				player.printHand();
				while (true){
					System.out.println("Insert index number of card to play or insert -1 to cancel play");
					String line = io.nextLine();
					try{
						int index = Integer.parseInt(line);
						return index;
					}
					catch (NumberFormatException index){
						System.out.println("Pick a valid number\n");
						getPlay(player);
					}
				}
			}
			else if (res.equals("no")){
				while (true){
					System.out.println("Insert index number of card to play or insert -1 to cancel play");
					String line = io.nextLine();
					try{
						int index = Integer.parseInt(line);
						return index;
					}
					catch (NumberFormatException index){
						System.out.println("Pick a valid number please");
						getPlay(player);
					}
				}
			}
		}
	}
	public static void promptField(Player me, Player opponent, String string){ //generalized field print function
		while (true){
			System.out.println(string); //string is unique string to personalize for each trainer card
			String res = io.nextLine();
			if (res.equals("yes")){
				opponent.field.printField(opponent);
				me.field.printField(me);
				return;
			}
			else if (res.equals("no")){
				return;
			}
		}	
		
	}
	public static int getInt(String quote, String name, Player me, Player opponent){ // get int to play trainer card on
		String string = "Do you want to print the field before choosing a card to play " + name + " on? (yes) or (no)";
		if (name.equals("Evolution Stone")){
			while (true){
				printEvolvedStates(me);
				System.out.println(quote + " or insert -1 to cancel play.");
				String line = io.nextLine();
				try{
					int target = Integer.parseInt(line);
					return target;
				}
				catch (NumberFormatException index){ 
					System.out.println("Insert a valid number please");
				}
			}
		}
		else{
			while (true){
				promptField(me, opponent, string);
				System.out.println(quote + " or insert -1 to cancel play.");
				String line = io.nextLine();
				try{
					int target = Integer.parseInt(line);
					return target;
				}
				catch (NumberFormatException index){ 
					System.out.println("Insert a valid number please");
				}
			}
		}
	}
	public static void printEvolvedStates(Player player){ //special print for evolved state trainer to see evolved states
		Field field = player.field;
		while (true){
			System.out.println("Do you want to print the evolved states of the players in your field? (yes) or (no)");
			String res = io.nextLine();
			if (res.equals("yes")){
				System.out.println(player.field.arenaname);
				System.out.println("Index 0: (arena card)");
				if (field.arena == null){
					System.out.println("Arena position is empty\n");
				}
				else if ((field.arena.evolutions.isEmpty() == false) && (field.arena.experience >= 3)){
					field.arena.printEvolved();
				}
				else{
					field.arena.print();
					System.out.println("This card cannot be evolved\n");
				}
				System.out.println("\n" + player.field.benchname);
				if (field.bench.isEmpty() == true){
					System.out.println("Bench is empty");
				}
				else{
					for (int i = 0; i < field.bench.size(); i++){
						if ((field.bench.get(i).experience >= 3) && (field.bench.get(i).evolutions.isEmpty() == false)){
							int x = i+1;
							System.out.print("Index "+ x +":");
							field.bench.get(i).printEvolved();
							System.out.println("");
						}
						else{
							int x = i+1;
							System.out.print("Index "+ x +":");
							field.bench.get(i).print();
							System.out.println("This card cannot be evolved\n");
						}
					}
					return;
				}
			}
			else if (res.equals("no")){
				return;
			}
			else{
				System.out.println("Please insert (yes) or (no)");
			}
		}

	}
}
