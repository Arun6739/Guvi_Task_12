package com.WDB2.Selenium.Task_12;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQL_Q2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Q2";
        String user = "root"; 
        String password = "Arun@2000315"; 
        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertSQL = "INSERT INTO EMPLOYEE (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        try {
            conn = DriverManager.getConnection(url, user, password);

            pstmt = conn.prepareStatement(insertSQL);

            insertEmployee(pstmt, 101, "Jenny", 25, 10000);
            insertEmployee(pstmt, 102, "Jacky", 30, 20000);
            insertEmployee(pstmt, 103, "Joe", 20, 40000);
            insertEmployee(pstmt, 104, "John", 40, 80000);
            insertEmployee(pstmt, 105, "Shameer", 25, 90000);

            System.out.println("Data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void insertEmployee(PreparedStatement pstmt, int empcode, String empname, int empage, double esalary) throws SQLException {
        pstmt.setInt(1, empcode);
        pstmt.setString(2, empname);
        pstmt.setInt(3, empage);
        pstmt.setDouble(4, esalary);
        pstmt.executeUpdate();
    }
}
