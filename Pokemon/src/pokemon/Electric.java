package pokemon;

public abstract class Electric extends Pokemon {
	public int compareTo(Pokemon pokemon){
		if (pokemon.getType().equals("water")){
			return 1;
		}
		else{
			return 0;
		}
	}
}
