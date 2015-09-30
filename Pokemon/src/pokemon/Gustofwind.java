package pokemon;


public class Gustofwind extends Trainer {
	public Gustofwind(){
		this.name = "Gust of Wind";
		this.recipient = -1;
	}
	public void play(Player player){
		Field field = player.field;
		int target = Io.playGustofWind(player);
		if (target == 0){
			System.out.println("Gust of Wind cannot be used on arena card. Gust of Wind card lost.");
			}	
		else{
			if (field.bench.get(target-1) != null){
				field.swap(target-1, player);
			}
			else{
				System.out.println("Wind can't blow null. Gust of Wind discarded");
			}
		}
	}
}
