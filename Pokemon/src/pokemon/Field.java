package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Field {
	public String arenaname;
	public String benchname;
	public Pokemon arena;
	public List<Pokemon> bench = new ArrayList<Pokemon>();
	
	public Field(String name){
		this.arenaname = name + "'s arena";
		this.benchname = name + "'s bench";
	}
	public void swap(int index, Player player){
		Pokemon newb = player.field.bench.get(index);
		player.field.bench.remove(index);
		if (player.field.arena == null){
			player.field.arena = newb;
			System.out.println(player.field.arena.name + " has entered the arena!\n");
		}
		else{
			player.field.bench.add(player.field.arena);
			System.out.println(newb.name + " replaces " + player.field.arena.name + " in the arena!\n");
			player.field.arena = newb;
			
		}
	}
	public void addField(Pokemon card){
		if (arena == null){
			arena = card;
		}
		else if (bench.size() < 6){
			bench.add(card);
		}
	}
	public void printField(Player player){
		System.out.println(player.field.arenaname);
		System.out.println("Index 0: (arena card)");
		if (player.field.arena != null){
			player.field.arena.print();
			System.out.println("");
			if (player.field.bench.size() == 0){
				System.out.println(player.field.benchname);
				System.out.println("Bench is empty");
			}
			else{
				System.out.println(player.field.benchname);
				for (int i = 0; i < player.field.bench.size(); i++){
					int x = i+1;
					System.out.println("Index " + x + ":");
					player.field.bench.get(i).print();
					System.out.println("");
				}
			}
		}
		else{
			System.out.println("Arena position is empty\n");
			if (player.field.bench.size() == 0){
				System.out.println(player.field.benchname);
				System.out.println("Bench is empty");
			}
			else{
				System.out.println(player.field.benchname);
				for (int i = 0; i < player.field.bench.size(); i++){
					int x = i+1;
					System.out.println("Index " + x + ":");
					player.field.bench.get(i).print();
				}
			}
		}	
		System.out.println("");
	}
	public void clearDead(Player player){
		if (player.field.arena.hp <= 0){
			player.field.arena = null;
		}
	}
	public void upExperience(Player me){
		if (me.field.arena != null){
			me.field.arena.upExperience();
			for(int i = 0; i < me.field.bench.size(); i++){
				me.field.bench.get(i).upExperience();
			}
		}
		else{
			for(int i = 0; i < me.field.bench.size(); i++){
				me.field.bench.get(i).upExperience();
			}
		}
	}
}