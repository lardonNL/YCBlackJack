import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Deck {
	
	Card[] cardDeck = new Card[52];
	int lastCardPulled = 52;
	
	public Deck() {
		int[] deck = this.generateDeck();
		deck = this.shuffleDeck(deck);
		this.createCards(deck);
	}
	
	public int[] generateDeck () {
		return IntStream.rangeClosed(0, 51).toArray();
	}
	
	public int[] shuffleDeck (int[] deck) {
		Random rand = new Random();
		for (int i = 0; i < deck.length; i++) {
			int randomIndexToSwap = rand.nextInt(deck.length);
			int temp = deck[randomIndexToSwap];
			deck[randomIndexToSwap] = deck[i];
			deck[i] = temp;
		}
		return deck;
	}
	
	public void createCards (int[] deck) {
		for (int i = 0; i < deck.length; i++) {
			int cardTypeRef = deck[i] / 13;
			int cardvalueRef = deck[i] % 13;
//			System.out.println(Integer.toString(cardTypeRef) + " " + Integer.toString(cardvalueRef));
			cardDeck[i] = new Card(cardTypeRef, cardvalueRef);
//			System.out.println(cardDeck[i].cardType + " " + cardDeck[i].cardOfType);
		}
	}
	
	public Card drawCard() {
		if (lastCardPulled >= 0) {
			lastCardPulled--;
			System.out.println("Je trok " + cardDeck[lastCardPulled].cardType + " "	+cardDeck[lastCardPulled].cardOfType);
			return cardDeck[lastCardPulled];
		} else {
			System.out.println("Deck is leeg. Je krijgt de laatste kaart.");
			return cardDeck[0];
		}
	}
	
	public int countPoints(ArrayList<Card> playerDeck){
		int totalValue = 0;
		for (Card card : playerDeck) {
			totalValue += card.cardValue;
		}
		return totalValue;
	}
	
	public ArrayList<Card> checkPointsAfterDraw(ArrayList<Card> playerDeck){
		int totalValue = countPoints(playerDeck);
		
		if (totalValue > 21) {
			System.out.println("Je had meer dan 21 punten");
			return new ArrayList<Card>();
		}
		else {
			System.out.println("Je hebt " + Integer.toString(totalValue) + " punten.");
			return playerDeck;
		}
		
	}
}
