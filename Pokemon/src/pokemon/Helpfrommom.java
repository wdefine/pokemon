package pokemon;

public class Helpfrommom extends Trainer {
	public Helpfrommom(){
		this.name = "Help from Mom";
		this.recipient = 1;
	}
	
	public void play(Player me, Player opponent){
		// get number of cards to draw
		int cards =0;
		if (me.deck.getDecksize() >= 3){
			cards = 3;
		}
		else{
			cards = me.deck.getDecksize();
		}
		// draw that number of cards
		for (int i = 3; i > 0; i--){
			if (me.deck.getDecksize() == 0){
				break;
			}
			me.hand.add(me.deck.draw());
		}
		System.out.println(me.name + " draws " + cards + " cards.\n");
	}
}
