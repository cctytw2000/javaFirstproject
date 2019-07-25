package tw.projectnumber35.firstproject;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonReadForFile {
	public List<Libero> getJsonFile(String JsonPath) {
		Gson gson = new Gson();
		List<Libero> Libero = null;

		try (FileReader fr1 = new FileReader(JsonPath)) {
			Type type = TypeToken.getParameterized(ArrayList.class, Libero.class).getType();
			Libero = gson.fromJson(fr1, type);
		} catch (IOException e) {
			System.out.println("並無此檔案路徑, 請重新輸入");
			Libero = new ArrayList<Libero>();
		}
		return Libero;

	}
}
