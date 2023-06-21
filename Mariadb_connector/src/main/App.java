package main;

import java.sql.*;

public class App {

	/**
	 * Method dedicated to create the connection to our Database.
	 * 
	 * @return 'conn': Connection Object
	 * @throws SQLException
	 */
	public Connection connectDB() throws SQLException {
		// Create connection for a server installed in localhost, with a user "root"
		// with no password
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/", "root", null);
		return conn;
	}

	/**
	 * Method dedicated to create the database in case it doesn't exist.
	 * 
	 * @param 'conn': Connection Object Provided by 'connectDB()'
	 * @param db_name: Name of the Database to Create/Use
	 * @throws SQLException
	 */
	public void createDB(Connection conn, String db_name) throws SQLException {
		// Create a Statement (equivalent to python 'Cursor')
		Statement cursor = conn.createStatement();

		// Creates the DB if not exists already, and uses it
		cursor.execute("CREATE DATABASE IF NOT EXISTS " + db_name);
		cursor.execute("USE " + db_name);
		cursor.close();
	}

	/**
	 * Method dedicated to create the tables of the Database
	 * 
	 * @param cursor: Statement Object
	 * @throws SQLException
	 */
	private void createTables(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		cursor.execute(
				"CREATE TABLE IF NOT EXISTS DEPARTAMENTO" + 
				" (depto_no INT PRIMARY KEY NOT NULL," + 
				" nombre_depto VARCHAR(30) NOT NULL," +
				" localizacion VARCHAR(20) NOT NULL)");

		cursor.execute(
				"CREATE TABLE IF NOT EXISTS EMPLEADO" +
				" (codigo_c VARCHAR(16) PRIMARY KEY NOT NULL," + 
				" nombre VARCHAR(30) NOT NULL," +
				" edad TINYINT NOT NULL," + 
				" oficio VARCHAR (20) NOT NULL," + 
				" dir VARCHAR(20) NOT NULL," + 
				" fecha_alt DATE NOT NULL," +
				" salario INT NOT NULL," +
				" comision INT NOT NULL," + 
				" depto_no INT," + 
				" FOREIGN KEY (depto_no) REFERENCES DEPARTAMENTO(depto_no) ON DELETE SET NULL ON UPDATE CASCADE)");

		cursor.execute(
				"CREATE TABLE IF NOT EXISTS HISTORICO" +
				" (codigo INT PRIMARY KEY NOT NULL AUTO_INCREMENT," +
				" codigo_c VARCHAR(16)," +
				" depto_no INT," +
				" oficio VARCHAR (20) NOT NULL," +
				" fecha_alt DATE NOT NULL," +
				" fecha_fin DATE NOT NULL," +
				" FOREIGN KEY (codigo_c) REFERENCES EMPLEADO(codigo_c) ON DELETE SET NULL ON UPDATE CASCADE," +
				" FOREIGN KEY (depto_no) REFERENCES DEPARTAMENTO(depto_no) ON DELETE SET NULL ON UPDATE CASCADE)");

		cursor.close();
	}

	/**
	 * Method dedicated to insert the default data of both tables
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	private void insertData(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		// 'DEPARTAMENTO' Data
		cursor.executeUpdate(
				"INSERT IGNORE INTO DEPARTAMENTO (depto_no, nombre_depto, localizacion) VALUES ('10', 'Desarrollo Software', 'El Coyolar')");
		cursor.executeUpdate(
				"INSERT IGNORE INTO DEPARTAMENTO (depto_no, nombre_depto, localizacion) VALUES ('20', 'Analisis Sistema', 'Guadalupe')");
		cursor.executeUpdate(
				"INSERT IGNORE INTO DEPARTAMENTO (depto_no, nombre_depto, localizacion) VALUES ('30', 'Contabilidad', 'Subtiava')");
		cursor.executeUpdate(
				"INSERT IGNORE INTO DEPARTAMENTO (depto_no, nombre_depto, localizacion) VALUES ('40', 'Ventas', 'San Felipe')");
		cursor.executeUpdate(
				"INSERT IGNORE INTO DEPARTAMENTO (depto_no, nombre_depto, localizacion) VALUES ('0', '', '')");

		// 'EMPLEADO' Data
		cursor.executeUpdate(
				"INSERT IGNORE INTO EMPLEADO (codigo_c, nombre, edad, oficio, dir, fecha_alt, salario, comision, depto_no) VALUES ('281-160483-0005F', 'Rocha Vargas Hector', '27', 'Vendedor', 'Leon', '19830512', '12000', '0', '40')");
		cursor.executeUpdate(
				"INSERT IGNORE INTO EMPLEADO (codigo_c, nombre, edad, oficio, dir, fecha_alt, salario, comision, depto_no) VALUES ('281-040483-0056P', 'López Hernandez Julio', '27', 'Analista', 'Chinandenga', '19820714', '13000', '1500', '20')");
		cursor.executeUpdate(
				"INSERT IGNORE INTO EMPLEADO (codigo_c, nombre, edad, oficio, dir, fecha_alt, salario, comision, depto_no) VALUES ('081-130678-0004S', 'Esquivel José', '31', 'Director', 'Juigalpa', '19810605', '16700', '1200', '30')");
		cursor.executeUpdate(
				"INSERT IGNORE INTO EMPLEADO (codigo_c, nombre, edad, oficio, dir, fecha_alt, salario, comision, depto_no) VALUES ('281-160473-0009Q', 'Delgado Carmen', '37', 'Vendedor', 'Leon', '19830302', '13400', '0', '40')");
		cursor.executeUpdate(
				"INSERT IGNORE INTO EMPLEADO (codigo_c, nombre, edad, oficio, dir, fecha_alt, salario, comision, depto_no) VALUES ('281-160493-0005F', 'Castillo Montes Luis', '17', 'Vendedor', 'Masaya', '19820812', '16309', '1000', '40')");
		cursor.executeUpdate(
				"INSERT IGNORE INTO EMPLEADO (codigo_c, nombre, edad, oficio, dir, fecha_alt, salario, comision, depto_no) VALUES ('281-240784-0004Y', 'Esquivel Leonel Alfonso', '26', 'Presidente', 'Nagarote', '19810912', '15000', '0', '30')");
		cursor.executeUpdate(
				"INSERT IGNORE INTO EMPLEADO (codigo_c, nombre, edad, oficio, dir, fecha_alt, salario, comision, depto_no) VALUES ('281-161277-0008R', 'Perez Luis', '32', 'Empleado', 'Managua', '19800302', '16890', '0', '10')");

		// 'HISTORICO' Data
		cursor.executeUpdate(
				"INSERT IGNORE INTO HISTORICO(codigo_c, depto_no, oficio, fecha_alt) SELECT codigo_c, depto_no, oficio, fecha_alt FROM EMPLEADO;");

		cursor.executeUpdate(
				"UPDATE IGNORE HISTORICO SET fecha_fin = '19850923' WHERE fecha_alt = '19830512'");
		cursor.executeUpdate(
				"UPDATE IGNORE HISTORICO SET fecha_fin = '19841201' WHERE fecha_alt = '19820714'");
		cursor.executeUpdate(
				"UPDATE IGNORE HISTORICO SET fecha_fin = '19860209' WHERE fecha_alt = '19810605'");
		cursor.executeUpdate(
				"UPDATE IGNORE HISTORICO SET fecha_fin = '19851015' WHERE fecha_alt = '19830302'");
		cursor.executeUpdate(
				"UPDATE IGNORE HISTORICO SET fecha_fin = '19830319' WHERE fecha_alt = '19820812'");
		cursor.executeUpdate(
				"UPDATE IGNORE HISTORICO SET fecha_fin = '19811123' WHERE fecha_alt = '19810912'");
		cursor.executeUpdate(
				"UPDATE IGNORE HISTORICO SET fecha_fin = '19890817' WHERE fecha_alt = '19800302'");
		cursor.close();
	}

	/**
	 * Method dedicated to execute each MySQL Exercise/Query
	 * 
	 * @param cursor
	 */
	private void modifyDB(Connection conn, UpdateList modif) {
		try {
			modif.updateQuery_1(conn);
			modif.updateQuery_2(conn);
			modif.updateQuery_3(conn);
			modif.updateQuery_4(conn);
			modif.updateQuery_5(conn);
			modif.updateQuery_6(conn);
			modif.updateQuery_7(conn);
			modif.updateQuery_8(conn);
			modif.updateQuery_9(conn);
			modif.updateQuery_10(conn);
			modif.updateQuery_11(conn);
			modif.updateQuery_12(conn);
			modif.updateQuery_13(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method dedicated to execute each MySQL Exercise/Query
	 * 
	 * @param cursor
	 */
	private void executeQuerys(Connection conn, QueryList ejer) {
		try {
			ejer.Query_1(conn);
			ejer.Query_2(conn);
			ejer.Query_3(conn);
			ejer.Query_4(conn);
			ejer.Query_5(conn);
			ejer.Query_6(conn);
			ejer.Query_7(conn);
			ejer.Query_8(conn);
			ejer.Query_9(conn);
			ejer.Query_10(conn);
			ejer.Query_11(conn);
			ejer.Query_12(conn);
			ejer.Query_13(conn);
			ejer.Query_14(conn);
			ejer.Query_15(conn);
			ejer.Query_16(conn);
			ejer.Query_17(conn);
			ejer.Query_18(conn);
			ejer.Query_19(conn);
			ejer.Query_20(conn);
			ejer.Query_21(conn);
			ejer.Query_22(conn);
			ejer.Query_23(conn);
			ejer.Query_24(conn);
			ejer.Query_25(conn);
			ejer.Query_26(conn);
			ejer.Query_27(conn);
			ejer.Query_28(conn);
			ejer.Query_29(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			App app = new App();
			QueryList querySQL = new QueryList();
			UpdateList updateSQL = new UpdateList();

			Connection conn = app.connectDB();

			app.createDB(conn, "MariaDB_Ejer1");
			app.createTables(conn);
			app.insertData(conn);

			app.executeQuerys(conn, querySQL);
			//app.modifyDB(conn, updateSQL);

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
