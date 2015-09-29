package pokemon;


public class Hpup extends Trainer {
	public Hpup(){
		this.name = "HP UP";
		this.recipient = 1;
	}
	public void play(Player player){
		Field field = player.field;
		int target = Io.playHpup(player);
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
