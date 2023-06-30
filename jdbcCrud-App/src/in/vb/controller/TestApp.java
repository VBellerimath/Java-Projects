package in.vb.controller;

import java.util.Scanner;

import in.vb.dto.Student;
import in.vb.serviceFactory.StudentServiceFactory;
import in.vb.service.IStudentService;

public class TestApp {
	static Scanner sc;
	public static void main(String[] args) {
		boolean session = true;
		System.out.println("welcome to student management application...");
		while (session) {
			System.out.println("please enter to choose the operation => 1.insert the student data");
			System.out.println("                                     => 2.search the student data");
			System.out.println("                                     => 3.update the student data");
			System.out.println("                                     => 4.delete the student data");
			sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch (option) {
			case 1:
				insertOperation();
				break;
			case 2:
				selectOperation();
				break;
			case 3:
				updateOperation();
				break;
			case 4:
				deleteOperation();
				break;
			default:
				System.out.println("enter the valid input");
				break;
			}

		}
		sc.close();
	}

	public static void insertOperation() {
		// Similar to Connection con=DriverManager.getConnection(url,username,password);
		IStudentService studentService = StudentServiceFactory.getStudentService();
		sc = new Scanner(System.in);
		System.out.println("please enter the student name :: ");
		String sname = sc.next();
		System.out.println("please enter the student age :: ");
		int sage = sc.nextInt();
		System.out.println("please enter the student address :: ");
		String saddress = sc.next();

		String msg = studentService.addStudent(sname, sage, saddress);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted successfully");
		} else {
			System.out.println("record not insertion failed");
		}

	}

	public static void selectOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		sc = new Scanner(System.in);
		System.out.println("please enter the student id :: ");
		int sid = sc.nextInt();
		Student std = studentService.seachStudent(sid);
		if (std != null) {
			System.out.println(std);
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
			System.out.println(std.getSid() + "\t" + std.getSname() + "\t" + std.getSage() + "\t" + std.getSaddress());
		}

	}

	public static void deleteOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		sc = new Scanner(System.in);
		System.out.println("please enter the student id :: ");
		int id = sc.nextInt();
		String msg = studentService.deleteStudent(id);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record deleted successfully");
		} else {
			System.out.println("record deletion failed");
		}
	}

	public static void updateOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		sc = new Scanner(System.in);
		System.out.println("please enter the student id where u want change details  :: ");
		int sid = sc.nextInt();
		System.out.println("please enter the student name :: ");
		String sname = sc.next();
		System.out.println("please enter the student age :: ");
		int sage = sc.nextInt();
		System.out.println("please enter the student address :: ");
		String saddress = sc.next();
		String msg = studentService.updateStudent(sid, sname, sage, saddress);
		;
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record updated successfully");
		} else {
			System.out.println("record upadation failed");
		}
	}

}
