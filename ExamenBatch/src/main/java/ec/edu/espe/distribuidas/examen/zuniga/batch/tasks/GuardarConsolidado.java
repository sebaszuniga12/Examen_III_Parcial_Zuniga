/*
 * Copyright (c) 2021 sebas.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    sebas - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.distribuidas.examen.zuniga.batch.tasks;

import ec.edu.espe.distribuidas.examen.zuniga.batch.config.ApplicationValues;
import ec.edu.espe.distribuidas.examen.zuniga.batch.model.Transaccion;
import java.util.ArrayList;
import java.util.List;
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

/**
 *
 * @author sebas
 */
@Slf4j
public class GuardarConsolidado  implements Tasklet, StepExecutionListener {

    private final ApplicationValues applicationValues;
    private final MongoTemplate mongoTemplate;
    List<Transaccion> transacciones = new ArrayList<>();

    public GuardarConsolidado(ApplicationValues applicationValues, MongoTemplate mongoTemplate) {
        this.applicationValues = applicationValues;
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public void beforeStep(StepExecution se) {
             ExecutionContext sc = se.getJobExecution().getExecutionContext();
            this.transacciones = (List) sc.get("transacciones");
    }

  

    @Override
    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
          for(int i=0;i<=this.transacciones.size();i++){
              
                  
              }
          
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
    }
        
    @Override
    public ExitStatus afterStep(StepExecution arg0) {
       return ExitStatus.COMPLETED;
    }
    

}
