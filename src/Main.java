import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userinput = "w";
		ArrayList<Card> playerDeck = new ArrayList<Card>();

		Deck deck = new Deck();

		for (int i = 0; i < 10; i++) {
			Card card = deck.drawCard();
			System.out.println(card.cardType + " " + card.cardOfType);
		}
		
		while(!userinput.equals("q")){
			
			System.out.println("wil je een (k)aart? wil je (p)assen? wil je (q)uiten?");
			userinput = sc.next();
			System.out.println(userinput);
			System.out.println("Get input. was " + userinput);
			
			switch(userinput) {
				case "q":
				    System.out.println("Het spel eindigd nu.");
				    break;
				case "k":
				    System.out.println("Je krijgt een nieuwe kaart.");
				    // System.out.println(Integer.toString(playerDeck.size()));
				    playerDeck.add(deck.drawCard());
				    playerDeck = deck.checkPointsAfterDraw(playerDeck);
				    break;
				case "p":
				    System.out.println("Je past.");
				    System.out.println("Je had " +Integer.toString(deck.countPoints(playerDeck)) + " punten.");
				    deck.countPoints(playerDeck);
				    playerDeck = new ArrayList<Card>(); 
				    break;
				default:
					System.out.println("Geen geldige invoer.");
			    // code block
			}
		}
		
	}

}
