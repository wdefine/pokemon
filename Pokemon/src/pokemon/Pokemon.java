package pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon extends Card {
	abstract int compareTo(Pokemon pokemon);
	public String name;
	public String type;
	public int hp;
	public int hpmax;
	public int hpdistortion = 0;
	public String movename;
	public int movedamage;
	public int experience = 0;
	public List<Evolvedstate> evolutions = new ArrayList<Evolvedstate>();
	
	public void upExperience(){ // adds experience
		experience += 1;
	}
	public int attack(int advantage){//outputs attack damage based on opponent type
		// advantage == 1,0, or -1 depending on compareTo output; then multiply by 20
		if (movedamage > 5000){
			hp -= 60;
			return movedamage + advantage*20;
		}
		else{
			return movedamage + advantage*20;
		}
	}
	public void beattacked(int damage){// takes in integer and hurts hp
		hp -= damage;
	}
	public boolean isPokemon(){ //is it a pokemon
		return true;
	}
	public String getType(){ //what is its' type for compareTo
		return type;
	}
	public void evolve(){ 
		/*
		 * if there is a new evolution state
		 * new state variables are stored in next evolutions item
		 * reset variables = to new ones
		 */
		if ((experience >= 3) && (evolutions.isEmpty() == false)){
			Evolvedstate newb = evolutions.get(0);
			name = newb.getNewname();
			movename = newb.getNewmovename();
			hp = newb.getHealthbonus() + hp - hpdistortion;
			hpmax = newb.getNewhpmax();
			movedamage = newb.getNewmovedamage();
			hpdistortion = 0;
			experience = 0;
		}
	}
	public void print(){ // print pokemon
		System.out.println("Pokemon Card");
		System.out.print("Name = " + name);
		System.out.print("; Type = " + type);
		System.out.print("; Move = " + movename);
		System.out.print("; Move Damage = " + movedamage);
		System.out.print("; Health = " + hp);
		System.out.print("; Experience = " + experience + "\n");
	}
	public void printEvolved(){
		System.out.println("Pokemon Card");
		System.out.print("Name = " + name);
		System.out.print("; Type = " + type);
		System.out.print("; Move = " + movename);
		System.out.print("; Move Damage = " + movedamage);
		System.out.print("; Health = " + hp);
		System.out.print("; Experience = " + experience + "\n");
		System.out.print("New Name = " + evolutions.get(0).getNewname());
		System.out.print("; New Move = " + evolutions.get(0).getNewmovename());
		System.out.print("; New Move Damage = " + evolutions.get(0).getNewmovedamage());
		int newhp = hp + evolutions.get(0).getHealthbonus();
		System.out.print("; New Health = " + newhp);
		System.out.print("; New Experience = " + "0" + "\n");
	}
}
