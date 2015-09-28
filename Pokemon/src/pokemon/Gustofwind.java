package pokemon;

import java.util.Scanner;

public class Gustofwind extends Trainer {
	public Gustofwind(){
		this.name = "Gust of Wind";
		this.recipient = -1;
	}
	Scanner gosws = new Scanner(System.in);
	public void play(Player player){
		Field field = player.field;
		System.out.println("Insert index number of bench member you wish to move to arena");
		field.printField();
		int target = gosws.nextInt();
		String bs = gosws.nextLine();
		if (target == 0){
			System.out.println("Gust of Wind cannot be used on arena card. Gust of Wind card lost.");
			}	
		else{
			if (field.bench.get(target-1) != null){
				field.swap(target-1);
			}
			else{
				System.out.println("Wind can't blow null. Gust of Wind discarded");
			}
		}
	}
}
