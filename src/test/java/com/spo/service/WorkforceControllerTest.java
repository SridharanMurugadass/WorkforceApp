package com.spo.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.Assert;
import org.junit.Before;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WorkforceAppApplication.class)
@SpringBootTest
public class WorkforceControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void task() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/data").contentType(MediaType.APPLICATION_JSON)
				.content("{ \"rooms\": [35, 21, 17], \"senior\":10, \"junior\": 6 }")
				.accept(MediaType.APPLICATION_JSON)).andDo(print());
	}

	@Test
	public void case1() {

		String expectedRes = "[{Junior=1, Senior=3}, {Junior=2, Senior=1}, {Junior=0, Senior=2}]";

		int[] rooms = new int[] { 35, 21, 17 };

		Workforce work = new Workforce();
		work.setJunior(6);
		work.setSenior(10);
		work.setRooms(rooms);

		WorkforceController workforce = new WorkforceController();
		workforce.task(work);

		List<Map<String, Integer>> actResult = workforce.task(work);

		Assert.assertEquals(actResult.toString(), expectedRes);

	}

	@Test
	public void case2() {

		String expectedRes = "[{Junior=1, Senior=2}, {Junior=1, Senior=2}]";

		int[] rooms = new int[] { 24, 28 };

		Workforce work = new Workforce();
		work.setJunior(6);
		work.setSenior(11);
		work.setRooms(rooms);

		WorkforceController workforce = new WorkforceController();
		workforce.task(work);

		List<Map<String, Integer>> actResult = workforce.task(work);

		Assert.assertEquals(actResult.toString(), expectedRes);

	}

}
