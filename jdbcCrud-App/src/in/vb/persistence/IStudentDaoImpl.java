package in.vb.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.vb.dto.Student;
import in.vb.jdbcUtility.JDBCUtility;
//write persistence logic using JDBC 

public class IStudentDaoImpl implements IStudentDao {
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		String sqlInsertQuery = "insert into student(name,age,address) values(?,?,?)";
		try {
			connection = JDBCUtility.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
				if (pstmt != null) {
					pstmt.setString(1, sname);
					pstmt.setInt(2, sage);
					pstmt.setString(3, saddress);
					int rowAffected = pstmt.executeUpdate();
					if (rowAffected == 1) {
						return "success";
					}
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		try {
			JDBCUtility.closeResources(connection, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Student seachStudent(Integer sid) {
		String sqlSelectQuery = "select id,name,age,address from student where id=?";
		Student std = null;
		try {
			connection = JDBCUtility.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
				if (pstmt != null) {
					pstmt.setInt(1, sid);
					rs = pstmt.executeQuery();
					if (rs != null) {
						if (rs.next()) {
							std = new Student();
							// copy ResultSet Data in Student Object
							std.setSid(rs.getInt(1));
							std.setSname(rs.getString(2));
							std.setSage(rs.getInt(3));
							std.setSaddress(rs.getString(4));
							return std;
						}
					}

				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		try {
			JDBCUtility.closeResources(connection, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		String sqlUpdateQuery = "UPDATE student SET name=?, age=?, address=? WHERE id=?";
		try {
			connection = JDBCUtility.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
				if (pstmt != null) {
					pstmt.setString(1, sname);
					pstmt.setInt(2, sage);
					pstmt.setString(3, saddress);
					pstmt.setInt(4, sid);
					int rowsAffected = pstmt.executeUpdate();
					if (rowsAffected == 1) {
						return "success";
					}
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		try {
			JDBCUtility.closeResources(connection, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String deleteStudent(Integer sid) {
		String sqlDeleteQuery = "delete from student where id=?";
		Student std = null;
		try {
			connection = JDBCUtility.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlDeleteQuery);
				if (pstmt != null) {
					pstmt.setInt(1, sid);
					int rowaffected = pstmt.executeUpdate();
					if (rowaffected == 1) {
						return "success";
					}
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		try {
			JDBCUtility.closeResources(connection, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

}
