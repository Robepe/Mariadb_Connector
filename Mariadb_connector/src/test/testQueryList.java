package test;

import main.App;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.sql.*;
//import org.junit.Test;                    IMPORT JUNIT 4
import org.junit.jupiter.api.Test; 		//  IMPORT JUNIT 5
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class testQueryList {

	private static App app = new App();

	@BeforeAll
	public static void backup_DB() {
		try {
			Connection conn = app.connectDB();
			app.createDB(conn, "MariaDB_Ejer1_test");
			cloneDB(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @AfterAll
	 * public static void drop_DB() {
	 * try {
	 * Connection conn = app.connectDB(); // redundante posiblemente
	 * Statement cursor = conn.createStatement();
	 * cursor.execute("DROP DATABASE IF EXISTS MariaDB_Ejer1_test");
	 * 
	 * }catch (SQLException e) {
	 * e.printStackTrace();
	 * }
	 * }
	 */

	/**
	 * Method dedicated to clone the main database in order to execute the test on a
	 * safer enviroment
	 * 
	 * @param conn: Connection object
	 */
	private static void cloneDB(Connection conn) {
		try {
			Path jsonPath = Paths.get("src/resources/config.json");
			Path sqlPath = Paths.get("src/test/tmp_db/backup.sql");

			Object obj = new JSONParser().parse(new FileReader(jsonPath.toFile()));
			JSONObject data = (JSONObject) obj;
			String socket = (String) data.get("socket");
			String user = (String) data.get("user");

			// mysqldump command
			ProcessBuilder pb = new ProcessBuilder("mysqldump", "--socket=" + socket, "--skip-column-statistics",
					"-u" + user, "MariaDB_Ejer1", "--result-file=src/test/tmp_db/backup.sql");
			Process p = pb.start();

			int exitCode = p.waitFor();
			System.out.println("Process finished with Exit Code: " + exitCode);

			Statement cursor = conn.createStatement();
			cursor.execute("USE MariaDB_Ejer1_test");

			String sqlCommands = new String(Files.readAllBytes(sqlPath));
			String[] commands = sqlCommands.split(";");

			for (String command : commands) {
				cursor.execute(command);
			}

			cursor.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQuery1() {

	}

	@Test
	public void testQuery2() {

	}

	@Test
	public void testQuery3() {

	}

	@Test
	public void testQuery4() {

	}

	@Test
	public void testQuery5() {

	}

	@Test
	public void testQuery6() {

	}

	@Test
	public void testQuery7() {

	}

	@Test
	public void testQuery8() {

	}

	@Test
	public void testQuery9() {

	}

	@Test
	public void testQuery10() {

	}

	@Test
	public void testQuery11() {

	}

	@Test
	public void testQuery12() {

	}

	@Test
	public void testQuery13() {

	}

	@Test
	public void testQuery14() {

	}

	@Test
	public void testQuery15() {

	}

	@Test
	public void testQuery16() {

	}

	@Test
	public void testQuery17() {

	}

	@Test
	public void testQuery18() {

	}

	@Test
	public void testQuery19() {

	}

	@Test
	public void testQuery20() {

	}

	@Test
	public void testQuery21() {

	}

	@Test
	public void testQuery22() {

	}

	@Test
	public void testQuery23() {

	}

	@Test
	public void testQuery24() {

	}

	@Test
	public void testQuery25() {

	}

	@Test
	public void testQuery26() {

	}

	@Test
	public void testQuery27() {

	}

	@Test
	public void testQuery28() {

	}
}
