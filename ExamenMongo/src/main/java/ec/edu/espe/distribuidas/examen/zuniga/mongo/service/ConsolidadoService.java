/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.mongo.service;

import ec.edu.espe.distribuidas.examen.zuniga.mongo.dao.ConsolidadoRepository;
import ec.edu.espe.distribuidas.examen.zuniga.mongo.model.Consolidado;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
@Slf4j
public class ConsolidadoService {

    private final ConsolidadoRepository consolidadoRepository;

    public ConsolidadoService(ConsolidadoRepository consolidadoRepository) {
        this.consolidadoRepository = consolidadoRepository;
    }

    public Consolidado obtainByCodigo(String codigo) {
        List<Consolidado> consolidadoOpt = this.consolidadoRepository.findByIdCajero(codigo);
        if (!consolidadoOpt.isEmpty()) {
            return consolidadoOpt.get(consolidadoOpt.size()-1);
        } else {
            throw new RuntimeException("Not found");
        }
    }

    public List<Consolidado> obtainByMontoDisponible(
            BigDecimal montoDisponible) {
        return this.consolidadoRepository
                .findByMontoDisponible(montoDisponible);
    }
    
    /*
    public List<Consolidado> obtainAll(
            List<Consolidado> lista){
          return this.consolidadoRepository
                .findByMontoDisponible(montoDisponible);
    }
*/
    
        
     
    }

    
 
}
    
    


