/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.mongo.controller;

import ec.edu.espe.distribuidas.examen.zuniga.mongo.dto.TransaccionRQ;
import ec.edu.espe.distribuidas.examen.zuniga.mongo.model.Transaccion;
import ec.edu.espe.distribuidas.examen.zuniga.mongo.service.TransaccionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebas
 */
@RestController
@Slf4j
@RequestMapping("/v1/transaccion/")
public class TransaccionController {

    private final TransaccionService service;

    public TransaccionController(TransaccionService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation(value = "Crear una transaccion")
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Cuando se crea una transferencia de acuerdo a los datos enviados"),
            @ApiResponse(code = 400,
                    message = "Cuando no se puede crear una transferencia con los datos enviados")
    })
    
    
    public ResponseEntity crearConsulta(@RequestBody TransaccionRQ transaccion) {
        try {
            log.info("Se va a crear una transaccion con la siguiente informacion: {}", transaccion);
            Transaccion transaccionNew = new Transaccion();
            transaccionNew.setIdCajero(transaccion.getIdCajero());
            transaccionNew.setMonto(transaccion.getMonto());
            transaccionNew.setBilletes10(transaccion.getBilletes10());
            transaccionNew.setBilletes20(transaccion.getBilletes20());
            transaccionNew.setTipo(transaccion.getTipo());
            this.service.createTransaccion(transaccionNew);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Ocurrio un error al crear la transaccion. {} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
