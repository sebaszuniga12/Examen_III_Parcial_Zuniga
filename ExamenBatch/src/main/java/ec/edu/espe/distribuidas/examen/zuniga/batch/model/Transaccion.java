/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.batch.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author sebas
 */
@Data
public class Transaccion {
    @Id
    private String id;
    private String idCajero;
    private BigDecimal monto;
    private Integer billetes10;
    private Integer billetes20;
    private Date timestamp;
    private String estado;
    private String tipo;
}
