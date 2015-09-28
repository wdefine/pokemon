package pokemon;

import java.util.Scanner;

public class Evolutionstone extends Trainer {
	public Evolutionstone(){
		this.name = "Evolution Stone";
		this.recipient = 1;
	}
	Scanner ess = new Scanner(System.in);
	public void play(Player player){
		Field field = player.field;
		System.out.println("Insert index number of recipient of Evolution Stone");
		field.printField();
		int target = ess.nextInt();
		String bs = ess.nextLine();
		if (target == 0){
			if (field.arena != null){
				field.arena.evolve();
			}
			else{
				if (field.bench.get(target-1) != null){
					field.bench.get(target-1).evolve();
				}
			}
		}
	}
}
