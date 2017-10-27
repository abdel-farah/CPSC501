import java.util.*;
import java.lang.reflect.*;


public class Inspector{

	public Inspector(){}
	public void inspect(Object obj, boolean recursive){
	   
	    Class classObject = obj.getClass();
		Class superClassObject = classObject.getSuperclass();
		
	    System.out.println("inside inspector: " + obj + " (recursive = "+recursive+")");
		
		
		
		if (superClassObject != null ){
			System.out.println("super class: " + superClassObject.getName());
		}
	   
	  	printInterface(classObject);	   
	   	printConstructors(classObject);
	   	printMethods(classObject);
	    printFields(obj, classObject);
	    
	}
	public void printInterface(Class classObject){
		  Class[] interArray = classObject.getInterfaces();
		  
		  for ( int i = 0; i<interArray.length; i++){
			System.out.println("interface(s): " + interArray[i].getName());
	   }
	   }
	
	
	public void printConstructors(Class classObject){
		 Constructor[] constArray = classObject.getConstructors();

		 for ( int i = 0; i<constArray.length; i++){
			Class[] paramArray = constArray[i].getParameterTypes();
			int modifier = constArray[i].getModifiers();
			String name = constArray[i].getName();
			System.out.print("Constructor: " + name + " modifier: " + modifier);

			for ( int h =0; h < paramArray.length; h++){
				System.out.print(" Parameters: " + paramArray[h].getName());
	   }
   
			
			System.out.println();
   }
	}
	
	public void printMethods(Class classObject){
		Method[] methodArray = classObject.getDeclaredMethods();

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
	}
	
	public void printFields(Object obj, Class classObject){
		Field[] fieldArray = classObject.getDeclaredFields();
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
	


