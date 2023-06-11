package json;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "spiderman");
		jsonObject.addProperty("age", 45);
		jsonObject.addProperty("married", true);
		
		JsonArray jsonArr = new JsonArray();
		jsonArr.add("martial art");
		jsonArr.add("gun");
		jsonObject.add("specialty", jsonArr);
		
		JsonObject vac = new JsonObject();
		vac.addProperty("1st", "done");
		vac.addProperty("2nd", "expected");
		vac.add("3rd", null);
		jsonObject.add("vaccine", vac);
		
		JsonArray jsonArr2 = new JsonArray();
		
		JsonObject child1 = new JsonObject();
		child1.addProperty("name", "spiderboy");
		child1.addProperty("age", 10);
		jsonArr2.add(child1);
		JsonObject child2 = new JsonObject();
		child2.addProperty("name", "spidergirl");
		child2.addProperty("age", 8);
		jsonArr2.add(child2);
		
		jsonObject.add("children", jsonArr2);
		jsonObject.add("address", null);

		System.out.println(jsonObject);
		String filename = LocalDateTime.now().getHour() + ".json";
		System.out.println(filename);
		
		try (Writer writer = new FileWriter("sample.json")) {
		    Gson gson = new GsonBuilder().serializeNulls().create();
		    gson.toJson(jsonObject, writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}