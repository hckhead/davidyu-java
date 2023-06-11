package test;

import java.io.File;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MyClient {

	public static void main(String[] args) throws Exception {
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		String strFileList = getFile();
		
		Request	request = httpClient.newRequest("http://127.0.0.1:8088/fileList").method(HttpMethod.POST);
		request.header(HttpHeader.CONTENT_TYPE, "application/json");
		request.content(new StringContentProvider(strFileList,"utf-8"));
		
		ContentResponse contentRes = request.send();
		System.out.println(contentRes.getContentAsString());
		
		
		httpClient.stop();
	}
	
	public static String getFile() {
		File directory = new File("./INPUT2/INPUT");
		File[] fList = directory.listFiles();
		
		JsonObject folder = new JsonObject();
		JsonArray jsonlist = new JsonArray();
		folder.addProperty("Folder", directory.getName());
		
		for (File file : fList) {
			jsonlist.add(file.getName());
		}
		folder.add("file", jsonlist);
		
		return folder.toString();
	}
}
