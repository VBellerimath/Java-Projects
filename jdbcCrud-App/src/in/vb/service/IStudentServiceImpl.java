package in.vb.service;

import in.vb.daoFactory.StudentDaoFactory;

import in.vb.dto.Student;
import in.vb.serviceFactory.StudentServiceFactory;
import in.vb.persistence.IStudentDao;

//service layer logic
public class IStudentServiceImpl implements IStudentService {
	private IStudentDao stdDao;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdDao = StudentDaoFactory.getIStudentDao();
		return stdDao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student seachStudent(Integer sid) {
		stdDao = StudentDaoFactory.getIStudentDao();
		return stdDao.seachStudent(sid);
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		stdDao = StudentDaoFactory.getIStudentDao();
		return stdDao.updateStudent(sid, sname, sage, saddress);
	}

	@Override
	public String deleteStudent(Integer sid) {
		stdDao = StudentDaoFactory.getIStudentDao();
		return stdDao.deleteStudent(sid);
	}

}
