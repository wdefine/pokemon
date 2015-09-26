package pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon extends Card {
	public String name;
	public String type;
	public int hp;
	public int hpmax;
	public int hpdistortion = 0;
	public String movename;
	public int movedamage;
	public int experience = 0;
	public List<Evolvedstate> evolutions = new ArrayList<Evolvedstate>();
	
	public void upExperience(){
		experience =+ 1;
	}
	public int attack(int advantage){
		return movedamage + advantage*20;
	}
	public void beattacked(int damage){
		hp =- damage;
	}
	public boolean isDead(){
		if (hp <= 0){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isPokemon(){
		return true;
	}
	public void trainMove(int change){
		movedamage =+ change;
	}
	public void trainHealth(int change){
		hpdistortion =+ change;
		hp =+ change;
	}
	public String getType(){
		return type;
	}
	public String getName(){
		return name;
	}
	public int getHp(){
		return hp;
	}
	public void evolve(){
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
}
