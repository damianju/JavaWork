package 반복제어문1.자가진단01;

public class Main5 {

	public static void main(String[] args) {
		System.out.println("Singleton 디자인 패턴");
		
		Test t1 = Test.getInstance();
		System.out.println("t1: num= "+t1.getNum());
		t1.setNum(123);
		System.out.println("t1: num= "+t1.getNum());
		
		Test t2 = Test.getInstance();
		System.out.println("t2: num= "+t2.getNum());
		t2.setNum(500);
		System.out.println("t1: num= "+t1.getNum());

	}

}
