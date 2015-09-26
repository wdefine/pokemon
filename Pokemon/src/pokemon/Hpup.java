package pokemon;

public class Hpup extends Trainer {
	public Hpup(){
		this.name = "HP UP";
	}
	public void play(Pokemon pokemon){
		pokemon.hp =+ 20;
		pokemon.hpmax =+ 20;
		pokemon.hpdistortion =+ 20;
	}
}
