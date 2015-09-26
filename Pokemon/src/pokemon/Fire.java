package pokemon;

public abstract class Fire extends Pokemon {
	
	public int compareTo(Pokemon pokemon){
		if (pokemon.getType().equals("water")){
			return -1;
		}
		else if (pokemon.getType().equals("grass")){
			return 1;
		}
		else{
			return 0;
		}
	}
}
