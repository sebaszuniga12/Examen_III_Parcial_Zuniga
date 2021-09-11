/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.mongo.dto;

import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author sebas
 */
@Data
public class TransaccionRQ {

    private String idCajero;
    private BigDecimal monto;
    private Integer billetes10;
    private Integer billetes20;
    private String tipo;

}
