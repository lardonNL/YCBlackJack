
public class Card {

	String cardType;
	int cardValue;
	String cardOfType;
	
	public Card(int cardTypeRef, int cardValueRef) {
		this.generateCard(cardTypeRef, cardValueRef);
	}
	 
	private void generateCard(int cardTypeRef, int cardValueRef) {
		this.generateCardType(cardTypeRef);
		this.generateCardValue(cardValueRef);
	}
	
	private void generateCardType(int cardTypeRef) {
		switch(cardTypeRef) {
			case 0:
//				System.out.println("schoppen");
				this.cardType = "schoppen";
				break;
			case 1:
//				System.out.println("harten");
				this.cardType = "harten";
				break;
			case 2:
//				System.out.println("klaveren");
				this.cardType = "klaveren";
				break;
			case 3:
//				System.out.println("ruiten");
				this.cardType = "ruiten";
				break;
			default:
		    // code block
		}
	}
	
	private void generateCardValue(int cardValueRef) {
		if (cardValueRef == 0) {
			this.cardValue = 11;
			this.cardOfType = "Aas";
		} else if (cardValueRef < 10) {
			this.cardValue = cardValueRef + 1;
			this.cardOfType = Integer.toString(cardValueRef + 1);
		} else if (cardValueRef == 10) {
			this.cardValue = 10;
			this.cardOfType = "Boer";
		} else if (cardValueRef == 11) {
			this.cardValue = 10;
			this.cardOfType = "Vrouw";
		} else if (cardValueRef == 12) {
			this.cardValue = 10;
			this.cardOfType = "Koning";
		}
		
		
	}
	
}
