package tw.projectnumber35.firstproject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.simple.JSONArray;

public interface ILiberoDio {
	public void addArrayList(List<Libero> l, int member_id) throws SQLException;

	public void add(int member_id) throws SQLException;

	public void update() throws SQLException;

	public void FindById(int member_id) throws SQLException, JSONException, IOException;

	public void createConn() throws SQLException;

	public void closeConn() throws SQLException;
}
