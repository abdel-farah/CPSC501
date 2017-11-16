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

//import org.jdom2.*;
public class Serializer {
	Object obj;
	public Serializer(Object obj){
		this.obj = obj;
	}
	public Document  serialize (Object obj) {
		Document document = new Document();

		try{
			
		
		//FileOutputStream f = new FileOutputStream("result.xml");
		SAXBuilder saxBuilder  = new SAXBuilder();
		//XMLEncoder x = new XMLEncoder( new BufferedOutputStream(f));
		//x.writeObject(obj);
		//x.close(); 
		//Element serial = new Element("serializable");
		File input = new File("result3.xml");
		document = saxBuilder.build(input);
		System.out.println("Root element ;" + document.getRootElement().getName());
		
		Element Root = new Element("serializable");
		Element object = new Element("object");
		//Element field = new Element("field");
		
		document.setRootElement(Root);
		object.setAttribute("class", obj.getClass().getName());
		object.setAttribute("id", Integer.toString(java.lang.System.identityHashCode(obj)));
		Field[] fArray = obj.getClass().getDeclaredFields();
		System.out.println("number of fields in the object: " + fArray.length);
		for ( int i = 0; i < fArray.length; i++){
			Element field = new Element("field");
			field.setAttribute("name", fArray[i].getName());
			field.setAttribute("declaringclass", fArray[i].getDeclaringClass().getName());
			
			if(fArray[i].getType().isArray()){
				System.out.println("FOUND ARRAY");
				Object o = fArray[i].get(obj);
				Element arrayObject = new Element("object");
				arrayObject.setAttribute("class", o.getClass().getName());
				arrayObject.setAttribute("length", Integer.toString(Array.getLength(o)));
				field.addContent(arrayObject);
				
				//For primitive array 
				if (fArray[i].getType().getName() == "[I"){
					System.out.println("FOUND PRIM ARRAY");

					for ( int j = 0; j < Array.getLength(o); j++){
						Element value = new Element("value");
						value.addContent(Integer.toString(Array.getInt(o, j)));
						value.detach();
						arrayObject.addContent(value);
					}	
				}
				//For object array
				else {	
				}	
			}
			 if (fArray[i].getType().isPrimitive()){
				Element value = new Element("value");
				System.out.println("VALUE: " + fArray[i].get(obj).toString());
				value.addContent((fArray[i].get(obj).toString()));
				value.detach();
				field.addContent(value);
				object.addContent(field);
			}
			
			 else {
				System.out.println("GOT HERE");
				Element reference = new Element("reference");
				reference.addContent(Integer.toString(java.lang.System.identityHashCode(obj)));
				reference.detach();
				field.addContent(reference);
				object.addContent(field);
				
				Element objectRef = new Element("object");
				System.out.println("FARRAY[ " + i +  " ] = " + fArray[i].getType().getName());
				
				objectRef.setAttribute("class", fArray[i].getType().getName());
				objectRef.setAttribute("id", Integer.toString(java.lang.System.identityHashCode(obj)));			
				objectRef.detach();
				reference.addContent(objectRef);
				
				Element objField = new Element("fieldObj1");
				Element objField2 = new Element("fieldObj2");
				//Object subObject = fArray[0].get(obj);
				//Object subObject2 = fArray[1];
				Field[] innerfArray = fArray[i].getType().getFields();
				//System.out.println("field")
				objField.setAttribute("name", innerfArray[0].getName());

				
				Element value1 = new Element("value");
				System.out.println("FARRAY[ " + i +  " ] = " + fArray[i].getName());
				//System.out.println("Class type " + innerfArray[i].get(fArray[i].get(obj)));
				System.out.println("innerfArray at [ " + i + "  ] = " + innerfArray[i].get(fArray[i].get(obj)));
				value1.addContent( innerfArray[0].get(fArray[i].get(obj)).toString());
				value1.detach();
				objField.addContent(value1);
				
				
				objField2.setAttribute("name", innerfArray[1].getName());
				objField2.setAttribute("declaringclass", fArray[i].getType().getName());
				
				Element value2 = new Element("value");
				value2.addContent(innerfArray[1].get(fArray[i].get(obj)).toString());
				value2.detach();
				objField2.addContent(value2);
			
				objectRef.addContent(objField);
				objectRef.addContent(objField2);

			}
		
			//System.out.println(object.getParent().toString());
			object.detach();
			Root.addContent(object);
		field.detach();
	   object.addContent(field);
		
		}
		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
		xmlOutput.output(document, new FileOutputStream("result3.xml"));
		/*
		for (int i = 0; i < e.size(); i++ ){
			System.out.println("Child at" + e.get(i));
			System.out.println("Child's child" + e.get(i).getChildren());
			System.out.println("Root element" + document.getRootElement());
			System.out.println("Root attributes" + Root.getAttributes());
		
		}
		*/
		}
		catch(JDOMException e){
			e.printStackTrace();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}
		
}
