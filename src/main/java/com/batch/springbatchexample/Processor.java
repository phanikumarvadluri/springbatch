package com.batch.springbatchexample;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class Processor implements ItemProcessor<Users, Users> {

	private static final Map<String, String> DEPT_NAMES = new HashMap<>();

	public Processor() {
		DEPT_NAMES.put("001", "Technical");
		DEPT_NAMES.put("002", "Operations");
		DEPT_NAMES.put("003", "Accounts");
	}

	@Override
	public Users process(Users item) throws Exception {

		String deptCode = item.getDept();

		String stringValue = DEPT_NAMES.get(deptCode);
		item.setDept(stringValue);
		item.setTime(new Date());
		return item;
	}

}
