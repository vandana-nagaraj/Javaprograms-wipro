package com.wipro.studentmanaagment;


import com.wipro.service.StudentDaoImpl;


public class StudentApp {

	public static void main(String[] args) {
		
		StudentDaoImpl stud = new StudentDaoImpl();
	
		stud.addStudent();
		stud.viewStudent();
	}

}
