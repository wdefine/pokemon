package pokemon;

public class Abra extends Psychic {
	public Abra(){
	// sets variables equal to something
	this.name = "Abra";
	this.type = "psychic";
	this.hp = 40;
	this.hpmax = 40;
	this.movedamage = 0;
	this.movename = "@#$#%TeLePoRt@#$#%"; //this is intentional 
	// new evolved states to be added to list of evolutions set up in higher class
	Evolvedstate beta = new Evolvedstate("Alakazam", "SPOOOONS!", 70,110,70);
	//pokemon name, move name, added health, new max health, new move damage.
	evolutions.add(beta);
}
}