package pokemon;

public class Evolvedstate {
	private String newname;
	private String newmovename;
	private int healthbonus;
	private int newmovedamage;
	private int newhpmax;
	
	public Evolvedstate(String newname, String newmovename, int healthbonus, int newhpmax, int newmovedamage){
		this.setNewname(newname);
		this.setNewmovename(newmovename);
		this.setHealthbonus(healthbonus);
		this.setNewmovedamage(newmovedamage);
		this.setNewhpmax(newhpmax);
	}

	public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public String getNewmovename() {
		return newmovename;
	}

	public void setNewmovename(String newmovename) {
		this.newmovename = newmovename;
	}

	public int getHealthbonus() {
		return healthbonus;
	}

	public void setHealthbonus(int healthbonus) {
		this.healthbonus = healthbonus;
	}

	public int getNewmovedamage() {
		return newmovedamage;
	}

	public void setNewmovedamage(int newmovedamage) {
		this.newmovedamage = newmovedamage;
	}

	public int getNewhpmax() {
		return newhpmax;
	}

	public void setNewhpmax(int newhpmax) {
		this.newhpmax = newhpmax;
	}
}
