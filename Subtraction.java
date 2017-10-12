
public class Subtraction extends OperationType{
	int getTypeCode(){
		return OperationType.SUBTRACTION;
	}

	void calculate(int firstNum, int secondNum) {
		  int solution = firstNum - secondNum;
		  System.out.printf("%d - %d equals %d\n", firstNum, secondNum, solution);
	  }
}
