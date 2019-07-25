package tw.projectnumber35.firstproject;

import java.sql.SQLException;

public interface IMemberDao {

	public void add(Member mb) throws SQLException;

	public int checkAccount(Member mb) throws SQLException;

	public void update(Member mb) throws SQLException;

	public void delete(int member_id, int ln_id) throws SQLException;

	public int fintById(Member mb) throws SQLException;

	public void createConn() throws SQLException;

	public void closeConn() throws SQLException;

}
