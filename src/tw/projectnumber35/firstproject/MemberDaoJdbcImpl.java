package tw.projectnumber35.firstproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.projectnumber35.firstproject.ConnSQLserver;

public class MemberDaoJdbcImpl implements IMemberDao {
	private ConnSQLserver jdbc;
	private Connection conn;

	public MemberDaoJdbcImpl() throws IOException, SQLException {
		jdbc = new ConnSQLserver();
	}

	@Override
	public void add(Member mb) throws SQLException {

		String sqlcode = "insert into Member (account,password,VerificationCode) values(?,?,?)";// and isactive = 1
		PreparedStatement state = conn.prepareStatement(sqlcode);
		state.setString(1, mb.getAccount());
		state.setString(2, mb.getPassword());
		state.setInt(3, mb.getVerificationCode());
		state.executeUpdate();
		System.out.println("Create Done");
		state.close();

	}

	@Override
	public int checkAccount(Member mb) throws SQLException {
		String sqlcode1 = "select * from Member where account=? and VerificationCode=?";
		PreparedStatement state = conn.prepareStatement(sqlcode1);
		state.setString(1, mb.getAccount());
		state.setInt(2, mb.getVerificationCode());
		state.executeQuery();
		ResultSet rs = state.executeQuery();
		boolean checkstatus = rs.next();
		if (checkstatus) {
			System.out.println(checkstatus);
			int memberID = rs.getInt(1);
			rs.close();
			state.close();

			return memberID;

		} else {
			return 0;
		}
	}

	@Override
	public void update(Member mb) throws SQLException {
		String sqlcode1 = "select * from Member where account=? and VerificationCode=?";

		PreparedStatement state = conn.prepareStatement(sqlcode1);
		state.setString(1, mb.getAccount());

		state.setInt(2, mb.getVerificationCode());
		state.executeQuery();
		ResultSet rs = state.executeQuery();
		boolean checkstatus = rs.next();
//		System.out.println(checkstatus);
		rs.close();
		state.close();
		if (checkstatus) {
			String sqlcode = "update Member set password = ? where account=? and VerificationCode=?";
			PreparedStatement state2 = conn.prepareStatement(sqlcode);
			state2.setString(1, mb.getNewpassword());
			state2.setString(2, mb.getAccount());
			state2.setInt(3, mb.getVerificationCode());
			state2.execute();
			System.out.println("修改成功");
			state2.close();
		} else {
			System.out.println("Something error");
		}

	}

	@Override
	public void delete(int member_id, int ln_id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int fintById(Member mb) throws SQLException {
		String sqlcode = "select * from Member where account = ? and password = ?  ";// and isactive = 1
		PreparedStatement state = conn.prepareStatement(sqlcode);
		state.setString(1, mb.getAccount());
		state.setString(2, mb.getPassword());
		ResultSet rs = state.executeQuery();
		boolean checkstatus = rs.next();

		if (checkstatus) {
			int id = rs.getInt(1);

//			System.out.println("id=" + rs.getInt(1));
//			callTestjdbcConnDataSource self_class = new callTestjdbcConnDataSource();
//			self_class.insertMemberLoginTime(rs.getInt(1));
			System.out.println("登入成功");
			rs.close();
			state.close();
			return id;
		} else {
//			System.out.println("username or password Error");
			rs.close();
			state.close();

			System.out.println("登入失敗");
			return 0;
		}

	}

	@Override
	public void createConn() throws SQLException {
		conn = jdbc.getConnection();
//		System.out.println("連線狀態 " + !conn.isClosed());
	}

	@Override
	public void closeConn() throws SQLException {

		jdbc.closeConn();

	}

}
