package pokemon;

import java.util.Scanner;

public class Hpup extends Trainer {
	public Hpup(){
		this.name = "HP UP";
	}
	Scanner hpups = new Scanner(System.in);
	public void play(Player player){
		Field field = player.field;
		System.out.println("Insert index number of recipient of HP UP");
		field.printField();
		int target = hpups.nextInt();
		String bs = hpups.nextLine();
		if (target == 0){
			if (player.field.arena != null){
				player.field.arena.hp =+ 20;
				player.field.arena.hpmax =+ 20;
				player.field.arena.hpdistortion =+ 20;
			}
			
		}
		else{
			if (player.field.bench.get(target-1) != null){
				player.field.bench.get(target-1).hp =+ 20;
				player.field.bench.get(target-1).hpmax =+ 20;
				player.field.bench.get(target-1).hpdistortion =+ 20;
			}
		}
	}
}
