package com.mashen.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mashen.model.User;
//事务
@Transactional(rollbackFor=Exception.class)
@Repository("userDaoImpl")
public class UserDaoImpl implements IUserDao{
	RowMapper<User> rm = new RowMapper<User>() {
		
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}
	};
	@Resource(name="jdbcTemplate")
	JdbcTemplate jdbcTemplate;
	//@Transactional(noRollbackFor=RuntimeException.class)
	public void add(User user) {
		String sql = "insert into user (username,password) values('"+user.getUsername()+"','"+user.getPassword()+"')";
		String sql2 = "insert into user (username,password) values('"+user.getUsername()+"ddddddddddddddddddddddddddd','"+user.getPassword()+"')";
		jdbcTemplate.execute(sql);
		jdbcTemplate.execute(sql2);
		System.out.println(sql);
		System.out.println("add success");
	}
	public List<User> getUserList() {
		//List<User> list = jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<User>(User.class));
		List<User> list = jdbcTemplate.query("select * from user",rm);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user.getId());
		}
		return list;
	}

}
