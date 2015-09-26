package pokemon;

public abstract class Trainer extends Card {
	public String name;
	
	public String getName(){
		return name;
	}
	public boolean isPokemon(){
		return false;
	}
	public void print(){
		System.out.println("Tranier Card");
		System.out.println(name);
	}
}
