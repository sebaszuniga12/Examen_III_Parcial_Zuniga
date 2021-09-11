/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.batch.config;

import ec.edu.espe.distribuidas.examen.zuniga.batch.tasks.GuardarConsolidado;
import ec.edu.espe.distribuidas.examen.zuniga.batch.tasks.LeerInformacion;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author Admin
 */
@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
public class JobConfig {
    
    @Autowired
    private JobBuilderFactory jobs;
    
    @Autowired
    private StepBuilderFactory steps;
    
    @Autowired
    private MongoTemplate mongotemplate;
    
    @Autowired
    private ApplicationValues applicationValues;
    
    @Bean
    protected Step leerInformacion(){
        return steps
                .get("leerInformacion")
                .tasklet(new LeerInformacion(this.applicationValues,this.mongotemplate))
                .build();
    }
    
    @Bean
    protected Step generacionConsolidado(){
        return steps
                .get("generacionConsolidado")
                .tasklet(new GuardarConsolidado(this.applicationValues,this.mongotemplate))
                .build();
    }
    
    @Bean
    public Job generadorConsolidado(){
        return jobs
                .get("leerInformacion")
                .start(leerInformacion())
                .next(generacionConsolidado())
                .build();
    }
    
}
