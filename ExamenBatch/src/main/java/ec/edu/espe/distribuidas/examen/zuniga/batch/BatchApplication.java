package ec.edu.espe.distribuidas.examen.zuniga.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchApplication {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("generadorConsolidado")
    Job jobs;

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

}
