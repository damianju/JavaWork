package phonebook04.list;

import java.util.ArrayList;

// CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb {

	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();

	// singleton 적용
	private PhonebookManager() {
	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstatnce() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}// end getInstance()

	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		// 매개변수 검증: 이름 필수
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름 입력 오류:", Pb.ERR_EMTRY_STRING);
		}

		PhonebookModel pm = new PhonebookModel(name, phoneNum, memo);
		pm.setUid(getMaxUid() + 1);  //setUid 후 add!!
		pbList.add(pm);

		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		PhonebookModel[] arr = new PhonebookModel[pbList.size()];
		for (int i = 0; i < pbList.size(); i++) {
			arr[i] = pbList.get(i);
		}
		return arr;
		
		
		//return pbList.toArray(new PhonebookModel[pbList.size()]);
	}

	// 특정 uid 의 데이터 검색 리턴
	// 못 찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		for (PhonebookModel e : pbList) {
			if (e.getUid() == uid)
				return e;
		}
		return null; // 못 찾으면 null 리턴
	} // end method

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류:" + uid, Pb.ERR_UID);

		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름 입력 오류: ", Pb.ERR_EMTRY_STRING);

		// 특정 uid값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("update() 없는 uid:" + uid, Pb.ERR_UID);
		
		pbList.get(index).setName(name);
		pbList.get(index).setPhoneNum(phoneNum);
		pbList.get(index).setMemo(memo);

		return 1;
	}

	@Override
	public int deleteByUid(int uid) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류:" + uid, Pb.ERR_UID);

		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("deleteByUid() 없는 uid:" + uid, Pb.ERR_UID);

		pbList.remove(index);

		return 1;
	}

	// 현재 데이터 중 가장 큰 Uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;

		for (int index = 0; index < pbList.size(); index++) {
			if (maxUid < pbList.get(index).getUid()) {
				maxUid = pbList.get(index).getUid();
			}
		}

		return maxUid;
	}

	// 특정 uid값을 가진 데이터의 배열 인덱스 찾기
	// 못 찾으면 -1 리턴
	private int findIndexByUid(int uid) {
		for (int index = 0; index < pbList.size(); index++) {
			if (pbList.get(index).getUid() == uid) {
				return index;
			}
		}
		return -1;
	}

} // end class

// 예외 클래서 정의
// 예외 발생하면 '에러 코드' + '에러 메세지'를 부여하여 관리하는 게 좋다.
class PhonebookException extends RuntimeException {
	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook 예외 발생");
	}

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();
		return msg;
	}
} // end ex class
