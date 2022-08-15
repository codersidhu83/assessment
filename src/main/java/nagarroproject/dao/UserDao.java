package nagarroproject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import nagarroproject.model.User;

@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int saveUser(User user) {

		Integer id = (Integer) hibernateTemplate.save(user);
		return id;
	}

	// login authentication
	@SuppressWarnings({ "unchecked", "deprecation" })
	public boolean findUser(String uemail, String upwd) {
		boolean isValidUser = false;
		String sqlQuery = "from User u where u.email=?0 and u.password=?1";
		List userObj = (List) hibernateTemplate.find(sqlQuery, uemail, upwd);

		if (userObj != null && userObj.size() > 0)
			isValidUser = true;

		return isValidUser;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
