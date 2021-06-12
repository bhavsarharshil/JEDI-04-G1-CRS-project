package com.flipkart.DAO;

import com.flipkart.bean.Professor;

public interface ProfessorDAOInterface {
	public Professor getProfessorById(int id);
	public String getProfessorByIdName(int professorID);
}
