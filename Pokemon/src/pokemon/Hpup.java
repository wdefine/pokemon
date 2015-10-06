package pokemon;


public class Hpup extends Trainer {
	public Hpup(){
		this.name = "HP UP";
		this.recipient = 1;
	}
	public void play(Player me, Player opponent){
		if (me.field.arena == null &&  me.field.bench.size() == 0){
			System.out.println("Your field is empty; HP UP cannot be played; HP UP returned to hand.\n");
			me.hand.add(new Hpup());
			return;
		}
		Field field = me.field;
		while (true){
			int target = Io.playHpup(me, opponent);
			if (target == -1){// escape function
				System.out.println("Play HP UP card cancelled!\n");
				me.hand.add(new Hpup());
				return;
			}

			else if (target == 0){
				if (field.arena != null){
					field.arena.hp += 20;
					field.arena.hpmax += 20;
					field.arena.hpdistortion += 20;
					System.out.println("HP UP card played on " + field.arena.name + " raising his health and max health by " + 20 + " to " + field.arena.hp + " and " + field.arena.hpmax + ".\n");
					return;
				}
				else{
					System.out.println("Your arena card is empty; try a bench card");
				}

			}
			else if (target> 0 && target <= me.field.bench.size()){
				if (field.bench.get(target-1) != null){
					field.bench.get(target-1).hp += 20;
					field.bench.get(target-1).hpmax += 20;
					field.bench.get(target-1).hpdistortion += 20;
					System.out.println("HP UP card played on " + field.bench.get(target-1).name + " raising his health and max health by " + 20 + " to " + field.bench.get(target-1).hp + " and " + field.bench.get(target-1).hpmax + ".\n");
					return;
				}
			}
			else{
				System.out.println("Please insert valid index number");
			}
		}
	}
}
