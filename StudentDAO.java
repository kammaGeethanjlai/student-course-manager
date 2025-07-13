
	import java.sql.*;
	import java.util.*;

	public class StudentDAO {
	    Connection conn = DBConnection.getConnection();

	    public void addStudent(Student student) {
	        try {
	            String sql = "INSERT INTO students(name, course, email) VALUES (?, ?, ?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, student.getName());
	            ps.setString(2, student.getCourse());
	            ps.setString(3, student.getEmail());
	            ps.executeUpdate();
	            System.out.println("Student added successfully!");
	        } catch (Exception e) {
	            System.out.println("Error adding student: " + e.getMessage());
	        }
	    }

	    public List<Student> getAllStudents() {
	        List<Student> list = new ArrayList<>();
	        try {
	            String sql = "SELECT * FROM students";
	            Statement st = conn.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            while (rs.next()) {
	                Student s = new Student(
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getString("course"),
	                    rs.getString("email")
	                );
	                list.add(s);
	            }
	        } catch (Exception e) {
	            System.out.println("Error fetching students: " + e.getMessage());
	        }
	        return list;
	    }

	    public void updateStudent(Student student) {
	        try {
	            String sql = "UPDATE students SET name=?, course=?, email=? WHERE id=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, student.getName());
	            ps.setString(2, student.getCourse());
	            ps.setString(3, student.getEmail());
	            ps.setInt(4, student.getId());
	            ps.executeUpdate();
	            System.out.println("Student updated successfully!");
	        } catch (Exception e) {
	            System.out.println("Error updating student: " + e.getMessage());
	        }
	    }

	    public void deleteStudent(int id) {
	        try {
	            String sql = "DELETE FROM students WHERE id=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, id);
	            ps.executeUpdate();
	            System.out.println("Student deleted successfully!");
	        } catch (Exception e) {
	            System.out.println("Error deleting student: " + e.getMessage());
	        }
	    }
	}


