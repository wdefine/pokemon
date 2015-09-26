package pokemon;

import java.util.Scanner;

public class Evolutionstone extends Trainer {
	public Evolutionstone(){
		this.name = "Evolution Stone";

	}
	Scanner ess = new Scanner(System.in);
	public void play(Player player){
		Field field = player.field;
		System.out.println("Insert index number of recipient of Evolution Stone");
		field.printField();
		int target = ess.nextInt();
		String bs = ess.nextLine();
		if (target == 0){
			if (player.field.arena != null){
				player.field.arena.evolve();
			}
			else{
				if (player.field.bench.get(target-1) != null){
					player.field.bench.get(target-1).evolve();
				}
			}
		}
	}
	public void play(Pokemon pokemon){
		pokemon.evolve();
	}
}
