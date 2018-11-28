package com.spo.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import org.junit.Assert;

public class WorkforceControllerTest {

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
