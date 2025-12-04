package shubham;

public class Cal_class {

	private int  num1;
	private int num2;
	private String operation;
	
	public Cal_class(int num1, int num2, String operation) {

		this.num1 = num1;
		this.num2 = num2;
		this.operation = operation;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Cal_class [num1=" + num1 + ", num2=" + num2 + ", operation=" + operation + "]";
	}
	
	
	
	
	
	
	
	
}
