/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.batch.config;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
@Slf4j
@ToString
public class ApplicationValues {
    
    private final String configFile;
    private final String dataPath;
    
    @Autowired
    public ApplicationValues(@Value("${registrocivil.config.file}") String configFile,
            @Value("${registrocivil.config.dataPath}") String dataPath)
    {
        this.configFile = configFile;
        this.dataPath = dataPath;
        log.info("Propiedades cargadas: " + this.toString());
    }

    public static Logger getLog() {
        return log;
    }

    public String getConfigFile() {
        return configFile;
    }

    public String getDataPath() {
        return dataPath;
    }
    
}
