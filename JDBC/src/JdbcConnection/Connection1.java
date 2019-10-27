package JdbcConnection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Connection1 {
	    @Test
	    public void testStatement(){
	    	Connection conn = null;
	    	Statement statement = null;
	    	try {
				conn = getConnection();
				String sql = "INSERT INTO user(Id,Name,Age)VALUES(5,'李星',25)";
				statement  = conn.createStatement();
				statement.executeUpdate(sql);
			}  catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(statement != null){
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null){
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
	    	
	    }

	    @Test   //获取连接
	    public Connection getConnection() throws Exception{
	 	    String user = "sa";
		    String password = "249693842";
		    String jdbcUrl = "jdbc:sqlserver://localhost:3306/kyle";
		    String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		    
		    Class.forName(driverClass);
		    return DriverManager.getConnection(jdbcUrl, user, password);
	    }
	    
}
