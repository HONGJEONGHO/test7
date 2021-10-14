package itor.example.test7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Test7Application {

    public static void main(String[] args) {
        SpringApplication.run(Test7Application.class, args);

        Connection conn = null;

        String server = "localhost";
        String user_name = "root";
        String password = "hong3679!@";

        //JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생 " + e.getMessage());
            e.printStackTrace();
        }
        // 접속
        try{
            conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + "?useSSL=false" , user_name , password);
            System.out.println("연결완료");
        } catch(SQLException e){
            System.err.println("연결 오류 " + e.getMessage());
            e.printStackTrace();
        }
        // 접속 종료
        try{
          if(conn != null)
                conn.close();
        } catch(SQLException e){

        }


    }
}
