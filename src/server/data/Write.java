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
			JSONArray names = new JSONArray();

			if (json.containsKey(name)) {
				videos = (JSONArray) json.get(name);
				if (!videos.contains(video))
					videos.add(video);
			}
			
			if (!json.containsKey(name)) {
				names.add(name);
				videos.add(video);
			}
			
			//WRITE
			FileWriter file = new FileWriter("src/server/data/data.json");
			
			JSONArray[] arrays = new JSONArray[1000];
			
			for(int i = 0 ; i < names.size() ; i++) {
				
				arrays[i] = (JSONArray) json.get(names.get(i));
				
			}
			

			
			json.clear();
			
			for(int i = 0 ; i < names.size() ; i++) {
				
				json.put(name, videos);
				json.put(names.get(i).toString(), arrays[i]);
				file.write(json.toString());


			}
			
			file.flush();
			json.put(name, videos);
			//file.write(json.toString());

			//file.flush();

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} 

	}
}
