package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserDao implements UserDao {
	
	private JdbcTemplate jdbcTemplate;
		
	@Autowired
	public JdbcUserDao(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void save(User user) {
		Long id = getNextId();
		String sqlInsertPost = "INSERT INTO users(id, firstName, lastName, userName, password) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertPost, id, user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword());
	}
	
	@Override
	public List<User> getAllUsers() {
		ArrayList<User> allUsers = new ArrayList<>();
		String sqlSelectAllUsers="SELECT * FROM users";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllUsers);
		while(results.next()) {		
			Long id = results.getLong("id");
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			String userName = results.getString("userName");
			String password = results.getString("password");
			
			allUsers.add(new User(id, firstName, lastName, userName, password));
		}
		return allUsers;
	}

	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_user_id')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if(results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next user id from sequence");
		}
		return id;
	}
	
	
}
