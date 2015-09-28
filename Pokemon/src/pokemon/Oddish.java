package pokemon;

public class Oddish extends Grass {
	public Oddish(){
		this.name = "Oddish";
		this.type = "grass";
		this.hp = 40;
		this.hpmax = 40;
		this.movedamage = 30;
		this.movename = "Spore Slap!";
		Evolvedstate beta = new Evolvedstate("Gloom", "Acid", 30,70,30);
		//pokemon name, move name, added health, new max health, new move damage
		evolutions.add(beta);
	}
}