
import java.util.Scanner;
public class Calculator
{
    
    
    
    public static int method1(int firstNum, int secondNum){
		int answer;
		answer = firstNum + secondNum;
		return answer;
	}

	public static int method2(int firstNum, int secondNum){
		int answer;
		answer = firstNum - secondNum;
		return answer;
	}
	public static int method3(int firstNum, int secondNum){
		int answer;
		answer = firstNum * secondNum;
		return answer;
	}
    
    
    public static void main (String [] args)
    {
	int mode;
	int firstNum;
	int solution;
	int secondNum;
	int numArray[] = new int[5];
	Scanner Keyboard = new Scanner (System.in);
	System.out.println("Press 1 to Add, 2 to subtract, or 3 to Multiply");
	mode=Integer.parseInt(Keyboard.nextLine ());
	if ( mode == 1 ){
		System.out.println("Enter 1st number to Add");
		firstNum=Integer.parseInt(Keyboard.nextLine ());
		Integer.parseInt(Keyboard.nextLine ());
		System.out.println("Enter 2nd number to Add");
		secondNum=Integer.parseInt(Keyboard.nextLine ());
		solution = method1(firstNum, secondNum);
		System.out.printf("%d + %d equals %d\n", firstNum, secondNum, solution);
	}
	if ( mode == 2 ){
		System.out.println("Enter 1st number to Subtract");
		firstNum=Integer.parseInt(Keyboard.nextLine ());
		System.out.println("Enter 2nd number to Subtract");
		secondNum=Integer.parseInt(Keyboard.nextLine ());
		solution = method2(firstNum, secondNum);
		System.out.printf("%d - %d equals %d\n", firstNum, secondNum, solution);
	}
	if ( mode == 3 ){
		System.out.println("Enter 1st number to Multiply");
		firstNum=Integer.parseInt(Keyboard.nextLine ());
		System.out.println("Enter 2nd number to Multiply");
		secondNum=Integer.parseInt(Keyboard.nextLine ());
		solution = method3(firstNum, secondNum);
		System.out.printf("%d * %d equals %d\n", firstNum, secondNum, solution);
	}
	
}
}
