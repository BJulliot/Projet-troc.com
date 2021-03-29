package fr.eni.projet.troc.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {

	private static DataSource dataSource;

	/**
	 * Au chargement de la classe, la DataSource est recherch�e dans le JNDI de
	 * Tomcat (context.xml)
	 */
	static {
		Context context;
		try {
			context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot Access The Database");
		}
	}

	/**
	 * Getter pour acc�der � la connexion
	 */
	public static Connection getConnection() throws SQLException {
		return ConnectionProvider.dataSource.getConnection();
	}
}
