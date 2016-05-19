/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deivydas.voroneckis.housingservice.rest.controller;

import com.deivydas.voroneckis.domain.Room;
import com.deivydas.voroneckis.service.IHousingFacade;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vdeiv
 */
@RestController
@RequestMapping("/rooms")
public class RoomRestController {

    @Autowired
    IHousingFacade facade;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addRoom(@RequestBody Room room) {
        facade.addRoom((Room) room);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Room> getRooms() {
        return facade.getRoomsList();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Room getRoom(@PathVariable long id) {
        return facade.getRoom(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateRoom(@RequestBody Room room) {
        facade.updateRoom(room);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRoom(@RequestBody Room room) {
        facade.removeRoom(facade.getRoom(room.getId()));
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addRoom(@RequestBody List<Room> rooms) {
        for (Room room : rooms) {
            facade.addRoom((Room) room);
        }
    }
}
