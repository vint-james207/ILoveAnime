package com.james;

import com.james.services.AnimeRepository;
import com.james.services.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ILoveAnimeApplication.class)
@WebAppConfiguration
public class ILoveAnimeApplicationTests {
	@Autowired
	WebApplicationContext wap;

	@Autowired
	UserRepository users;

	@Autowired
	AnimeRepository animes;

	MockMvc mockMvc;

	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
	}



	@Test
	public void testLogin() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/login")
				.param("username", "name")
				.param("password", "password")
		);
		Assert.assertTrue(users.count() == 1);
	}

	@Test
	public  void testAddAnime() throws Exception {
		testLogin();

		mockMvc.perform(
				MockMvcRequestBuilders.post("/add-anime")
				.param("Title", "Test title")
				.param("comment", "test comment")
				.param("time", LocalDateTime.now().toString())
				.sessionAttr("username", "James")
		);
		Assert.assertTrue(animes.count() == 1);
	}
}
