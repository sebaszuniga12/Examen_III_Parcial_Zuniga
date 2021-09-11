/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.mongo.controller;

import ec.edu.espe.distribuidas.examen.zuniga.mongo.model.Consolidado;
import ec.edu.espe.distribuidas.examen.zuniga.mongo.service.ConsolidadoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebas
 */
@RestController
@Slf4j
@RequestMapping("/v1/consolidado/")
public class ConsolidadoController {
     private final ConsolidadoService service;

    public ConsolidadoController(ConsolidadoService service) {
        this.service = service;
    }
     
    
    @GetMapping(value = "{codigo}")
    @ApiOperation(value = "Obtener informacion de cajero por su código")
    public ResponseEntity obtenerPorCodigo(@PathVariable("codigo") String codigo) {
        try {
            Consolidado consolidado = this.service.obtainByCodigo(codigo);
            //RutaRS response = RutaRSTransform.buildRutaRSComplete(ruta);
            return ResponseEntity.ok(consolidado);
        } catch (Exception e) {
            //TODO: Enviar clase personalizada
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping(value = "monto/{montoDisponible}")
    @ApiOperation(value = "Obtiene los cajeros que tienen un monto menor al ingeresado")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK, Cuando encuentra cajeros"),
        @ApiResponse(code = 404, message = "No existe los cajeros")
    })
      public ResponseEntity obtenerPorMontoDisponible(
            @PathVariable("montoDisponible") BigDecimal montoDisponible) {
        List<Consolidado> cuentas = this.service.obtainByMontoDisponible(montoDisponible);
        return ResponseEntity.ok(cuentas);
    }
}
