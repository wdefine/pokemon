package pokemon;

public class Magnemite extends Electric {
	public Magnemite(){
		this.name = "Magnemite";
		this.type = "Electric";
		this.hp = 60;
		this.hpmax = 60;
		this.movedamage = 30;
		this.movename = "TH TH TH THUNDERSHOCK!!!!!!!!!!!!!!";
		Evolvedstate beta = new Evolvedstate("Magneton", "Electro Ball!", 40,100,50);
		//pokemon name, move name, added health, new max health, new move damage
		evolutions.add(beta);
	}
}