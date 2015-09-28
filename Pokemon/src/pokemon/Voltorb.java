package pokemon;

public class Voltorb extends Electric {
	public Voltorb(){
		this.name = "Voltorb";
		this.type = "electric";
		this.hp = 70;
		this.hpmax = 70;
		this.movedamage = 20;
		this.movename = "ShOcK!";
		Evolvedstate beta = new Evolvedstate("Electrode", " #$%@ IT EXPLODED!", 30,90,10000);
		//pokemon name, move name, added health, new max health, new move damage
		evolutions.add(beta);
	}
}