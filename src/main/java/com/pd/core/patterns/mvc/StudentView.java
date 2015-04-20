package com.pd.core.patterns.mvc;

/**
 *
 * Create View.
 *
 */
public class StudentView {
    public void printStudentDetails(final String studentName, final String studentRollNo) {
	System.out.println("Student: ");
	System.out.println("Name: " + studentName);
	System.out.println("Roll No: " + studentRollNo);
    }
}
