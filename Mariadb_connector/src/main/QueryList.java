package main;

import java.sql.*;

public class QueryList {

    /**
     * 1.- Mostrar los nombres de los empleados ordenados alfabéticamente (Z…A)
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_1(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "1.- Mostrar los nombres de los empleados ordenados alfabéticamente (Z…A)";
        String query = "SELECT codigo_c, nombre, edad, oficio, dir, DATE_FORMAT(fecha_alt, '%d/%m/%Y') fecha_alt, salario, comision, depto_no FROM EMPLEADO ORDER BY nombre DESC;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("codigo_c") + "\t" +
                    result.getString("nombre") + "\t" +
                    result.getInt("edad") + "\t" +
                    result.getString("oficio") + "\t" +
                    result.getString("dir") + "\t" +
                    result.getString("fecha_alt") + "\t" +
                    result.getInt("salario") + "\t" +
                    result.getInt("comision") + "\t" +
                    result.getInt("depto_no") + "\t" + 
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 2.- Seleccionar el nombre, el oficio y la localidad de los departamentos
     * donde trabajan los Vendedores.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_2(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "2.- Seleccionar el nombre, el oficio y la localidad de los departamentos donde trabajan los Vendedores.";
        String query = "SELECT e.nombre, e.oficio, d.localizacion FROM EMPLEADO e LEFT JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no WHERE e.oficio = 'Vendedor';";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("nombre") + "\t" +
                    result.getString("oficio") + "\t" +
                    result.getString("localizacion") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 3.- Listar los nombres de los empleados cuyo nombre termine con la letra ‘o’.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_3(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "3.- Listar los nombres de los empleados cuyo nombre termine con la letra 'o'.";
        String query = "SELECT nombre FROM EMPLEADO WHERE nombre LIKE '%o'";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("nombre") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 4.- Seleccionar el nombre, el oficio y salario de los empleados que trabajan
     * en León.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_4(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "4.- Seleccionar el nombre, el oficio y salario de los empleados que trabajan en León.";
        String query = "SELECT nombre, oficio, salario FROM EMPLEADO WHERE dir = 'Leon';";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("nombre") + "\t" +
                    result.getString("oficio") + "\t" +
                    result.getInt("salario") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 5.- Seleccionar el nombre, salario y localidad donde trabajan los
     * empleados que tengan un salario entre 10000 y 13000.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_5(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "5.- Seleccionar el nombre, salario y localidad donde trabajan los empleados que tengan un salario entre 10000 y 13000.";
        String query = "SELECT nombre, salario, dir FROM EMPLEADO WHERE salario BETWEEN 10000 AND 13000";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("nombre") + "\t" +
                    result.getInt("salario") + "\t" +
                    result.getString("dir") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 6.- Visualizar los departamentos con más de 5 empleados.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_6(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "6.- Visualizar los departamentos con más de 5 empleados.";
        String query = "SELECT e.depto_no, COUNT(*) FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no GROUP BY e.depto_no HAVING COUNT(*) > 5;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getInt("depto_no") + "\t" +
                    result.getInt("COUNT(*)") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 7.- Mostrar el nombre, salario y nombre del departamento de los
     * empleados que tengan el mismo oficio que ‘Leonel Alfonso Esquivel’.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_7(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "7.- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo oficio que 'Leonel Alfonso Esquivel'.";
        String query = "SELECT e.nombre, e.salario, d.nombre_depto FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no WHERE e.oficio = (SELECT oficio FROM EMPLEADO WHERE nombre = 'Esquivel Leonel Alfonso')";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("nombre") + "\t" +
                    result.getInt("salario") + "\t" +
                    result.getString("nombre_depto") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 8.- Mostrar el nombre, salario y nombre del departamento de los
     * empleados que tengan el mismo oficio que “Castillo Montes Luis” y
     * que no tengan comisión.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_8(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "8.- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo oficio que “Castillo Montes Luis” y que no tengan comisión.";
        String query = "SELECT e.nombre, e.salario, d.nombre_depto FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no WHERE e.oficio = (SELECT oficio FROM EMPLEADO WHERE nombre = 'Castillo Montes Luis') AND e.comision = 0;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("nombre") + "\t" +
                    result.getInt("salario") + "\t" +
                    result.getString("nombre_depto") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 9.- Mostrar los datos de los empleados que trabajan en el
     * departamento de contabilidad, ordenados por nombre.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_9(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "9.- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.";
        String query = "SELECT e.codigo_c, e.nombre, e.edad, e.oficio, e.dir, DATE_FORMAT(e.fecha_alt, '%d/%m/%Y') fecha_alt, e.salario, e.comision, e.depto_no, d.nombre_depto FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no WHERE d.nombre_depto = 'Contabilidad';";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("codigo_c") + "\t" +
                    result.getString("nombre") + "\t" +
                    result.getInt("edad") + "\t" +
                    result.getString("oficio") + "\t" +
                    result.getString("dir") + "\t" +
                    result.getString("fecha_alt") + "\t" +
                    result.getInt("salario") + "\t" +
                    result.getInt("comision") + "\t" +
                    result.getInt("depto_no") + "\t" + 
                    result.getString("nombre_depto") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 10.- Nombre de los empleados que trabajan en León y cuyo oficio sea
     * analista o empleado.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_10(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "10.- Nombre de los empleados que trabajan en León y cuyo oficio sea analista o empleado.";
        String query = "SELECT e.nombre FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no WHERE d.localizacion = 'Leon' AND e.oficio = 'Analista' OR e.oficio = 'EMPLEADO'";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("nombre") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 11.- Calcula el salario medio de todos los empleados.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_11(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "11.- Calcula el salario medio de todos los empleados.";
        String query = "SELECT AVG(salario) FROM EMPLEADO";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getInt("AVG(salario)") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 12.- ¿Cuál es el máximo salario de los empleados del departamento 10?
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_12(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "12.- ¿Cuál es el máximo salario de los empleados del departamento 10?";
        String query = "SELECT MAX(salario) FROM EMPLEADO WHERE depto_no = 10;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getInt("MAX(salario)") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 13.- Calcula el salario mínimo de los empleados del departamento
     * ‘VENTAS’.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_13(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "13.- Calcula el salario mínimo de los empleados del departamento 'VENTAS'.";
        String query = "SELECT MIN(e.salario) FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no WHERE d.nombre_depto = 'Ventas';";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getInt("MIN(e.salario)") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 14.- Calcula el promedio del salario de los empleados del departamento de
     * ‘CONTABILIDAD’.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_14(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "14.- Calcula el promedio del salario de los empleados del departamento de 'CONTABILIDAD'.";
        String query = "SELECT AVG(e.salario) FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no WHERE d.nombre_depto = 'Contabilidad';";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getInt("AVG(e.salario)") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 15.- ¿Cuántos empleados hay en el departamento número 10?
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_15(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "15.- ¿Cuántos empleados hay en el departamento número 10?";
        String query = "SELECT COUNT(*) FROM EMPLEADO WHERE depto_no = 10;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getInt("COUNT(*)") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 16.- ¿Cuántos empleados hay en el departamento de ‘VENTAS’?
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_16(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "16.- ¿Cuántos empleados hay en el departamento de 'VENTAS'?";
        String query = "SELECT COUNT(*) FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no WHERE d.nombre_depto = 'Ventas';";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getInt("COUNT(*)") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 17.- Calcula el número de empleados que no tienen comisión.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_17(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "17.- Calcula el número de empleados que no tienen comisión.";
        String query = "SELECT COUNT(*) FROM EMPLEADO WHERE comision = 0;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getInt("COUNT(*)") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 18.- Visualizar cuántos nombres de los empleados empiezan por la
     * letra ‘A’.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_18(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "18.- Visualizar cuántos nombres de los empleados empiezan por la letra 'A'.";
        String query = "SELECT COUNT(*) FROM EMPLEADO WHERE nombre LIKE 'A%';";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getInt("COUNT(*)") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 19.- Visualizar el número de empleados de cada departamento.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_19(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "19.- Visualizar el número de empleados de cada departamento.";
        String query = "SELECT e.depto_no, COUNT(*) FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no GROUP BY e.depto_no;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("depto_no") + "\t" +
                    result.getInt("COUNT(*)") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 20.- Para cada oficio obtener la suma de salarios.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_20(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "20.- Para cada oficio obtener la suma de salarios.";
        String query = "SELECT e.depto_no, SUM(e.salario) FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no GROUP BY e.depto_no;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("depto_no") + "\t" +
                    result.getInt("SUM(e.salario)") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 21.- Mostrar los datos de los empleados cuyo salario sea mayor que
     * la media de todos los salarios.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_21(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "21.- Mostrar los datos de los empleados cuyo salario sea mayor que la media de todos los salarios.";
        String query = "SELECT codigo_c, nombre, edad, oficio, dir, DATE_FORMAT(fecha_alt, '%d/%m/%Y') fecha_alt, salario, comision, depto_no FROM EMPLEADO WHERE salario > (SELECT AVG(salario) FROM EMPLEADO);";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("codigo_c") + "\t" +
                    result.getString("nombre") + "\t" +
                    result.getInt("edad") + "\t" +
                    result.getString("oficio") + "\t" +
                    result.getString("dir") + "\t" +
                    result.getString("fecha_alt") + "\t" +
                    result.getInt("salario") + "\t" +
                    result.getInt("comision") + "\t" +
                    result.getInt("depto_no") + "\t" + 
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 22.- Seleccionar el nombre del empleado que tiene máximo salario.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_22(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "22.- Seleccionar el nombre del empleado que tiene máximo salario.";
        String query = "SELECT nombre FROM EMPLEADO WHERE salario = (SELECT MAX(salario) FROM EMPLEADO);";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("nombre") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 23.- Mostrar el nombre del empleado que tiene el salario más bajo.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_23(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "23.- Mostrar el nombre del empleado que tiene el salario más bajo.";
        String query = "SELECT nombre FROM EMPLEADO WHERE salario = (SELECT MIN(salario) FROM EMPLEADO);";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("nombre") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 24.- Mostrar los datos del empleado que tiene el salario más alto en
     * el departamento de ‘VENTAS’.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_24(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "24.- Mostrar los datos del empleado que tiene el salario más alto en el departamento de 'VENTAS'.";
        String query = "SELECT e.codigo_c, e.nombre, e.edad, e.oficio, e.dir, DATE_FORMAT(fecha_alt, '%d/%m/%Y') fecha_alt, e.salario, e.comision, e.depto_no FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no WHERE e.salario = (SELECT MAX(e.salario) FROM EMPLEADO e JOIN DEPARTAMENTO d ON e.depto_no = d.depto_no WHERE d.nombre_depto = 'Ventas');";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("codigo_c") + "\t" +
                    result.getString("nombre") + "\t" +
                    result.getInt("edad") + "\t" +
                    result.getString("oficio") + "\t" +
                    result.getString("dir") + "\t" +
                    result.getString("fecha_alt") + "\t" +
                    result.getInt("salario") + "\t" +
                    result.getInt("comision") + "\t" +
                    result.getInt("depto_no") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 25.- Visualizar el departamento con más empleados.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_25(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "25.- Visualizar el departamento con más empleados.";
		// solucion temporal
        String query = "SELECT d.depto_no, d.nombre_depto, COUNT(*) AS num_empleados FROM DEPARTAMENTO d JOIN EMPLEADO e ON d.depto_no = e.depto_no GROUP BY d.depto_no ORDER BY COUNT(*) DESC LIMIT 1;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("depto_no") + "\t" +
                    result.getString("nombre_depto") + "\t" +
                    result.getInt("num_empleados") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 26.- Visualizar el número de departamento que tenga más empleados
     * cuyo oficio sea empleado.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_26(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "26.- Visualizar el número de departamento que tenga más empleados cuyo oficio sea empleado.";
        String query = "SELECT d.depto_no, COUNT(*) AS num_empleados FROM DEPARTAMENTO d JOIN EMPLEADO e ON d.depto_no = e.depto_no AND e.oficio = 'Empleado' GROUP BY d.depto_no ORDER BY COUNT(*) DESC LIMIT 1;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("depto_no") + "\t" +
                    result.getInt("num_empleados") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 27.- Mostrar el número de oficios distintos de cada departamento.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_27(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "27.- Mostrar el número de oficios distintos de cada departamento.";
        String query = "SELECT d.nombre_depto, COUNT(DISTINCT e.oficio) AS num_oficios FROM DEPARTAMENTO d JOIN EMPLEADO e ON d.depto_no = e.depto_no GROUP BY d.nombre_depto ORDER BY num_oficios DESC LIMIT 1";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
                    result.getString("nombre_depto") + "\t" +
                    result.getInt("num_oficios") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

    /**
     * 28.- Mostrar los departamentos que tengan más de dos personas trabajando en
     * la misma profesión.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_28(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "28.- Mostrar los departamentos que tengan más de dos personas trabajando en la misma profesión.";
        String query = "SELECT d.depto_no, d.nombre_depto, d.localizacion, e.oficio, COUNT(*) AS num_personas FROM DEPARTAMENTO d JOIN EMPLEADO e ON d.depto_no = e.depto_no GROUP BY d.depto_no, e.oficio HAVING num_personas > 2;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
					result.getInt("depto_no") + "\t" +
                    result.getString("nombre_depto") + "\t" +
					result.getString("localizacion") + "\t" +
					result.getString("oficio") + "\t" +
                    result.getInt("num_personas") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }

	/**
     * 29.- Mostrar la informacion de la tabla HISTORICO junto a los nombres de los empleados y departamentos
	 * ordenados por fecha de alta anterior.
     * 
     * @param cursor
     * @throws SQLException
     */
    public void Query_29(Connection conn) throws SQLException {
		Statement cursor = conn.createStatement();

        String description = "29.- Mostrar la informacion de la tabla HISTORICO junto a los nombres de los empleados y departamentos ordenados por fecha de alta anterior.";
        String query = "SELECT h.codigo, h.codigo_c, e.nombre, d.nombre_depto, h.depto_no, h.oficio, DATE_FORMAT(h.fecha_alt, '%d/%m/%Y') fecha_alt, DATE_FORMAT(h.fecha_fin, '%d/%m/%Y') fecha_fin FROM HISTORICO h JOIN EMPLEADO e ON h.codigo_c = e.codigo_c JOIN DEPARTAMENTO d ON h.depto_no = d.depto_no ORDER BY DATE_FORMAT(h.fecha_alt, '%Y/%m/d') ASC;";

        System.out.println("\n\n" + Color.WHITE + description + Color.RESET);
        System.out.println("\n" + Color.PURPLE + query + Color.RESET + "\n");

        ResultSet result = cursor.executeQuery(query);
        while (result.next()) {
            System.out.println(
                    Color.CYAN +
					result.getInt("codigo") + "\t" +
                    result.getString("codigo_c") + "\t" +
					result.getString("nombre") + "\t" +
					result.getString("nombre_depto") + "\t" +
                    result.getInt("depto_no") + "\t" +
					result.getString("oficio") + "\t" +
					result.getString("fecha_alt") + "\t" +
					result.getString("fecha_fin") + "\t" +
                    Color.RESET);
        }
        result.close();
		cursor.close();
    }
}
