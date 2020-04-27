package practice.cardcompany;

public class Company {
	
	private Company () {}  // private 생성자가 빠졌음!!! (singleton 디자인)

	private static Company instance = null;

	public static Company getInstance() {
		if (instance == null) {
			instance = new Company();
		} // end if
		return instance;
	} // end method

	int n = 10001; 						// 초기값 설정

	public Card createCard() { 			// 카드 생성 메소드
		Card cardName = new Card(n); 	// 카드 생성
		n++; 							// 1씩 증가

		return cardName;
	
	} // end method


} // end class
