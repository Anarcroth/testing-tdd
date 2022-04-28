package tdd.logic.user;

public class UserServiceImpl {

	private final UserDAO userDAO;
	private final SecurityService securityService;

	public UserServiceImpl(UserDAO dao, SecurityService securityService) {

		this.userDAO = dao;
		this.securityService = securityService;
	}

	public void assignPassword(User user) throws Exception {

		String passwordMd5 = securityService.md5(user.getPassword());
		user.setPassword(passwordMd5);
		userDAO.updateUser(user);
	}
}
