package pokemon;

import java.util.Scanner;

public class Io {

	public static Scanner io = new Scanner(System.in);
	public static int playPotion(Player player){
		promptField(player);
		System.out.println("Chose the index of the card to play potion on");
		int target = io.nextInt();
		String bs = io.nextLine();
		return target;
	}
	public static int playGustofWind(Player player){
		promptField(player);
		System.out.println("Insert index number of bench member of opponent that you wish to move to arena");
		int target = io.nextInt();
		String bs = io.nextLine();
		return target;
	}
	public static int playHpup(Player player){
		promptField(player);
		System.out.println("Select index number of pokemon you wish to heal");
		int target = io.nextInt();
		String bs = io.nextLine();
		return target;
	}
	public static int playEvolutionstone(Player player){
		promptField(player);
		System.out.println("Select index number of pokemon you wish to evolve");
		int target = io.nextInt();
		String bs = io.nextLine();
		return target;
	}
	public static String getName(String name){
		System.out.println(name + ", what is your name");
		String nombre = io.nextLine();
		return nombre;
	}
	public static String getDeck(String name){
		System.out.println(name + ", enter your deck file");
		String nombre = io.nextLine();
		return nombre;
	}
	public static String getCommand(Player player){
		System.out.println(player.name + ": Here is your list of commands!\n" + 
				"(print field) will show pokemon in the field and their hp status\n" +
							"(print hand) will reveal your hand and the number of cards left in each deck\n" +
				"(attack) causes your pokemon in the arena to attack the opponent\n" +
							"(switch) allows you to switch the pokemon in the arena with you bench pokemon\n" +
				"(play) allows you to play a card from you hand\n" + 
							"(pass) allows you to skip your turn/end it");
		String command = io.nextLine();
		return command;
	}
	public static int getSwitch(){
		System.out.println("Which bench player do you want to move to the arena");
		String line = io.nextLine();
		int index = Integer.parseInt(line);
		return index;
	}
	public static int getPlay(Player player){
		while (true){
			System.out.println("Do you want to print your hand first? (yes) or (no)");
			String res = io.nextLine();
			if (res.equals("yes")){
				player.printHand();
				System.out.println("Pick a card from your hand to play.");
				String line = io.nextLine();
				int index = Integer.parseInt(line);
				return index;
			}
			else if (res.equals("no")){
				System.out.println("Pick a card from your hand to play.");
				String line = io.nextLine();
				int index = Integer.parseInt(line);
				return index;
			}
		}
	}
	public static void promptField(Player player){
		while (true){
			System.out.println("Do you want to print the field before making your decision? (yes) or (no)");
			String res = io.nextLine();
			if (res.equals("yes")){
				player.field.printField(player);
				return;
			}
			else if (res.equals("no")){
				return;
			}
		}	
		
	}
}
