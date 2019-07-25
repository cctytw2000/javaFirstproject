package tw.projectnumber35.firstproject;

import java.io.IOException;
import java.sql.SQLException;

public class MemberDaoFactory {
	public static IMemberDao createMember() throws IOException, SQLException {
		IMemberDao MBDao = new MemberDaoJdbcImpl();
		return MBDao;

	}
}
