/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.batch.tasks;

import ec.edu.espe.distribuidas.examen.zuniga.batch.config.ApplicationValues;
import ec.edu.espe.distribuidas.examen.zuniga.batch.model.Transaccion;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
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
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author Admin
 */
@Slf4j
public class LeerInformacion implements Tasklet, StepExecutionListener{
    
    private final ApplicationValues applicationValues;
    private final MongoTemplate mongoTemplate;

    public LeerInformacion(ApplicationValues applicationValues, MongoTemplate mongoTemplate) {
        this.applicationValues = applicationValues;
        this.mongoTemplate = mongoTemplate;
    }
    
    

    @Override
    public void beforeStep(StepExecution se) {
        log.info("Preparando informacion");
    }
    
    @Override
    public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("estado").in("PEN"));
        List<Transaccion> transacciones = mongoTemplate.find(query,Transaccion.class);
         ExecutionContext jobContext = cc.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
         jobContext.put("transacciones", transacciones);
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution se) {
        log.info("Finalizo la ejecucion");
        return ExitStatus.COMPLETED;
    }
}
