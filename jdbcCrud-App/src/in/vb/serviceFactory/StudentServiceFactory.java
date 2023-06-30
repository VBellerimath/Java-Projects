package in.vb.serviceFactory;

import in.vb.service.IStudentService;
import in.vb.service.IStudentServiceImpl;

// Abstraction logic implementation
public class StudentServiceFactory {
	private static IStudentService studentService = null;

	// make constructor private to avoid object creation
	private StudentServiceFactory() {
	}

	public static IStudentService getStudentService() {
		// singleton pattern code
		if (studentService == null) {
			studentService = new IStudentServiceImpl();
		}
		return studentService;
	}
}
