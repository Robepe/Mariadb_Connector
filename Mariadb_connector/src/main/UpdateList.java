package main;

import java.sql.*;

public class UpdateList {

	/**
	 * 1.- Insertar en la tabla EMPLEADO un empleado con código 081-
	 * 220678-0008U, nombre ‘Pérez Luis Carlos’ de 32 años, oficio
	 * Analista, vive en Matagalpa, fecha de alta en la empresa el 22-06-
	 * 2001, su salario es C$ 15600, no tiene comisión y pertenece al
	 * departamento 20.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_1(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "1.- Insertar en la tabla EMPLEADO un empleado con código 081-220678-0008U, nombre 'Pérez Luis Carlos' de 32 años, oficioAnalista, vive en Matagalpa, fecha de alta en la empresa el 22-06-2001, su salario es C$ 15600, no tiene comisión y pertenece aldepartamento 20.";
		String query = "INSERT IGNORE INTO EMPLEADO VALUES ('081-220678-0008U', 'Perez Luis Carlos', 32, 'Analista', 'Matagalpa', 20010622, 15600, 0, 20);";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
		System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

		int result = cursor.executeUpdate(query);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);
		cursor.close();
	}

	/**
	 * 2.- Insertar en la tabla DEPARTAMENTO un departamento cuyo número
	 * sea 50, de nombre ‘GENERAL’ y cuya localización sea ‘Laborio’.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_2(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "2.- Insertar en la tabla DEPARTAMENTO un departamento cuyo número sea 50, de nombre 'GENERAL' y cuya localización sea 'Laborio'.";
		String query = "INSERT IGNORE INTO DEPARTAMENTO VALUES (50, 'General', 'Laborio');";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
		System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

		int result = cursor.executeUpdate(query);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);
		cursor.close();
	}

	/**
	 * 3.- Insertar en la tabla DEPARTAMENTO un departamento cuyo número
	 * sea 60 y de nombre ‘PRUEBAS’.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_3(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "3.- Insertar en la tabla DEPARTAMENTO un departamento cuyo número sea 60 y de nombre 'PRUEBAS'.";
		String query = "INSERT IGNORE DEPARTAMENTO (depto_no, nombre_depto) VALUES (60, 'Pruebas');";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
		System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

		int result = cursor.executeUpdate(query);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);
		cursor.close();
	}

	/**
	 * 4.- Insertar en la tabla PRUEBA los datos de los empleados que
	 * pertenecen al departamento número 30.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_4(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "4.- Insertar en la tabla PRUEBA los datos de los empleados que pertenecen al departamento número 30.";
		String query1 = "CREATE TABLE IF NOT EXISTS PRUEBA (codigo_c VARCHAR(16) NOT NULL PRIMARY KEY, nombre VARCHAR(30) NOT NULL, edad INT NOT NULL, oficio VARCHAR(20) NOT NULL, dir VARCHAR (20) NOT NULL, fecha_alt DATE NOT NULL, salario INT NOT NULL, comision INT NOT NULL, depto_no INT NOT NULL);";
		String query2 = "INSERT IGNORE INTO PRUEBA (codigo_c, nombre, edad, oficio, dir, fecha_alt, salario, comision, depto_no) SELECT * FROM EMPLEADO WHERE depto_no = 30;";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);

		System.out.println("\n" + Color.PURPLE + query1 + Color.RESET + "\n");
		int result = cursor.executeUpdate(query1);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);

		System.out.println("\n" + Color.PURPLE + query2 + Color.RESET + "\n");
		result = cursor.executeUpdate(query2);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);

		cursor.close();
	}

	/**
	 * 5.- Insertar en la tabla PRUEBA2 el codigo_c, número de
	 * departamento y salario de los empleados que pertenecen al
	 * departamento número 20.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_5(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "5.- Insertar en la tabla PRUEBA2 el codigo_c, número de departamento y salario de los empleados que pertenecen al departamento número 20.";
		String query1 = "CREATE TABLE IF NOT EXISTS PRUEBA2 (codigo_c VARCHAR(16) NOT NULL PRIMARY KEY, depto_no INT NOT NULL, salario INT NOT NULL);";
		String query2 = "INSERT IGNORE INTO PRUEBA2 (codigo_c, depto_no, salario) SELECT codigo_c, depto_no, salario FROM EMPLEADO WHERE depto_no = 20;";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);

		System.out.println("\n" + Color.PURPLE + query1 + Color.RESET + "\n");
		int result = cursor.executeUpdate(query1);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);

		System.out.println("\n" + Color.PURPLE + query2 + Color.RESET + "\n");
		result = cursor.executeUpdate(query2);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);

		cursor.close();
	}

	/**
	 * 6.- Doblar el salario a todos los empleados del departamento 30.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_6(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "6.- Doblar el salario a todos los empleados del departamento 30.";
		String query = "UPDATE IGNORE EMPLEADO SET salario = (salario * 2);";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
		System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

		int result = cursor.executeUpdate(query);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);
		cursor.close();
	}

	/**
	 * 7.- Cambiar todos los empleados del departamento número 30
	 * departamento número 20.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_7(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "7.- Cambiar todos los empleados del departamento número 30 departamento número 20.";
		String query = "UPDATE IGNORE EMPLEADO SET depto_no = 20 WHERE depto_no = 30;";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
		System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

		int result = cursor.executeUpdate(query);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);
		cursor.close();
	}

	/**
	 * 8.- Incrementar en un 10% el sueldo de los empleados
	 * departamento 10.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_8(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "8.- Incrementar en un 10% el sueldo de los empleados departamento 10.";
		String query = "UPDATE IGNORE EMPLEADO SET salario = (salario * 1.10) WHERE depto_no = 10;";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
		System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

		int result = cursor.executeUpdate(query);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);
		cursor.close();
	}

	/**
	 * 9.- Cambiar la localidad del departamento número 10 a ‘Zaragoza’.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_9(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "9.- Cambiar la localidad del departamento número 10 a 'Zaragoza'.";
		String query = "UPDATE IGNORE DEPARTAMENTO SET localizacion = 'Zaragoza' WHERE depto_no = 10;";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
		System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

		int result = cursor.executeUpdate(query);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);
		cursor.close();
	}

	/**
	 * 10.- Igualar el salario de ‘Esquivel Jose’ al salario de ‘Esquivel
	 * Leonel Alfonso’, de la tabla PRUEBA.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_10(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "10.- Igualar el salario de 'Esquivel Jose' al salario de 'Esquivel Leonel Alfonso', de la tabla PRUEBA.";
		String query = "UPDATE IGNORE PRUEBA SET salario = (SELECT salario FROM PRUEBA WHERE nombre = 'Esquivel Leonel Alfonso') WHERE nombre = 'Esquivel Jose';";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
		System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

		int result = cursor.executeUpdate(query);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);
		cursor.close();
	}

	/**
	 * 11.- En la tabla DEPARTAMENTO borrar el departamento número 40.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_11(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "11.- En la tabla DEPARTAMENTO borrar el departamento número 40.";
		String query = "DELETE FROM DEPARTAMENTO WHERE depto_no = 40;";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
		System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

		int result = cursor.executeUpdate(query);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);
		cursor.close();
	}

	/**
	 * 12.- En la tabla EMPELADO borrar todos los empleados que sean del
	 * departamento 20 y sean ‘ANALISTAS’.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_12(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "12.- En la tabla EMPELADO borrar todos los empleados que sean del departamento 20 y sean 'ANALISTAS'.";
		String query = "DELETE FROM EMPLEADO WHERE depto_no = 20 AND oficio = 'Analista';";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
		System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

		int result = cursor.executeUpdate(query);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);
		cursor.close();
	}

	/**
	 * 13.- Borrar de la tabla EMPLEADO todos los empleados que no tengan
	 * comisión.
	 * 
	 * @param cursor
	 * @throws SQLException
	 */
	public void updateQuery_13(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

		String description = "13.- Borrar de la tabla EMPLEADO todos los empleados que no tengan comisión.";
		String query = "DELETE FROM EMPLEADO WHERE comision = 0;";

		System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
		System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

		int result = cursor.executeUpdate(query);
		System.out.println(Color.YELLOW + "Numero de filas afectadas: " + result + Color.RESET);
		cursor.close();
	}
}
