package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.Mahasiswa;

/**
 *
 * @author sqlitetutorial.net
 */
public class SQLite {

	/**
	 * Connect to the test.db database
	 *
	 * @return the Connection object
	 */
	private Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:D:/_private/_Workspace/Eclipse/Workspace/modul6/database/Modul6.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * Insert a new row into the warehouses table
	 *
	 * @param name
	 * @param capacity
	 */
	public void insert(String Nim, String Nama, String Fakultas, String Jurusan, String Alamat, String Kota,
			String KodePos, String Hobby) {
		String sql = "INSERT INTO mahasiswa(nim,nama,fakultas,jurusan,alamat,kota,kodepos,hobby) VALUES(?,?,?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Nim);
			pstmt.setString(2, Nama);
			pstmt.setString(3, Fakultas);
			pstmt.setString(4, Jurusan);
			pstmt.setString(5, Alamat);
			pstmt.setString(6, Kota);
			pstmt.setString(7, KodePos);
			pstmt.setString(8, Hobby);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Mahasiswa> selectAll() {
		String sql = "SELECT * FROM mahasiswa";
		ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();
		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				mahasiswas.add(new Mahasiswa(rs.getString("nim"), rs.getString("nama"), rs.getString("fakultas"),
						rs.getString("jurusan"), rs.getString("alamat"), rs.getString("kota"), rs.getString("kodepos"),
						rs.getString("hobby")));
				
				System.out.println(rs.getString("nim") + "\t" + rs.getString("nama") + "\t" + rs.getString("fakultas")
						+ "\t" + rs.getString("jurusan") + "\t" + rs.getString("alamat") + "\t" + rs.getString("kota")
						+ "\t" + rs.getString("kodepos") + "\t" + rs.getString("hobby"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return mahasiswas;
	}

	public void delete(String nim, int index) {
		String sql = "DELETE FROM mahasiswa WHERE nim = ?";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setString(1, nim);
			// execute the delete statement
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(String Nim, String Nama, String Fakultas, String Jurusan, String Alamat, String Kota,
			String KodePos, String Hobby) {
		String sql = "UPDATE mahasiswa SET nama = ? , " + "fakultas = ? , " + "jurusan = ? , " + "alamat = ? , " + "kota = ? , "
				+ "kodepos = ?, " + "hobby = ? " + "WHERE nim = ?";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setString(1, Nama);
			pstmt.setString(2, Fakultas);
			pstmt.setString(3, Jurusan);
			pstmt.setString(4, Alamat);
			pstmt.setString(5, Kota);
			pstmt.setString(6, KodePos);
			pstmt.setString(7, Hobby);
			pstmt.setString(8, Nim);
			// update
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
}