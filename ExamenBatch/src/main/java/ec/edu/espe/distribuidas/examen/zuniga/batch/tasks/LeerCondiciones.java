/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.batch.tasks;

import ec.edu.espe.distribuidas.examen.zuniga.batch.config.ApplicationValues;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

/**
 *
 * @author Admin
 */
@Slf4j
public class LeerCondiciones implements Tasklet, StepExecutionListener{
    
    private final ApplicationValues applicationValues;

    public LeerCondiciones(ApplicationValues applicationValues) {
        this.applicationValues = applicationValues;
    }

    @Override
    public void beforeStep(StepExecution se) {
        log.info("Preparando motores");
    }
    
    @Override
    public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {
        log.info("Va a ejecutar la tarea leer condiciones");
        log.info("El archivo con condiciones es: {}", this.applicationValues.getConfigFile());
        Properties props = new Properties();
        
        try {
            Path path = Path.of(this.applicationValues.getConfigFile());
            props.load(new FileInputStream(this.applicationValues.getConfigFile()));
            Integer personas;
            
            try {
                personas = Integer.parseInt(props.getProperty("personas"));
                log.info("Va a generar {} personas", personas);
                ExecutionContext jobContext = cc.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
                jobContext.put("records", personas);
            } catch (NumberFormatException e) {
                log.error("Invalid value for personas");
            }

        } catch (IOException e) {
            log.error("Propertie file does not exists");
        }

        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution se) {
        log.info("Finalizo la ejecucion");
        return ExitStatus.COMPLETED;
    }
}
