/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.mongo.service;

import ec.edu.espe.distribuidas.examen.zuniga.mongo.dao.ATMRepository;
import ec.edu.espe.distribuidas.examen.zuniga.mongo.dao.ConsolidadoRepository;
import ec.edu.espe.distribuidas.examen.zuniga.mongo.dao.TransaccionRepository;
import ec.edu.espe.distribuidas.examen.zuniga.mongo.exception.CreateException;
import ec.edu.espe.distribuidas.examen.zuniga.mongo.model.ATM;
import ec.edu.espe.distribuidas.examen.zuniga.mongo.model.Consolidado;
import ec.edu.espe.distribuidas.examen.zuniga.mongo.model.Transaccion;
import java.util.Date;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
@Slf4j
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final ATMRepository cajeroRepository;

    public TransaccionService(TransaccionRepository transaccionRepository, ATMRepository cajeroRepository) {
        this.transaccionRepository = transaccionRepository;
        this.cajeroRepository = cajeroRepository;
    }

    public Transaccion createTransaccion(Transaccion transaccion) {
        Optional<ATM> transaccionOpt = this.cajeroRepository.findById(transaccion.getIdCajero());
        if (transaccionOpt.isPresent()) {
            Date fechaTransaccion = new Date();
            transaccion.setEstado("PEN");
            transaccion.setTimestamp(fechaTransaccion);
            return this.transaccionRepository.save(transaccion);
        } else {
            StringBuilder sbMsg = new StringBuilder("The CAJERO with code: ");
            sbMsg.append(transaccion.getIdCajero());
            sbMsg.append(" does not exists in the database");
            throw new CreateException(sbMsg.toString());
        }
    }

}
