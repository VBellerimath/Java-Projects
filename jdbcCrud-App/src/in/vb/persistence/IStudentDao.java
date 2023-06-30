package in.vb.persistence;

import in.vb.dto.Student;

public interface IStudentDao {
// operations to be implemented 
	// create operation
	public String addStudent(String sname, Integer sage, String saddress);

	// read operation
	public Student seachStudent(Integer sid);

	// update operation
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress);

	// delete operation
	public String deleteStudent(Integer sid);
}
