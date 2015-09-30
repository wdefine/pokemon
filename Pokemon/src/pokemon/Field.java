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
		}
		else{
			player.field.bench.add(player.field.arena);
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
		else{
			System.out.println("Arena position is empty");
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
	}
	public void clearDead(){
		if (arena.hp <= 0){
			arena = null;
		}
	}
	public void upExperience(){
		arena.upExperience();
		for(int i = 0; i < bench.size(); i++){
			bench.get(i).upExperience();
		}
	}
}