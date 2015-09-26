package pokemon;

public abstract class Water extends Pokemon {
	
	public int compareTo(Pokemon pokemon){
		if (pokemon.getType().equals("grass")){
			return -1;
		}
		else if (pokemon.getType().equals("electric")){
			return -1;
		}
		else if (pokemon.getType().equals("fire")){
			return 1;
		}
		else{
			return 0;
		}
	}
}
