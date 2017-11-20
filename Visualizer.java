import java.lang.reflect.Array;
import java.lang.reflect.Field;


public class Visualizer {

	public Visualizer(){
		//this.obj = obj;
	}
	public void visualize(Object finalObject) throws Exception{
		Field[] fields = finalObject.getClass().getDeclaredFields();
		System.out.println("Object class name: " + finalObject.getClass().getName());
		System.out.println("Object fields:" );
		for (int i =0; i < fields.length; i++){
			System.out.println(fields[i].getName() + " = " + fields[i].get(finalObject));
			if (finalObject.getClass().getName() == "arrayPrimitives"){
				Array a = (Array) Array.newInstance(fields[i].get(finalObject).getClass().getComponentType(), 5);
				System.out.println(a);
				for(int j = 0; j< Array.getLength(fields[i].get(finalObject).getClass().getComponentType()); j++){
					//boolean a = fields[i].get(finalObject).getClass().isArray();
					System.out.println(a);
					System.out.println(Array.get(fields[i].get(finalObject).getClass().getComponentType(), j));
				
				}
			}
	}
}
}
