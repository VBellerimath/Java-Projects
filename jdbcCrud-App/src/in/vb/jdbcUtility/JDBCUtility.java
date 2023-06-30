package in.vb.jdbcUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtility {
	public static Connection getConnection() throws IOException, SQLException {
		FileInputStream fis = new FileInputStream(
				"E:\\Computer-Science\\Java Projects\\jdbcCrud-App\\src\\in\\vb\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));
		return connection;
	}

	public static void closeResources(Connection con, Statement st, ResultSet rs) throws SQLException {
		if (con != null)
			con.close();
		if (st != null)
			st.close();
		if (rs != null)
			rs.close();
	}
}
