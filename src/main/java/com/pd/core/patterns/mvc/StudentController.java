package com.pd.core.patterns.mvc;

/**
 *
 * Create Controller.
 * 
 * 
 *
 */
public class StudentController {
    private final Student model;
    private final StudentView view;

    public StudentController(final Student model, final StudentView view) {
	this.model = model;
	this.view = view;
    }

    public void setStudentName(final String name) {
	model.setName(name);
    }

    public String getStudentName() {
	return model.getName();
    }

    public void setStudentRollNo(final String rollNo) {
	model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
	return model.getRollNo();
    }

    public void updateView() {
	view.printStudentDetails(model.getName(), model.getRollNo());
    }
}
