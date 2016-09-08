package br.com.timetrialfactory.maestro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.timetrialfactory.maestro.daos.UserDAO;
import br.com.timetrialfactory.maestro.models.User;
import br.com.timetrialfactory.maestro.models.enums.RoleType;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public User findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public boolean saveUser(User user) {
		if (dao.checkUser(user)) {
			user.setRole(RoleType.GENERIC);
			dao.saveUser(user);
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	@Override
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if (entity != null) {
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setAddress(user.getAddress());
			entity.setEmail(user.getEmail());
			entity.setPassword(user.getPassword());
		}
	}

	@Override
	public User loadUser(String login, String password) {
		return dao.getUserByLoginAndPassword(login, password);
	}

}