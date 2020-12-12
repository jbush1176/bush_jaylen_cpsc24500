import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// reads your file. figure out how to scan the file
public class questionReader {
	public ArrayList<Question> readFromJSON1(String fname) {
		ArrayList<Question> questions = new ArrayList<Question>();
		try {
			FileReader reader = new FileReader(new File(fname));
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)parser.parse(reader);
			JSONArray arr = (JSONArray)all.get("questions");
			Iterator itr = arr.iterator();
			//HOW CAN I GET THE CONDITIONAL?
			JSONObject questionObject;
			String trivia, answer, a, b, c, d;//replace for a,b,c,and d
			while (itr.hasNext()) {
				questionObject = (JSONObject)itr.next();
				trivia = questionObject.get("question").toString();
				answer = questionObject.get("answer").toString();
				a = questionObject.get("a").toString();
				b = questionObject.get("b").toString();
				c = questionObject.get("c").toString();
				d = questionObject.get("d").toString();// repeat for, b,c, and d (change choice for a in this example here)
				questions.add(new Question(trivia, answer, a, b, c, d));// replace a,b,c, and d
		}
			
			reader.close();
			return questions;
		} catch (Exception ex) {
			return null;
		}
	}
	

}
