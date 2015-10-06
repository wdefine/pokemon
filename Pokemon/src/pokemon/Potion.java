package pokemon;


public class Potion extends Trainer {
	public Potion(){
		this.name = "Potion";
		this.recipient = 1;
	}
	public void play(Player me, Player opponent){
		if (me.field.arena == null &&  me.field.bench.size() == 0){
			System.out.println("Your field is empty; Potion cannot be played; Potion returned to hand\n");
			me.hand.add(new Potion());
			return;
		}
		Field field = me.field;
		while (true){
			int target = Io.playPotion(me, opponent);
			if (target == -1){
				System.out.println("Play Potion card cancelled!\n");
				me.hand.add(new Potion());
				return;
			}
			else{
				if (target == 0){
					if (me.field.arena != null){
						if (field.arena.hp + 20 <= me.field.arena.hpmax){
							field.arena.hp += 20;
							field.arena.hpdistortion += 20;
							System.out.println("Potion card played on " + field.arena.name + " raising his health by " + 20 + " to " + field.arena.hp + ".\n");
							return;
						}
						else{
							int change = me.field.arena.hpmax - me.field.arena.hp;
							field.arena.hp += change;
							field.arena.hpdistortion += change;
							System.out.println("Potion card played on " + field.arena.name + " raising his health by " + change + " to " + field.arena.hp + ".\n");
							return;
						}
					}		
				}
				else if (target > 0 && target <= me.field.bench.size()){
					if (field.bench.get(target-1) != null){
						if (field.bench.get(target-1).hp + 20 <= me.field.bench.get(target-1).hpmax){
							field.bench.get(target-1).hp += 20;
							field.bench.get(target-1).hpmax += 20;
							field.bench.get(target-1).hpdistortion += 20;
							System.out.println("Potion card played on " + field.bench.get(target-1).name + " raising his health by " + 20 + " to " + field.bench.get(target-1).hp + ".\n");
							return;
						}
						else{
							int change = me.field.bench.get(target-1).hpmax - me.field.bench.get(target-1).hp;
							field.bench.get(target-1).hp += change;
							field.bench.get(target-1).hpdistortion += change;
							System.out.println("Potion card played on " + field.bench.get(target-1).name + " raising his health by " + change + " to " + field.bench.get(target-1).hp + ".\n");
							return;
						}
					}
				}
				else{
					System.out.println("Please insert valid index number");
				}
			}
		}
	}
}
