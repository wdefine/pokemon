package pokemon;

public class Growlithe extends Fire {
	public Growlithe(){ //filling in the stats for each pokemon
		this.name = "Growlithe";
		this.type = "fire"; 
		this.hp = 80;
		this.hpmax = 80;
		this.movedamage = 20;
		this.movename = "Bite!";
		Evolvedstate beta = new Evolvedstate("Arcanine", "Fire Fang!", 20,100,40); //filling in the stats for 2 evolved form
		//pokemon name, move name, added health, new max health, new move damage
		evolutions.add(beta); //adding the evolved forms to the evolved list
	}
}