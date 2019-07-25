package tw.projectnumber35.firstproject;

import java.io.IOException;
import java.sql.SQLException;

public class LiberoDaoFactory {

	public static ILiberoDio createLibero() throws IOException, SQLException {
		ILiberoDio LBDao = new LiberoDaoJdbcImpl();
		return LBDao;

	}

}
