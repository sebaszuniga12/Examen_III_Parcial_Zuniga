/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.mongo.dao;

import ec.edu.espe.distribuidas.examen.zuniga.mongo.model.Consolidado;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author sebas
 */
public interface ConsolidadoRepository extends MongoRepository<Consolidado, String> {

    List<Consolidado> findByMontoDisponible(BigDecimal monto);
     List<Consolidado> findByIdCajero(String id);
}
