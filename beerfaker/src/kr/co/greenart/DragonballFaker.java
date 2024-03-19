package kr.co.greenart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.javafaker.Faker;

public class DragonballFaker {
	public static void main(String[] args) {
		Faker faker = new Faker();

		
		
		String sql = "INSERT INTO `my_db`.`dragonball` (`charactor`) VALUES (?);";
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root","0302tnehd");
				PreparedStatement stmt = conn.prepareStatement(sql)){
			for(int i = 0; i<100;i++) {
				stmt.setString(1, faker.dragonBall().character());
				
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
