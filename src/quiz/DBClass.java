package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import day19.Info;

public class DBClass {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public DBClass() {
		System.out.println("회원관리프로그램입니다.");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url,"java2","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int insert(Info2 info2) {
		String sql = "insert into quiz values(?,?,?,?)";
		int result =0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, info2.getId());
			ps.setString(2, info2.getName());
			ps.setInt(3, info2.getAge());
			ps.setString(4, info2.getAddr());
			result = ps.executeUpdate();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return result;
	}
	public Info2 serch(String id) {
		String sql = "select * from quiz where id= '"+id+"'";
		Info2 info2 = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				info2 = new Info2();
				info2.setId(rs.getString("id"));
				info2.setName(rs.getString("name"));
				info2.setAge(rs.getInt("age"));
				info2.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info2;
	}
	public ArrayList<Info2> select() {
		String sql = "select * from quiz";
		ArrayList<Info2> list = new ArrayList<Info2>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Info2 info2 = new Info2();
				info2.setId(rs.getString("id"));
				info2.setName(rs.getString("name"));
				info2.setAge(rs.getInt("age"));
				info2.setAddr(rs.getString("addr"));
				list.add(info2);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void delete(String id) {
		String sql = "delete from quiz where id ='"+id+"'";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

