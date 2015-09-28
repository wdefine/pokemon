package pokemon;

import java.util.Scanner;

public class Hpup extends Trainer {
	public Hpup(){
		this.name = "HP UP";
		this.recipient = 1;
	}
	Scanner hpups = new Scanner(System.in);
	public void play(Player player){
		Field field = player.field;
		System.out.println("Insert index number of recipient of HP UP");
		field.printField();
		int target = hpups.nextInt();
		String bs = hpups.nextLine();
		if (target == 0){
			if (field.arena != null){
				field.arena.hp =+ 20;
				field.arena.hpmax =+ 20;
				field.arena.hpdistortion =+ 20;
			}
			
		}
		else{
			if (field.bench.get(target-1) != null){
				field.bench.get(target-1).hp =+ 20;
				field.bench.get(target-1).hpmax =+ 20;
				field.bench.get(target-1).hpdistortion =+ 20;
			}
		}
	}
}
