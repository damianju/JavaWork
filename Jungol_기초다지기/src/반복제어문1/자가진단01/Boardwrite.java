package 반복제어문1.자가진단01;

public class Boardwrite {
	int uid;
	String subject;
	String content;
	int viewCnt;
	public Boardwrite() {
	
	}
	public Boardwrite(int uid, String subject, String content, int viewCnt) {

		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.viewCnt = viewCnt;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	

}
