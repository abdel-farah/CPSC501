import java.util.*;
import java.lang.reflect.*;


public class Inspector{

	public Inspector(){}
	public void inspect(Object obj, boolean recursive){
	    Class classObject = obj.getClass();
	    Method[] methodArray = classObject.getDeclaredMethods();
	    Field[] fieldArray = classObject.getDeclaredFields();
     
	    System.out.println("inside inspector: " + obj + " (recursive = "+recursive+")");
	  
	    for ( int i =0; i< methodArray.length; i++){
		String name = methodArray[i].getName();
		Class type = methodArray[i].getReturnType();
		int modifier = methodArray[i].getModifiers();
		Class[] exceptArray = methodArray[i].getExceptionTypes();
		Class[] paramArray = methodArray[i].getParameterTypes();
		
		System.out.print("method:" + name + " type:" + type + " modifier:" + modifier);
			
			for ( int j =0; j < exceptArray.length; j++){
				System.out.print(" Exceptions: " + exceptArray[j].getName());
			}
			
			for ( int h =0; h < paramArray.length; h++){
				System.out.print(" Parameters: " + paramArray[h].getName());
			}
			System.out.println();
		}
	    
	    for (int i = 0; i<  fieldArray.length; i++){
		//String name = fieldArray[i].getName();
		try
		    {
			String name = fieldArray[i].getName();
			fieldArray[i].setAccessible(true);
			Object value = fieldArray[i].get(obj);
		    Class type = fieldArray[i].getType();
			System.out.println("Field:" + name + " value:" + value + " type:" + type);
		    }
		catch(Exception e) {}  { 
			
	    }
		
		//Class type = fieldArray[i].getType();
		//System.out.println("Field: " + name + " value:" + value + " type:" + type);
	    }
	    
	}
}
