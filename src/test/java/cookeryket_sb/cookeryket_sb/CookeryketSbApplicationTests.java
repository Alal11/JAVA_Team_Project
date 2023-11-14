package cookeryket_sb.cookeryket_sb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest
class CookeryketSbApplicationTests {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try (Connection con =
					 DriverManager.getConnection(
							 "jdbc:mysql://localhost:3306/spring_security?serverTimezone=Asia/Seoul",
							 "root",
							 "1234")) {
			System.out.println("DB Connection => " + con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
