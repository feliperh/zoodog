/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ingereq.zoodog.facade;

import co.edu.usa.ingereq.zoodog.dao.ServiceImpl;
import co.edu.usa.ingereq.zoodog.dao.SingletonConnection;
import co.edu.usa.ingereq.zoodog.jpa.Comentario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author felip
 */
public class ComentarioFacade extends ServiceImpl<Comentario> {
     public ComentarioFacade() {
        super(Comentario.class);
        try {
            EntityManager em = SingletonConnection.getConnection();
            super.setEntityManager(em);
        } catch (Exception e) {
            System.out.println("Problemas en la realizacion de conexion con la base de datos\n" + e);
        }
    }

    @Override
    public List<Comentario> findAll() {
        return super.findAll();
    }
}
