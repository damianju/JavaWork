package practice.cardcompany;

public class Card {

	// instance variable
	private int cardNumber;

	// 기본 생성자
	public Card() {
	}

	// 매개변수 생성자
	public Card(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	// getter
	public int getCardNumber() {
		return cardNumber;
	}
	
	// setter
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

} // end class
