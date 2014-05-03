package net.javaloping.ourtaskr.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import net.javaloping.ourtaskr.business.dto.UserDTO;
import net.javaloping.ourtaskr.business.service.user.UserService;
import net.javaloping.ourtaskr.test.context.WebAppContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author victormiranda
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppContext.class})
@WebAppConfiguration
public class UserControllerTestCase {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private UserService userService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testAddUSer() throws Exception {
		String name = "Perico";
		String surname = "Palotes";
		String email = "victormirandabeltran@gmail.com";
		String password = "paco";
		String confirmationPassword = "paco";

		this.mockMvc.perform(get("/user/add")
				.param("name",name)
				.param("surname",surname)
				.param("password",password)
				.param("confirmPassword",confirmationPassword)
				.param("emailAddress",email)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(name)))
				.andExpect(jsonPath("$.surname", is(surname)))
				.andDo(print());
	}
}