package com.batch.springbatchexample;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadController {

	@Autowired
	JobLauncher jobLaunch;

	@Autowired
	Job job;

	@GetMapping
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		
		System.out.println("Loading started.....");

		Map<String, JobParameter> map = new HashMap<>();
		map.put("time", new JobParameter(System.currentTimeMillis()));

		JobParameters jobParameters = new JobParameters(map);
		JobExecution run = jobLaunch.run(job, jobParameters);
		System.out.println("Job Execution"+run);
		System.out.println(run.getStatus());

		System.out.println("Loading Ended.....");

		return run.getStatus();

	}

}
