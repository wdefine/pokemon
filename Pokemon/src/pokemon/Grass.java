package pokemon;

public abstract class Grass extends Pokemon {
	
	public int compareTo(Pokemon pokemon){
		if (pokemon.getType().equals("fire")){
			return -1;
		}
		else if (pokemon.getType().equals("water")){
			return 1;
		}
		else{
			return 0;
		}
	}
}
