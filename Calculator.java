/* Abdulaziz Farah
 * Calculator program
 * performs 3 operations, subtract, add, and multiplay
 */

import java.util.Scanner;
public class Calculator
{
    private OperationType _mode;
	
    static final int ADDITION = 1;
    static final int SUBTRACTION = 2;
    static final int MULTIPLICATION = 3;

    Scanner Keyboard = new Scanner (System.in);
    
    public Calculator(int mode){
		
		setMode (mode);
	}
    
    int getMode(){
		return _mode.getTypeCode();
	}
	
	void setMode(int arg){
		switch(arg){
			case ADDITION:
				_mode = new Addition();
				break;
			case SUBTRACTION:
				_mode = new Subtraction();
				break;
			case MULTIPLICATION:
				_mode = new Multiplication();
				break;
			default:
				throw new IllegalArgumentException("Incorrect Calculator mode");
		}
	} 
	
    /* Extracted the calculation from the main method and created its own method*/
    
    public  void calculate(int firstNum, int secondNum) // added parameters, removed mode as a parameter
    { 
		
    	_mode.calculate(firstNum, secondNum);		//removed conditional statements
	}
    
    
    //Renamed the methods to improve clarity
    
  /* ADDED THESE THREE METHODS BACK JUST TO USE IN MY JUNIT TEST, NOT USED IN MY PROGRAM*/
    
    
    static int  add(int firstNum, int secondNum) {
		  int solution = firstNum + secondNum;
		  System.out.printf("%d + %d equals %d\n", firstNum, secondNum, solution);
		  return solution;
    }
    
    static int multiply(int firstNum, int secondNum) {
		  int solution = firstNum * secondNum;
		  System.out.printf("%d * %d equals %d\n", firstNum, secondNum, solution);
		  return solution;
    }
    
    static int subtract(int firstNum, int secondNum) {
		  int solution = firstNum - secondNum;
		  System.out.printf("%d - %d equals %d\n", firstNum, secondNum, solution);
		  return solution;
    }
    public static void main (String [] args)
    {
	int firstNum, secondNum;
	
	Scanner Keyboard = new Scanner (System.in);
	System.out.println("Press 1 to Add, 2 to subtract, or 3 to Multiply");
	int mode=Integer.parseInt(Keyboard.nextLine ());
	
	
	Calculator calc = new Calculator(mode);
	System.out.println("Enter 1st number");
	firstNum=Integer.parseInt(Keyboard.nextLine ());
	System.out.println("Enter 2nd number");
	secondNum=Integer.parseInt(Keyboard.nextLine ());
	calc.calculate( firstNum, secondNum);
	Keyboard.close();
	
}
}


