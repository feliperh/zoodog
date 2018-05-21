/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ingereq.zoodog.rest;

import co.edu.usa.ingereq.zoodog.dto.ComentarioDTO;
import co.edu.usa.ingereq.zoodog.facade.ComentarioFacade;
import co.edu.usa.ingereq.zoodog.facade.DogFacade;
import co.edu.usa.ingereq.zoodog.jpa.Comentario;
import co.edu.usa.ingereq.zoodog.jpa.Dog;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author felip
 */
@Path("/comentario")
public class ServicioComentario {
     ComentarioFacade comentarioFacade;
     DogFacade dogFacade;
public ServicioComentario() {
        comentarioFacade = new ComentarioFacade();
}

@GET
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public List<ComentarioDTO> getComentarios_JSON() {

List<ComentarioDTO> comentarioDTO = new ArrayList<ComentarioDTO>();
      
        List<Comentario> comentarios = comentarioFacade.findAll();
        for (Comentario comentario : comentarios) {
            ComentarioDTO dto = new ComentarioDTO();
            dto.setAutor(comentario.getAutor());
            dto.setFecha(comentario.getFecha());
            dto.setComentario(comentario.getComentario());
           
            comentarioDTO.add(dto);
        }

        return comentarioDTO;
}
@POST
    @Path("/add")
    public Response crearComentario(@FormParam("autor") String nombre,
            @FormParam("comentario") String comentario) {

        Comentario co = new Comentario();
        co.setAutor(nombre);
        co.setComentario(comentario);

        comentarioFacade.save(co);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
