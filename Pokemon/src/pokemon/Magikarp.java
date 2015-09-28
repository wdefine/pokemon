package pokemon;

public class Magikarp extends Water {
	public Magikarp(){
		this.name = "Magikarp";
		this.type = "water";
		this.hp = 100;
		this.hpmax = 100;
		this.movedamage = 0;
		this.movename = "Splash!";
		Evolvedstate beta = new Evolvedstate("Gyarados", "Hyper Beam!", 50,150,50);
		//pokemon name, move name, added health, new max health, new move damage
		evolutions.add(beta);
	}
}