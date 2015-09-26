package pokemon;

public class Evolutionstone extends Trainer {
	public Evolutionstone(){
		this.name = "Evolution Stone";
		
	}
	public void play(Pokemon pokemon){
		pokemon.evolve();
	}
}
