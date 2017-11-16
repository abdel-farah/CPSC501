import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.lang.reflect.*;
import java.net.Socket;
import java.io.*;
import java.net.*;
public class objectCreator {
	//static simplePrimitive object1 = new simplePrimitive(0,"");
	
	public static void main(String args[]) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the object creator");
		System.out.println("Please select an object to create");
		System.out.println("---------------------------------");
		System.out.println("Press 1 for an object with only primitives as instance variables");
		System.out.println("Press 2 for an object that contains references to other objects");
		System.out.println("Press 3 for an object that contains an integer array");
		System.out.println("Press 4 for an object that contains an array of object references");
		System.out.println("");
		Object object = null;
		int mode =Integer.parseInt(keyboard.nextLine());
		switch (mode)
		{
			case 1: object = createSimple();
					break;
			case 2: object = createObjRef();
					break;
			case 3: object = createArrayPrimitives();
					break;
			case 4: createArrayObject();
					break;
		}
		Serializer s = new Serializer(object);
		//s.serialize(object);
		Deserializer d = new Deserializer(s.serialize(object));
		d.deserializer(s.serialize(object));
		keyboard.close();
	}
/*
	private static void send() throws Exception{
		//Initialize socket
        Socket socket = new Socket(InetAddress.getByName("localhost"), 5000);
        byte[] contents = new byte[10000];
        
        //Initialize the FileOutputStream to the output file's full path.
        FileOutputStream fos = new FileOutputStream("result.xml");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        InputStream is = socket.getInputStream();
        
        //No of bytes read in one read() call
        int bytesRead = 0; 
        
        while((bytesRead=is.read(contents))!=-1)
            bos.write(contents, 0, bytesRead); 
        
        bos.flush(); 
        socket.close(); 
        
        System.out.println("File saved successfully!");

    
	}
	*/
	private static void createArrayObject() {
		// TODO Auto-generated method stub
		
	}

	private static Object createArrayPrimitives() throws Exception{
		Scanner keyboard = new Scanner(System.in);
	   // int initial[] = new int[5]; 
		//arrayPrimitives primArray = new arrayPrimitives(intial);
		Class classObject = Class.forName("arrayPrimitives");
       
		Constructor c = classObject.getConstructor(new Class[] {});
		Object primArray = c.newInstance();
		
		Class intArray = Class.forName("[I");
		Field data = classObject.getDeclaredField("data");
		Object array = Array.newInstance(int.class, 5);
		boolean t = array.getClass().isArray();
		System.out.println(t);
		System.out.println("Would you like to set the values in this array?\n\nPress 1 to change values\nPress 0 to keep initial values");
		int answer = keyboard.nextInt();
		boolean flag = true;
		int i = 0;
		if ( answer == 1){
			while( i < 5){
				System.out.println("Enter the value for the array at index:" + i);
				int value = keyboard.nextInt();
				Array.setInt(array, i, value);
				i++;
			}
			data.set(primArray, array);
			System.out.println("Updated array");
			for (int j =0; j < 5; j++){
				System.out.println("Array at [" + j + "] =" + Array.getInt(array, j));
			}
		}
		else{
			System.out.println("Object created");
			data.set(primArray, array);
			for (int j =0; j < 5; j++){
				System.out.println("Array at [" + j + "] =" + Array.getInt(array, j));
			}
		}
		return primArray;
	}

	private static Object createObjRef() throws Exception{
		Scanner keyboard = new Scanner(System.in);

		Class classObject = Class.forName("objRef");
		Class sp1ClassObject = Class.forName("simplePrimitive");
		Class sp2ClassObject = Class.forName("simplePrimitive");
		//simplePrimitive sp1 = new simplePrimitive(0,"");
		Constructor c = sp1ClassObject.getConstructor();
		//Object sp1 = c.newInstance(0, "");
		Object sp1 = c.newInstance();
		Constructor c2 = sp2ClassObject.getConstructor();
		Object sp2 = c.newInstance();
		//simplePrimitive sp2 = new simplePrimitive(0,"");
		//objRef objref = new objRef(sp1, sp2);
		Constructor objConstructor = classObject.getConstructor(new Class[] {});
		Object objref = objConstructor.newInstance();
		System.out.println("Would you like to set the value of the fields in the object?\n\nPress 1 to change values\nPress 0 to keep initial values");
		int answer = keyboard.nextInt();
		if (answer == 1){
			System.out.println("Object created");
			Field obj1 = classObject.getField("obj1");
			Field obj2 = classObject.getField("obj2");
			
			obj1.setAccessible(true);
			obj1.set(objref, sp1);
			obj2.setAccessible(true);
			obj2.set(objref, sp2);
			
			
			Class objectType = obj1.getType();
			
			System.out.println("Enter integer value for field intVar in 1st object:");
			int intvalue = keyboard.nextInt();
			System.out.println("Enter double value for field doubleVar in 1st object");
			double doubleVar = keyboard.nextDouble();
			
			Field obj1ival =  objectType.getDeclaredField("intVar");
			Field obj1sval = objectType.getDeclaredField("doubleVar");
			obj1ival.setAccessible(true);
			obj1ival.setInt(sp1, intvalue);
			obj1sval.setAccessible(true);
			obj1sval.setDouble(sp1, doubleVar);
			
			System.out.println("Enter integer value for field intVar in 2nd object:");
			int intvalue2 = keyboard.nextInt();
			System.out.println("Enter double value for field doubleVar in 2nd object");
			double doubleVar2 = keyboard.nextDouble();
			Field obj2ival =  objectType.getDeclaredField("intVar");
			Field obj2sval = objectType.getDeclaredField("doubleVar");
			obj2ival.setAccessible(true);
			obj2ival.setInt(sp2, intvalue2);
			obj2sval.setAccessible(true);
			obj2sval.set(sp2, doubleVar2);
			
		
			
			
			
			
			System.out.println("Updated values for this object:");
			System.out.println("values for field 1");
			System.out.print("intVar = ");
			System.out.println(sp1.getClass().getDeclaredField("intVar").get(sp1));
			System.out.print("doubleVar = ");
			System.out.println(sp1.getClass().getDeclaredField("doubleVar").get(sp1));
			System.out.println("values for field 2");
			System.out.print("intVar = ");
			System.out.println(sp2.getClass().getDeclaredField("intVar").get(sp2));
			System.out.print("doubleVar = ");
			System.out.println(sp2.getClass().getDeclaredField("doubleVar").get(sp2));
		}
		else{
			System.out.println("Object created");
			System.out.println("values for variable 1");
			System.out.print("intVar = ");
			System.out.println(sp1.getClass().getDeclaredField("intVar").get(sp1));
			System.out.print("doubleVar = ");
			System.out.println(sp1.getClass().getDeclaredField("doubleVar").get(sp1));
			System.out.println("values for variable 2");
			System.out.print("intVar = ");
			System.out.println(sp2.getClass().getDeclaredField("intVar").get(sp2));
			System.out.print("doubleVar = ");
			System.out.println(sp2.getClass().getDeclaredField("doubleVar").get(sp2));
		}
		keyboard.close();
		return objref;

	}

	private static Object createSimple() throws Exception {
		//simplePrimitive object1 = new simplePrimitive(0,"");
		
		Scanner keyboard = new Scanner(System.in);
		Class classObject = Class.forName("simplePrimitive");
		Constructor c = classObject.getConstructor();
		Object object1 = c.newInstance();
		
		System.out.println("Initial values for this object:");
		System.out.print("intVar = ");
		System.out.println(object1.getClass().getDeclaredField("intVar").get(object1));
		System.out.print("doubleVar = ");
		System.out.println(object1.getClass().getDeclaredField("doubleVar").get(object1));
		System.out.println();
		System.out.println("Would you like to set the value of the fields in the object?\n\nPress 1 to change values\nPress 0 to keep initial values");
		int answer = keyboard.nextInt();
		if (answer == 1){
			System.out.println("Object created");
			System.out.println("Enter integer value for field intVar:");
			int intvalue = keyboard.nextInt();
			System.out.println("Enter double value for field doubleVar");
			double doubleValue = keyboard.nextDouble();
			Field intVar = classObject.getField("intVar");
			Field doubleVar = classObject.getField("doubleVar");
			intVar.setAccessible(true);
			intVar.setInt(object1, intvalue);
			doubleVar.setAccessible(true);
			doubleVar.set(object1, doubleValue);
			System.out.println("Updated values for this object:");
			System.out.print("intVar = ");
			System.out.println(object1.getClass().getDeclaredField("intVar").get(object1));
			System.out.print("doubleVar = ");
			System.out.println(object1.getClass().getDeclaredField("doubleVar").get(object1));
			
		}
		else{
			System.out.println("Object created");
			System.out.print("intVar = ");
			System.out.println(object1.getClass().getDeclaredField("intVar").get(object1));
			System.out.print("doubleVar = ");
			System.out.println(object1.getClass().getDeclaredField("doubleVar").get(object1));
		}
		keyboard.close();
		return object1;
	}
	}

