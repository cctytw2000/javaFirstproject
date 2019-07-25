package tw.projectnumber35.firstproject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LiberoDaoJdbcImpl implements ILiberoDio {
	private ConnSQLserver jdbc;
	private Connection conn;

	public LiberoDaoJdbcImpl() throws IOException, SQLException {
		jdbc = new ConnSQLserver();
	}

	@Override
	public void addArrayList(List<Libero> l, int member_id) throws SQLException {
		String sqlcode = "insert into Libero(Position,FirstName,LastName,BatHand,ThrowHand,Height,Weight,BirthDate,member_id) values(?,?,?,?,?,?,?,?,?)";
		int count = 0;
		PreparedStatement state = conn.prepareStatement(sqlcode);

		for (int i = 0; i < l.size(); i++) {
//			System.out.println(l.get(i).getPosition() + "\t" + l.get(i).getFirstName() + "\t" + l.get(i).getLastName()
//					+ "\t" + l.get(i).getBatHand() + "\t" + l.get(i).getThrowHand() + "\t" + l.get(i).getHeight() + "\t"
//					+ l.get(i).getWeight() + "\t" + l.get(i).getBirthDate());
			System.out.println(l.get(i));
			state.setString(1, l.get(i).getPosition());
			state.setString(2, l.get(i).getFirstName());
			state.setString(3, l.get(i).getLastName());
			state.setString(4, l.get(i).getBatHand());
			state.setString(5, l.get(i).getThrowHand());
			state.setInt(6, l.get(i).getHeight());
			state.setInt(7, l.get(i).getWeight());
			state.setString(8, l.get(i).getBirthDate());
			state.setInt(9, member_id);
			count = count + state.executeUpdate();

		}
		state.close();
		System.out.println("您新增了" + count + "筆資料");

	}

	@Override
	public void createConn() throws SQLException {
		conn = jdbc.getConnection();

	}

	@Override
	public void closeConn() throws SQLException {
		jdbc.closeConn();

	}

	@Override
	public void FindById(int member_id) throws SQLException, JSONException, IOException {
		String sqlcode = "select * from Libero where member_id = ?";
		PreparedStatement state = conn.prepareStatement(sqlcode);
		state.setInt(1, member_id);
		ResultSet rs = state.executeQuery();
		JSONArray jArray = new JSONArray();

		while (rs.next()) {
			JSONObject jObject = new JSONObject();
			jObject.put("Position", rs.getString(2));
			jObject.put("FirstName", rs.getString(3));
			jObject.put("LastName", rs.getString(4));
			jObject.put("ThrowHand", rs.getString(6));
			jObject.put("Height", rs.getString(7));
			jObject.put("Weight", rs.getString(8));
			jObject.put("BirthDate", rs.getString(9));

			jArray.put(jObject);
		}
		String jsonString = jArray.toString();
//		System.out.println("jsonString:" + jsonString);
		for (int i = 0; i < jArray.length(); i++) {
			JSONObject obj = (JSONObject) jArray.get(i);
			System.out.println(obj);

		}
		String json_Str = jArray.toString();
//		System.out.println(json_Str);
		System.out.println("請輸入輸出的檔案名稱");
		Scanner data_name_sca = new Scanner(System.in);

		String data_name = data_name_sca.next();
		String dataOutputName = "c:/temp/" + data_name + ".json";
		FileWriter file = new FileWriter(dataOutputName);
		file.write(json_Str);
		file.close();
		rs.close();
		state.close();
		System.out.println("匯出成功");

	}

	@Override
	public void add(int member_id) throws SQLException {
		String sqlcode = "insert into Libero(Position,FirstName,LastName,BatHand,ThrowHand,Height,Weight,BirthDate,member_id) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sqlcode);
		System.out.println("please insert your Position");
		Scanner Position_sca = new Scanner(System.in);
		String Position = Position_sca.next();

		System.out.println("please insert your FirstName");
		Scanner FirstName_sca = new Scanner(System.in);
		String FirstName = FirstName_sca.next();

		System.out.println("please insert your LastName");
		Scanner LastName_sca = new Scanner(System.in);
		String LastName = LastName_sca.next();

		System.out.println("please insert your BatHand");
		Scanner BatHand_sca = new Scanner(System.in);
		String BatHand = BatHand_sca.next();

		System.out.println("please insert your ThrowHand");
		Scanner ThrowHand_sca = new Scanner(System.in);
		String ThrowHand = ThrowHand_sca.next();

		System.out.println("please insert your Height");
		Scanner Height_sca = new Scanner(System.in);
		int Height = Height_sca.nextInt();

		System.out.println("please insert your Weight");
		Scanner Weight_sca = new Scanner(System.in);
		int Weight = Weight_sca.nextInt();

		System.out.println("please insert your BirthDate");
		Scanner BirthDate_sca = new Scanner(System.in);
		String BirthDate = BirthDate_sca.next();

//		Position,FirstName,LastName,BatHand,ThrowHand,Height,Weight,BirthDate
		state.setString(1, Position);
		state.setString(2, FirstName);
		state.setString(3, LastName);
		state.setString(4, BatHand);
		state.setString(5, ThrowHand);
		state.setInt(6, Height);
		state.setInt(7, Weight);
		state.setString(8, BirthDate);
		state.setInt(9, member_id);
		int count = state.executeUpdate();
		System.out.println("您新增了" + count + "筆資料");

		state.close();

	}

	@Override
	public void update() throws SQLException {
		System.out.println("請輸入選手姓氏");
		Scanner FirstName_sca = new Scanner(System.in);
		String FirstName = FirstName_sca.next();
		while (true) {
			String sqlcode = "select * from Libero where FirstName = ?";
			PreparedStatement state = conn.prepareStatement(sqlcode);
			state.setString(1, FirstName);
			ResultSet rs = state.executeQuery();
			if (rs.next()) {
				System.out.println("請輸入您要修改的資料");
				System.out.println("1." + "Position:" + rs.getString(2));
				System.out.println("2." + "FirstName:" + rs.getString(3));
				System.out.println("3." + "LastName:" + rs.getString(4));
				System.out.println("4." + "BatHand:" + rs.getString(5));
				System.out.println("5." + "ThrowHand:" + rs.getString(6));
				System.out.println("6." + "Height:" + rs.getString(7));
				System.out.println("7." + "Weight:" + rs.getString(8));
				System.out.println("8." + "BirthDate:" + rs.getString(9));
				System.out.println("9." + "離開");
				ResultSetMetaData metadata = rs.getMetaData();
//			int columnCount = metadata.getColumnCount();

				Scanner choose_sca = new Scanner(System.in);
				int choose = choose_sca.nextInt();

				if (choose == 9) {

					rs.close();
					state.close();
					break;
				} else {
					System.out.println("請輸入新的資料");
					Scanner newdata_sca = new Scanner(System.in);
					String newdata = newdata_sca.next();
					String sqlcode1 = "update Libero set " + metadata.getColumnName(choose + 1)
							+ " = ? where FirstName = ?";
					PreparedStatement state1 = conn.prepareStatement(sqlcode1);
					System.out.println(metadata.getColumnName(choose + 1));
//			state1.setString(1, metadata.getColumnName(choose + 1));
//			state1.setString(2, newdata);
//			state1.setString(3, FirstName);
//
					state1.setString(1, newdata);
					state1.setString(2, FirstName);
					int count = state1.executeUpdate();
					System.out.println("修改完成");
					state1.close();
					rs.close();
					state.close();
				}
			} else {
				System.out.println("查不到資料");
			}
		}

	}
}
