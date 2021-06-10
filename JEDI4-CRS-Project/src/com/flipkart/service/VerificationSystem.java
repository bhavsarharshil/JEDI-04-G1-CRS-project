package com.flipkart.service;

public interface VerificationSystem {
		public String loginWithCredential(String username,String password);
		public boolean registerStudent(int id, String email,String password,String name);
		public boolean registerProfessor(int id, String email,String password,String name)
}
