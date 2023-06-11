package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setStatus(200);
		res.setContentType("application/json");
		
		//json 으로 file list 저장
		File directory = new File("./INPUT2/INPUT");
		File[] fList = directory.listFiles();
		
		JsonObject folder = new JsonObject();
		JsonArray jsonlist = new JsonArray();
		folder.addProperty("Folder", directory.getName());
		
		for (File file : fList) {
			jsonlist.add(file.getName());
		}
		folder.add("file", jsonlist);
		
		String filename = LocalDateTime.now().getHour() + ".json";
		
		try (Writer writer = new FileWriter(filename)) {
		    Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		    gson.toJson(folder, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//res.getWriter().write(new Date().toString());
		res.getWriter().write(folder.toString());
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Request : "+ req.getRequestURL());
		File destFolder = new File("./OUTPUT");
		if(!destFolder.exists()) {
		    destFolder.mkdirs(); 
		}
		
		LocalTime currentTime = LocalTime.now();
		String fname = String.format("./OUTPUT/%02d%02d%02d.json", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());
	    PrintWriter printWriter = new PrintWriter(new FileWriter(new File(fname)));
	    
        BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String buffer;
        while ((buffer = input.readLine()) != null) {
        	printWriter.print(buffer);
        }        
		input.close();		
		printWriter.close();
		/////////////////////////////////////////////////
		
		res.setStatus(200);
		res.getWriter().write(fname + " saved!");
		
	}
}
