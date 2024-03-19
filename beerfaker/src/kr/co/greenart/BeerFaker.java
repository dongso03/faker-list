package kr.co.greenart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.javafaker.Faker;

public class BeerFaker {
	public static void main(String[] args) {
		Faker faker = new Faker();
		
		System.out.println(faker.beer().name());
		System.out.println(faker.beer().name());
		System.out.println(faker.beer().name());
		System.out.println(faker.beer().name());
		String sql = "Insert into beer (name, price) values (?,?)";
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root","root");
				PreparedStatement stmt = conn.prepareStatement(sql)){
			for(int i = 0; i<100;i++) {
				stmt.setString(1, faker.beer().name());
				stmt.setInt(2, faker.number().numberBetween(4000, 6000));
				stmt.addBatch();
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
}
