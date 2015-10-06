package pokemon;


public class Gustofwind extends Trainer {
	public Gustofwind(){
		this.name = "Gust of Wind";
		this.recipient = -1;
	}
	public void play(Player me, Player opponent){
		if (opponent.field.bench.size() == 0){// can we actually play this card
			System.out.println("Your field is empty; Gust of Wind cannot be played; Gust of Wind returned to hand.\n");
			me.hand.add(new Gustofwind());// return to hand if not
			return;
		}
		Field field = opponent.field;
		while (true){// create while loop until valid number is given 
			int target = Io.playGustofWind(me, opponent);
			if (target == -1){// escape number
				System.out.println("Play Gust of Wind card cancelled!\n");
				me.hand.add(new Gustofwind());
				return;
			}
			else if (target == 0){//arena card
				System.out.println("Gust of Wind cannot be used on arena card. Gust of Wind card lost.\n");
				return;
			}	
			else if (target>0 && target <= opponent.field.bench.size()){// bench card
				field.swap(target-1, opponent);
				if (opponent.field.arena == null){//print statements
					System.out.println(opponent.field.bench.get(target-1).name + " enters the arena.\n");
				}
				else{
					System.out.println(opponent.field.bench.get(target-1).name + " replaces " + opponent.field.arena.name + " in the arena.\n");
				}
				return;
			}
			else{// try again!
				System.out.println("Please insert valid index number");
			}
		}
	}
}
