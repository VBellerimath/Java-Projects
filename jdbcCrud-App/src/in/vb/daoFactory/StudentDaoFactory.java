package in.vb.daoFactory;

import in.vb.persistence.IStudentDao;

import in.vb.persistence.IStudentDaoImpl;

public class StudentDaoFactory {
	// private to avoid object creation
	private StudentDaoFactory() {

	}

	private static IStudentDao studentDao = null;

	public static IStudentDao getIStudentDao() {
		if (studentDao == null) {
			studentDao = new IStudentDaoImpl();
		}
		return studentDao;
	}
}
