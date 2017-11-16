import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Object.*;
import java.util.List;
import java.beans.*;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.lang.reflect.*;
public class Deserializer{
	Document readDoc;
	public Deserializer(Document doc){
		this.readDoc = doc;
	}

	public Object deserializer (Document document){
		SAXBuilder builder = new SAXBuilder();
		Object object = null;
		try{
			
		
		//Document readDoc = document;
		List<Element> objects = readDoc.getRootElement().getChildren();
		List<Element> fields = objects.get(0).getChildren();
		String className = objects.get(0).getAttributeValue("class");
		String fieldName = fields.get(0).getAttributeValue("name");
		String fieldName2 = "";
		if ( fields.size() > 1){
			 fieldName2 = fields.get(1).getAttributeValue("name");
		}
		System.out.println("Object class name" + className);
		Class classObject = Class.forName(className);
		Constructor c = classObject.getConstructor();
		object = c.newInstance();
		
		if (className == "simplePrimitive"){
			Field field1 = object.getClass().getField(fieldName);
			field1.set(object, Integer.parseInt(fields.get(0).getValue()));
			Field field2 = object.getClass().getField(fieldName2);
			field2.set(object, Double.parseDouble(fields.get(1).getValue()));
		}
		
		if (className == "arrayPrimitives"){
			System.out.print("SIMPLE ARRAY");
			Object array = Array.newInstance(int.class, 5);
			Element arrayObject = fields.get(0).getChild("object");
			List<Element> values = arrayObject.getChildren();
			Field data = object.getClass().getField("data");
			int i = 0;
			while (  i < values.size()){
				Array.set(array, i, Integer.parseInt(values.get(i).getValue()));
				System.out.println("Value set " + values.get(i).getValue());
				i++;
			}
			data.set(object, array);
		}
		
		if (className == "objRef"){
			List<Element> FieldObj1 = fields.get(0).getChildren();
			List<Element> iFieldObj1 = FieldObj1.get(0).getChildren();
			List<Element> FieldObj2 = fields.get(1).getChildren();
			List<Element> iFieldObj2 = FieldObj2.get(0).getChildren();
			List<Element> innerFieldObj1 = iFieldObj1.get(0).getChildren();
			List<Element> innerFieldObj2 = iFieldObj2.get(0).getChildren();

			System.out.println("Field 1 size" + FieldObj1.size());
			System.out.println("Field 2 size" + FieldObj2.size());
			System.out.println("Field 1 " + FieldObj1.get(0).getName());

			System.out.println("iField 1 " + innerFieldObj1.get(0).getName());

			
			Field obj1 = object.getClass().getDeclaredField("obj1");
			Field obj2 = object.getClass().getDeclaredField("obj2");

			Class classObject1 = Class.forName("simplePrimitive");
			Constructor c1 = classObject1.getConstructor();
			Object sp1 = c1.newInstance();
			Class classObject2 = Class.forName("simplePrimitive");
			Constructor c2 = classObject2.getConstructor();
			Object sp2 = c2.newInstance();
			Field sp1IntVar = sp1.getClass().getField("intVar");
			Field sp1DoubleVar = sp1.getClass().getField("doubleVar");
			System.out.println("innerField 1 size" + innerFieldObj1.size());
			System.out.println("innerField 2 size" + innerFieldObj2.size());

			System.out.println(innerFieldObj1.get(0).getName());
			sp1IntVar.set(sp1, Integer.parseInt(innerFieldObj1.get(0).getValue()));
			sp1DoubleVar.set(sp1, Double.parseDouble(innerFieldObj2.get(1).getValue()));

			Field sp2IntVar = sp2.getClass().getField("intVar");
			Field sp2DoubleVar = sp2.getClass().getField("doubleVar");
			sp2IntVar.set(sp2, Integer.parseInt(innerFieldObj1.get(0).getValue()));
			sp2DoubleVar.set(sp2, Double.parseDouble(innerFieldObj2.get(1).getValue()));
			obj1.set(object, sp1);
			obj2.set(object, sp2);
			
		}
		
		

		
		
		
		
		int numberOfObjects = objects.size();
		int numOfFields = fields.size();
		System.out.println("number of objects " + numberOfObjects + " number of fields " + numOfFields);
		//String intVar = fields.get(0).getValue();
	
		//System.out.print("intVar = " + intVar);
		//String doubleVar = fields.get(1).getValue();
		//System.out.print("doubleVar = " + doubleVar);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return object;
	


	}

	private void handleSimpleArray(Object object) {
		// TODO Auto-generated method stub
		
	}
}
