package pokemon;

public class Potion extends Trainer {
	public Potion(){
		this.name = "Potion";
	}
	public void play(Pokemon pokemon){
		if (pokemon.hp + 20 <= pokemon.hpmax){
			pokemon.hp =+ 20;
			pokemon.hpdistortion =+20;
		}
		else{
			int change = pokemon.hpmax - pokemon.hp;
			pokemon.hp =+ change;
			pokemon.hpdistortion =+ change;
		}
	}
}
