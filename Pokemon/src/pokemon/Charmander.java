package pokemon;

public class Charmander extends Fire {
	public Charmander(){
		this.name = "Charmander";
		this.type = "fire";
		this.hp = 60;
		this.hpmax = 60;
		this.movedamage = 20;
		this.movename = "Ember";
		Evolvedstate beta = new Evolvedstate("Charmeleon", "Flamethrower", 30,90,30);
		Evolvedstate alpha = new Evolvedstate("Charizard", "Flare Blitz", 30,120,60);
		evolutions.add(beta);
		evolutions.add(alpha);
		
	}
}
