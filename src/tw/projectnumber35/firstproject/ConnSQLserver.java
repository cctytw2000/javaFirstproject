package tw.projectnumber35.firstproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class ConnSQLserver implements DataSource {
	private Properties props;
	private List<Connection> connpools;
	private String mySQLUrl, myUser, myPassword;
	private int maxConn;
	private Connection conn;

	public ConnSQLserver() throws IOException, SQLException {
		this("mysqlserverjdbc.properties");
	}

	public ConnSQLserver(String config) throws IOException {
		props = new Properties();
		props.load(new FileInputStream(config));
		mySQLUrl = props.getProperty("mySQLUrl");
		myUser = props.getProperty("DBUser");
		myPassword = props.getProperty("DBPassword");
		maxConn = Integer.parseInt(props.getProperty("maxConn"));

//		System.out.println("mySQLUrl = " + mySQLUrl);
//		System.out.println("myUser = " + myUser);
//		System.out.println("myPassword = " + myPassword);
//		System.out.println("maxConn = " + maxConn);

		connpools = Collections.synchronizedList(new ArrayList<Connection>());

	}

	@Override
	public synchronized Connection getConnection() throws SQLException {
		if (connpools.isEmpty()) {
			conn = DriverManager.getConnection(mySQLUrl, myUser, myPassword);
			return conn;
		} else {
			return connpools.remove(connpools.size() - 1);
		}

	}

	@Override
	public synchronized Connection getConnection(String myUser, String myPassword) throws SQLException {
		if (connpools.isEmpty()) {
			conn = DriverManager.getConnection(mySQLUrl, myUser, myPassword);
			return conn;
		} else {
			return connpools.remove(connpools.size() - 1);
		}
	}

	public void closeConn() throws SQLException {
		if (connpools.size() == maxConn) {
			conn.close();
		} else {
			connpools.add(conn);
		}
	}

	public void SQLInsertQuery(String data, int members_id) throws SQLException {

	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
