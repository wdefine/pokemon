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
	public void swap(int index){
		Pokemon newb = bench.get(index-1);
		bench.remove(index-1);
		if (arena == null){
			arena = newb;
		}
		else{
			bench.add(index-1, arena);
			arena = newb;
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
	public void printField(){
		System.out.println(arenaname);
		System.out.println("Index 0: (your arena card");
		if (arena != null){
			arena.print();
		}
		else{
			System.out.println("Arena positionis empty");
		}
		System.out.println(benchname);
		for (int i = 0; i < bench.size(); i++){
			int x = i+1;
			System.out.println("Index " + x + ":");
			bench.get(i).print();
		}
	}
	public void clearDead(){
		if (arena.hp <= 0){
			arena = null;
		}
	}
}
