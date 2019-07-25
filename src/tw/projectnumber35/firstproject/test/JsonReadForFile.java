package tw.projectnumber35.firstproject.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonReadForFile {

	public static void main(String[] args) throws IOException {

		Gson gson = new Gson();

		// 序列化
		List<Libero> Libero = null;
		try (FileReader fr1 = new FileReader("C:/temp/test.json")) {
			Type type = TypeToken.getParameterized(ArrayList.class, Libero.class).getType();
			Libero = gson.fromJson(fr1, type);
		} catch (IOException e) {
			System.out.println("並無此檔案路徑, 請重新輸入");
			Libero = new ArrayList<Libero>();
		}

		System.out.println("共有" + Libero.size() + "筆資料");
		System.out.println(Libero.get(0).getFirstName());

		for (Libero libero : Libero) {
			System.out.println(libero.toString());
		}

	}

}
