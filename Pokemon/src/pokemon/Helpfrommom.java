package pokemon;

public class Helpfrommom extends Trainer {
	public Helpfrommom(){
		this.name = "Help from Mom";
		this.recipient = 1;
	}
	
	public void play(Player player){
		for (int i = 3; i > 0; i--){
			if (player.deck.getDecksize() == 0){
				break;
			}
			player.hand.add(player.deck.draw());
		}
	}
}
