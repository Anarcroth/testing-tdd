package tdd.logic.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

	@Mock
	private UserDAO userDAO;

	@Mock
	private SecurityService securityService;

	@Mock
	private User user;

	@BeforeEach
	void setup() {

		MockitoAnnotations.openMocks(this);
	}

	@Test
	void assignPassword() throws Exception {

		UserServiceImpl service = new UserServiceImpl(userDAO, securityService);

		when(user.getPassword()).thenReturn("1234");
		when(securityService.md5(user.getPassword())).thenReturn("abcd");

		service.assignPassword(user);

		verify(user).setPassword(anyString());
		verify(securityService).md5(anyString());
		verify(userDAO).updateUser(any(User.class));
	}
}
