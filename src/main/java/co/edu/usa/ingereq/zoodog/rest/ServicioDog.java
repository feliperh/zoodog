/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ingereq.zoodog.rest;

import co.edu.usa.ingereq.zoodog.dto.DogDTO;
import co.edu.usa.ingereq.zoodog.facade.DogFacade;
import co.edu.usa.ingereq.zoodog.jpa.Dog;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author felip
 */
@Path("/dog")
public class ServicioDog {
    DogFacade dogfacade;

public ServicioDog() {
        dogfacade = new DogFacade();
}

@GET
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public List<DogDTO> getDogs_JSON() {
   List<DogDTO> dogDTO = new ArrayList<DogDTO>();
      
        List<Dog> dogs = dogfacade.findAll();
        for (Dog dog : dogs) {
            DogDTO dto = new DogDTO();
            dto.setName(dog.getName());
            dto.setGro(dog.getGro());
            dto.setEnergylevel(dog.getEnergylevel());
            dto.setPersonality(dog.getPersonality());
            dto.setDescription(dog.getDescription());
            dto.setImage(dog.getImage());
            dogDTO.add(dto);
        }

        return dogDTO;
}

@GET
@Path("/{usrNo}")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public Dog getUsuario(@PathParam("usrNo") int usrNo) {
    return dogfacade.get(usrNo);
}

}