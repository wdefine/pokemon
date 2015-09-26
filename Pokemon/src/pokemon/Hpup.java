package pokemon;

import java.util.Scanner;

public class Hpup extends Trainer {
	public Hpup(){
		this.name = "HP UP";
	}
	public void play(Player player){
		Scanner hpups = new Scanner(System.in);
		Field field = player.field;
		System.out.println("Insert index number of recipient of HP UP");
		field.printField();
		int target = hpups.nextInt();
		String bs = hpups.nextLine();
		Pokemon pokemon;
		if (target)
		pokemon.hp =+ 20;
		pokemon.hpmax =+ 20;
		pokemon.hpdistortion =+ 20;
	}
}
