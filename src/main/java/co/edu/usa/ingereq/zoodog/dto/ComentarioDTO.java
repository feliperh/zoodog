/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ingereq.zoodog.dto;

import java.sql.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author felip
 */
@XmlRootElement(name = "comentarios")
@XmlAccessorType(XmlAccessType.FIELD)
public class ComentarioDTO {
    private String autor;
    private Date fecha;
    private String comentario;
}
