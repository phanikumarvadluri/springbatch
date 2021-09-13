package com.batch.springbatchexample;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DbWriter implements ItemWriter<Users>{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void write(List<? extends Users> items) throws Exception {
		userRepository.saveAll(items);
	}

}
