package com.springjdbcone;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String cellno;
 	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellno() {
		return cellno;
	}

	public void setCellno(String cellno) {
		this.cellno = cellno;
	}

}