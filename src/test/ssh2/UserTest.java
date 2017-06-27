package ssh2;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mashen.dao.IUserDao;
import com.mashen.model.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-web.xml"})
public class UserTest {
	@Resource(name="userDaoImpl")
	IUserDao userDao;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test1() {
		User user = new User();
		user.setUsername("zongxing");
		user.setPassword("123");
		userDao.add(user);
	}
	@Test
	public void test2() {
		User user = new User();
		user.setUsername("zongxing");
		user.setPassword("123");
		userDao.getUserList();
	}

}
