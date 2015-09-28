package pokemon;

public class Squirtle extends Water {
	public Squirtle(){
		this.name = "Squirtle";
		this.type = "water";
		this.hp = 60;
		this.hpmax = 60;
		this.movedamage = 20;
		this.movename = "Water Gun!";
		Evolvedstate beta = new Evolvedstate("Wartortle", "Bubble!", 40,100,20);
		Evolvedstate alpha = new Evolvedstate("Blastoise", "Hydro Pump!", 20,120,60);
		//pokemon name, move name, added health, new max health, new move damage
		evolutions.add(beta);
		evolutions.add(alpha);
	}
}