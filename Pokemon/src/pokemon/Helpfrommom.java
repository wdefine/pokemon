package pokemon;

public class Helpfrommom extends Trainer {
	public void play(Player player){
		for (int i = 3; i > 0; i--){
			player.hand.add(player.deck.draw());
		}
	}
}
