/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.mongo.dao;

import ec.edu.espe.distribuidas.examen.zuniga.mongo.model.Transaccion;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author sebas
 */
public interface TransaccionRepository extends MongoRepository<Transaccion, String>{
    
}