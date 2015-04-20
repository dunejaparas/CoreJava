package com.pd.core.patterns.mvc;

/**
 *
 * Use the StudentController methods to demonstrate MVC design pattern usage.
 * 
 * 
 *
 */
public class MVCPatternDemo {
    public static void main(final String[] args) {

	// fetch student record based on his roll no from the database
	final Student model = retriveStudentFromDatabase();

	// Create a view : to write student details on console
	final StudentView view = new StudentView();

	final StudentController controller = new StudentController(model, view);

	controller.updateView();

	// update model data
	controller.setStudentName("John");

	controller.updateView();
    }

    private static Student retriveStudentFromDatabase() {
	final Student student = new Student();
	student.setName("Robert");
	student.setRollNo("10");
	return student;
    }
}
