package com.springjdbcone;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ContactMapper implements RowMapper<Contact> {
	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {

		Contact c = new Contact();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setCellno(rs.getString("cellno"));
		return c;

	}

}
