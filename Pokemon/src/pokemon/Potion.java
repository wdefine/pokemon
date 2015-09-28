package pokemon;

import java.util.Scanner;

public class Potion extends Trainer {
	public Potion(){
		this.name = "Potion";
		this.recipient = 1;
	}
	Scanner potions = new Scanner(System.in);
	public void play(Player player){
		Field field = player.field;
		System.out.println("Insert index number of recipient of HP UP");
		field.printField();
		int target = potions.nextInt();
		String bs = potions.nextLine();
		if (target == 0){
			if (player.field.arena != null){
				if (field.arena.hp + 20 <= player.field.arena.hpmax){
					field.arena.hp =+ 20;
					field.arena.hpdistortion =+ 20;
				}
				else{
					int change = player.field.arena.hpmax - player.field.arena.hp;
					field.arena.hp =+ change;
					field.arena.hpdistortion =+ change;
				}
			}		
		}
		else{
			if (field.bench.get(target-1) != null){
				if (field.bench.get(target-1).hp + 20 <= player.field.bench.get(target-1).hpmax){
					field.bench.get(target-1).hp =+ 20;
					field.bench.get(target-1).hpmax =+ 20;
					field.bench.get(target-1).hpdistortion =+ 20;
				}
				else{
					int change = player.field.bench.get(target-1).hpmax - player.field.bench.get(target-1).hp;
					field.bench.get(target-1).hp =+ change;
					field.bench.get(target-1).hpdistortion =+ change;
				}
			}
		}
	}
}