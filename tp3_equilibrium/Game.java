package tp3_equilibrium;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;

public class Game {
	static void play(Player player1, Player player2) {
		/*
    if (p1.cards.size() != p2.cards.size()) {
      throw new IllegalStateException("not same number of cards");
    }
    if (p1.cards.stream().mapToInt(Card::getDamage).sum() !=
        p2.cards.stream().mapToInt(Card::getDamage).sum()) {
      throw new IllegalStateException("no equilibrium");
    }*/

		Iterator<Action> it1 = player1.action();
		Iterator<Action> it2 = player2.action();
		while(it1.hasNext() && it2.hasNext()) {
			Action action1 = it1.next();
			Action action2 = it2.next();
			action1.apply(player1, player2);
			action2.apply(player2, player1);

			if (player1.isDead() && player2.isDead()) {
				System.out.println("no winner");
				return;
			}
			if (player1.isDead()) {
				System.out.println(player2.getName() + " wins");
				return;
			}
			if (player2.isDead()) {
				System.out.println(player1.getName() + " wins");
				return;
			}
		}
		System.out.println("draw");
	}

	public static void main(String[] args) throws IOException {
		Player p1 = Player.create("bob", Paths.get("td3/bob-deck.txt"));
		Player p2 = Player.create("alice", Paths.get("td3/alice-deck.txt"));
		play(p1, p2);
	}
}
