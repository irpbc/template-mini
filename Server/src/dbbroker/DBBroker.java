package dbbroker;

import domen.Objekat1;
import domen.Objekat3;
import domen.Objekat2;
import domen.Objekat4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBBroker {
	private static DBBroker instance;
	private Connection konekcija;
	
	private DBBroker(){}
	
	public static DBBroker getInstance() {
		if (instance == null)
			instance = new DBBroker();
		return instance;
	}

	public void ucitajDrajver() throws ClassNotFoundException {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}

	public void poveziSaBazom() throws SQLException {
		konekcija = DriverManager.getConnection("jdbc:odbc:baza");
		konekcija.setAutoCommit(false);
	}

	public void commit() throws SQLException{
		konekcija.commit();
	}

	public void rollback() throws SQLException{
		konekcija.rollback();
	}

	public void close() throws SQLException {
		konekcija.close();
	}

	public void sacuvajObjekat1(Objekat1 pr) throws SQLException {
				
		String sql = "INSERT INTO xxx VALUES ()";
		PreparedStatement ps = konekcija.prepareStatement(sql);
		
		ps.setLong(1, pr.getId());
		
		

		ps.executeUpdate(sql);

	}
	
	public void sacuvajSveObjekat1(List<Objekat1> lista) throws SQLException {
				
		String sql = "INSERT INTO xxx VALUES ()";
		PreparedStatement ps = konekcija.prepareStatement(sql);
		
		for (Objekat1 o : lista) {
			ps.setLong(1, o.getId());
		
			ps.executeUpdate(sql);
		}
	}

	public List<Objekat2> vratiSveObjekat2() throws SQLException {

		String sql = "SELECT * from Advokat";
		Statement st = konekcija.createStatement();

		st.execute(sql);

		ResultSet rs = st.getResultSet();
		ArrayList<Objekat2> lista = new ArrayList<>();
		
		while (rs.next()) {
			long id = rs.getLong(1);
			
			Objekat2 obj = new Objekat2();
			lista.add(obj);
		}

		return lista;
	}
	
	public List<Objekat3> vratiSveObjekat3() throws SQLException {

		String sql = "SELECT * from VrstaPostuka";
		Statement st = konekcija.createStatement();

		st.execute(sql);

		ResultSet rs = st.getResultSet();
		ArrayList<Objekat3> lista = new ArrayList<>();
		
		while (rs.next()) {
			
			Objekat3 obj = new Objekat3();
			lista.add(obj);
		}

		return lista;
	}
	
	public List<Objekat4> vratiSveObjekat4() throws SQLException {

		String sql = "SELECT * from Klijent";
		Statement st = konekcija.createStatement();

		st.execute(sql);

		ResultSet rs = st.getResultSet();
		ArrayList<Objekat4> lista = new ArrayList<>();
		
		while (rs.next()) {
			long id = rs.getLong(1);
			
			Objekat4 obj = new Objekat4();
			lista.add(obj);
		}

		return lista;
	}
}