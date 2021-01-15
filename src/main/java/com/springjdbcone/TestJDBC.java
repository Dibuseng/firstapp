package com.springjdbcone;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJDBC {

	public static void save(Contact c) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
		String sql = "insert into contacts(name,email,cellno) values(?,?,?)";
		Object params[] = { c.getName(), c.getEmail(), c.getCellno() };
		int n = jdbcTemplate.update(sql, params);
		System.out.println(n + " records(s) inserted..");
		context.close();
		context.registerShutdownHook();

	}

	public static void findAll() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
		String sql = "select * from contacts";
		// List<Contact> contacts = jdbcTemplate.query(sql, new
		// BeanPropertyRowMapper<Contact>(Contact.class));
		List<Contact> contacts = jdbcTemplate.query(sql, new ContactMapper());
		for (Contact c : contacts) {
			System.out.println(c.getId() + " : " + c.getName() + " : " + c.getEmail() + " : " + c.getCellno());
		}
		context.close();
		context.registerShutdownHook();

	}

	public static void findById(int id) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
		String sql = "select * from contacts where id = ?";
		Object params[] = { id };
		Contact c = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Contact>(Contact.class), params);
		System.out.println(c.getId() + " : " + c.getName() + " : " + c.getEmail() + " : " + c.getCellno());
		context.close();
		context.registerShutdownHook();

	}

	public static void main(String[] args) {

		// findAll();
		// findById(3);
		Contact c = new Contact();
		c.setName("Chalres");
		c.setEmail("charles@gmail.com");
		c.setCellno("9988779876");
		save(c);
	}

}
