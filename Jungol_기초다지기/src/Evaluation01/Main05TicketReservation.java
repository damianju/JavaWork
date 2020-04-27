package Evaluation01;
/*
 * 영화 예매 내역을 담을 객체를 TicketReservation 이라는 이름의 자바 클래스로 정의하고자 합니다   다음과 같은 ‘속성’ 을 가진 클래스를 정의하고, 기본생성자와 매개변수를 받는 생성자와 getter & setter 를 순서대로 클래스에 작성하세요

멤버변수 명

객체의 속성

uid

예매 고유한 아이디 값으로 정수타입

movieId

예배 영화 id 값, 정수타입

seatId

좌석 id 값,  정수타입

regDate

예매일, 날짜(Date) 타입
 * 
 * 
 */
import java.util.Date;

public class Main05TicketReservation {

	private int uid;
	private int movieId;
	private int seatId;
	private Date regDate;

	public Main05TicketReservation() {

	}

	public Main05TicketReservation(int uid, int movieId, int seatId, Date regDate) {

		this.uid = uid;
		this.movieId = movieId;
		this.seatId = seatId;
		this.regDate = new Date();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
