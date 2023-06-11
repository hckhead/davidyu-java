package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Sameple2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Reader reader = new FileReader("sample.json");
		
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		
		String name = obj.get("name").getAsString();
		int age = obj.get("age").getAsInt();
		System.out.println("name:"+ name + "("+ age+")");
		
		JsonArray jsonArr = obj.get("children").getAsJsonArray();
		JsonObject jsonObj = jsonArr.get(1).getAsJsonObject();
		
		name = jsonObj.get("name").getAsString();
		age = jsonObj.get("age").getAsInt();
		System.out.println("name:" + name + "("+age+")");
		
		
		for(String key : obj.keySet()) {
			JsonElement je = obj.get(key);
			System.out.print("Key :" + key + " / Value Type : ");
			if(je.isJsonArray())
				System.out.println("Array");
			if(je.isJsonNull())
				System.out.println("null");
			if(je.isJsonObject())
				System.out.println("Object");
			if(je.isJsonPrimitive()) {
				if(je.getAsJsonPrimitive().isBoolean())
					System.out.println("Boolean");
				if(je.getAsJsonPrimitive().isNumber())
					System.out.println("Number");
				if(je.getAsJsonPrimitive().isJsonNull())
					System.out.println("null");
				if(je.getAsJsonPrimitive().isString())
					System.out.println("String");
			}
		}
	}
	
}
