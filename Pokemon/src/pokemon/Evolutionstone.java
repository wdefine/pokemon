package pokemon;


public class Evolutionstone extends Trainer {
	public Evolutionstone(){
		this.name = "Evolution Stone";
		this.recipient = 1;
	}
	public void play(Player player){
		Field field = player.field;
		int target = Io.playEvolutionstone(player);
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
