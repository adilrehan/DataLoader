import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		//Connection connection = getConnection("jdbc:sqlserver://ucmdb.demo.hpadvantageinc.com", "ud_reader", "*****");
		Connection connection = getConnection("jdbc:sqlserver://16.77.8.187;databaseName=SMDB", "xrp", "Passw0rd123$");
		getServer( connection );
		System.out.println("Done");
		System.out.println("Done2");
		System.out.println("Done3");
		System.out.println("Done4");
		System.out.println("Done5");
		
		
	}
	
	private static Connection getConnection( String databaseUrl, String userName, String password ) throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection connection = null;
		//String dbURL = "jdbc:sqlserver://ucmdb.demo.hpadvantageinc.com";
		//String user = "ud_reader";
		//String pass = "******";
		
		try {
			
			connection = DriverManager.getConnection(databaseUrl, userName, password);
			if (connection != null) {
			    System.out.println( String.format("Connected: %s",databaseUrl));
		        DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		        System.out.println("Driver name: " + dm.getDriverName());
		        System.out.println("Driver version: " + dm.getDriverVersion());
		        System.out.println("Product name: " + dm.getDatabaseProductName());
		        System.out.println("Product version: " + dm.getDatabaseProductVersion());
			}
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } 
		return connection;
	}

	private static void getServer( Connection connection ) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select cmdb_id, a_display_label, a_discovered_os_name, a_host_isvirtual, a_serial_number, a_discovered_model, a_name, a_domain_name, a_primary_dns_name, a_primary_ip_address from cdm_nt_1");
		while( resultSet.next() ) {
			System.out.print(resultSet.getString("cmdb_id"));
			System.out.print("\t");
			System.out.print(resultSet.getString("a_display_label"));
			System.out.print("\t");
			System.out.print(resultSet.getString("a_discovered_os_name"));
			System.out.print("\t");
			System.out.print(resultSet.getString("a_host_isvirtual"));
			System.out.print("\t");
			System.out.print(resultSet.getString("a_serial_number"));
			System.out.print("\t");
			System.out.print(resultSet.getString("a_discovered_model"));			
			System.out.print("\t");
			System.out.print(resultSet.getString("a_name"));
			System.out.print("\t");
			System.out.print(resultSet.getString("a_domain_name"));
			System.out.print("\t");
			System.out.print(resultSet.getString("a_primary_dns_name"));
			System.out.print("\t");
			System.out.print(resultSet.getString("a_primary_ip_address"));
			System.out.println();
		}
		resultSet.close();
		statement.close();
	}
	
}
