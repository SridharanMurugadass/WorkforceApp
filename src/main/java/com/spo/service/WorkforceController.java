package com.spo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkforceController {

	@PostMapping("/data")
	public List<Map<String, Integer>> task(@RequestBody Workforce work) {

		List<Map<String, Integer>> result = new ArrayList<Map<String, Integer>>();

		for (int i : work.getRooms()) {
			int seniorCount = 1;
			int juniorCount = 0;
			Map<String, Integer> l = new HashMap<String, Integer>();
			int iTemp = i - work.getSenior();

			int sum = work.getSenior();
			if (iTemp % work.getSenior() > iTemp % work.getJunior()) {
				seniorCount += (iTemp / work.getSenior() == 0) ? 1 : iTemp / work.getSenior();
				sum += work.getSenior() * (seniorCount - 1);
			} else {
				juniorCount += iTemp / work.getJunior();
				sum += (work.getJunior() * juniorCount);
			}

			juniorCount += i / sum;
			l.put("Senior", seniorCount);
			l.put("Junior", juniorCount);
			result.add(l);

		}

		return result;
	}

}
