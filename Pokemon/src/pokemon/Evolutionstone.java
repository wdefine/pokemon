package pokemon;


public class Evolutionstone extends Trainer {
	public Evolutionstone(){
		this.name = "Evolution Stone";
		this.recipient = 1;
	}
	public void play(Player me, Player opponent){
	
		if (me.field.arena == null &&  me.field.bench.size() == 0){
			System.out.println("Your field is empty; Evolution Stone cannot be played; Evolution Stone returned to hand\n");
			me.hand.add(new Evolutionstone());
			return;
		}
		Field field = me.field;
		while (true){
			int target = Io.playEvolutionstone(me, opponent);
			if (target == -1){// escape #
				System.out.println("Play Evolution card cancelled!\n");
				me.hand.add(new Evolutionstone());
				return;
			}
			else if (target == 0){// arena card
				if (field.arena != null){
					if (field.arena.experience >= 3){
						String oldname = field.arena.name;
						field.arena.evolve();
						System.out.println(oldname + " has evolved into " + field.arena.name + ".\n");
						return;
					}
					else{
						System.out.println("You cannot evolve this pokemon because it doesnt have at least 3 experience");
					}
				}
				else{
					System.out.println("You can't evolve your arena because it is empty");
				}
			}
			else if (target > 0 && target <= me.field.bench.size()){// bench card
				if (field.bench.get(target-1).evolutions.size() == 0){
					System.out.println("You cannot evolve this pokemon any further. Chose another pokemon to evolve.");
				}
				else{
					if (field.arena.experience >= 3){
						String oldname = field.bench.get(target-1).name;
						field.bench.get(target-1).evolve();
						System.out.println(oldname + " has evolved into " + field.bench.get(target-1).name + ".\n");
						return;
					}
					else{
						System.out.println("You cannot evolve this pokemon because it doesnt have at least 3 experience");
					}
				}

			}
			else{// try again
				System.out.println("Please insert valid index number");
			}
		}
	}
}
