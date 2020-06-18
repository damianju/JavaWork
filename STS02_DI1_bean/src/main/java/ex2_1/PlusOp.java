package ex2_1;

public class PlusOp implements OperatorBean {
	private int operand1;
	private int operand2;
	
	public PlusOp() {
		super();
	}

	public PlusOp(int operand1, int operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	

	public int getOperand1() {
		return operand1;
	}

	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}

	@Override
	public int doOperate() {
		int value = operand1+operand2;
		return value;
	}

}
