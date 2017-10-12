
import java.util.Scanner;
public class Calculator
{
    private int _mode;
    Scanner Keyboard = new Scanner (System.in);
    
    public Calculator(int mode){
		
		setMode (mode);
	}
    
    int getMode(){
		return _mode;
	}
	
	void setMode(int arg){
		_mode = arg;
	} 
	
    /* Extracted the calculation from the main method and created its own method*/
    
    public  void calculate(int mode){
		int firstNum;
		int solution;
		int secondNum;
		
		if ( getMode() == 1 ){
			System.out.println("Enter 1st number to Add");
			firstNum=Integer.parseInt(Keyboard.nextLine ());
			System.out.println("Enter 2nd number to Add");
			secondNum=Integer.parseInt(Keyboard.nextLine ());
			solution = add(firstNum, secondNum);
			System.out.printf("%d + %d equals %d\n", firstNum, secondNum, solution);
		}
		if ( getMode() == 2 ){
			System.out.println("Enter 1st number to Subtract");
			firstNum=Integer.parseInt(Keyboard.nextLine ());
			System.out.println("Enter 2nd number to Subtract");
			secondNum=Integer.parseInt(Keyboard.nextLine ());
			solution = subtract(firstNum, secondNum);
			System.out.printf("%d - %d equals %d\n", firstNum, secondNum, solution);
		}
		if ( getMode() == 3 ){
			System.out.println("Enter 1st number to Multiply");
			firstNum=Integer.parseInt(Keyboard.nextLine ());
			System.out.println("Enter 2nd number to Multiply");
			secondNum=Integer.parseInt(Keyboard.nextLine ());
			solution = multiply(firstNum, secondNum);
			System.out.printf("%d * %d equals %d\n", firstNum, secondNum, solution);
		}
	}
    
    
    //Renamed the methods to improve clarity
    
    public static int add(int firstNum, int secondNum){ 
		int answer;
		answer = firstNum + secondNum;
		return answer;
	}

	public static int subtract(int firstNum, int secondNum){
		int answer;
		answer = firstNum - secondNum;
		return answer;
	}
	public static int multiply(int firstNum, int secondNum){
		int answer;
		answer = firstNum * secondNum;
		return answer;
	}
    
    
    public static void main (String [] args)
    {
	

	Scanner Keyboard = new Scanner (System.in);
	System.out.println("Press 1 to Add, 2 to subtract, or 3 to Multiply");
	int mode=Integer.parseInt(Keyboard.nextLine ());
	Calculator calc = new Calculator(mode);
	calc.calculate(mode);

	
}
}
