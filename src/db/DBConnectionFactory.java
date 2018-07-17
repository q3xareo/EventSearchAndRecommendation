package db;

import db.mongodb.MongoDBConnection;
import db.mysql.MySQLConnection;

public class DBConnectionFactory {
	// This should change based on the pipeline.
	private static final String DEFAULT_DB = "mysql";
	//private static final String DEFAULT_DB = "mongodb";
	
	public static DBConnection getConnection(String db) throws IllegalArgumentException{
		switch(db) {
			case "mysql":
				return new MySQLConnection();	//new MySQLDBConnection()
			case "mongodb":		
				return new MongoDBConnection();	//new MongoDBCoonection()
			default:
				throw new IllegalArgumentException("Invalid db: " + db);
		}
	}
	public static DBConnection getConnection() throws IllegalArgumentException{
		return getConnection(DEFAULT_DB);
	}
}

