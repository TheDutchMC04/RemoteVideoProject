package server.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Write {

	public static JSONParser parser;
	
	public static void AddData(String name, String video) {
	
		try {
			
			//READ
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader("src/server/data/data.json"));
			JSONObject json = (JSONObject) object;
			JSONArray videos = new JSONArray();

			if (json.containsKey(name)) {
				videos = (JSONArray) json.get(name);
			}
			
			//WRITE
			FileWriter file = new FileWriter("src/server/data/data.json");
			
			if (!videos.contains(video))
				videos.add(video);
			
			json.clear();
			json.put(name, videos);
			file.write(json.toString());

			file.flush();

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} 

	}
}
