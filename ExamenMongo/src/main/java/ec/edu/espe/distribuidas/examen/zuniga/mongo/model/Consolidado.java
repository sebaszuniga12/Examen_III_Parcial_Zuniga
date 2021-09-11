/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.mongo.model;

import java.math.BigDecimal;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 *
 * @author sebas
 */
@Data
@Document(collection = "consolidado")
public class Consolidado {

    @Id
    private String id;
    private Integer billetes10;
    private Integer billetes20;
    private String idCajero;
    private BigDecimal monto;
}
