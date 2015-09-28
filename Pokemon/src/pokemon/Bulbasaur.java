package pokemon;

public class Bulbasaur extends Grass {
	public Bulbasaur(){
		this.name = "Bulbasaur";
		this.type = "grass";
		this.hp = 60;
		this.hpmax = 60;
		this.movedamage = 20;
		this.movename = "Vine Whip!";
		Evolvedstate beta = new Evolvedstate("Ivysaur", "Razor Leaf!", 40,100,30);
		Evolvedstate alpha = new Evolvedstate("Venasaur", "Solar Beam!", 40,140,50);
		//pokemon name, move name, added health, new max health, new move damage.
		evolutions.add(beta);
		evolutions.add(alpha);
	}
}