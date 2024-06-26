package de.codingmak.learning.controllers;

import de.codingmak.learning.exceptions.NotFoundException;
import de.codingmak.learning.models.House;
import de.codingmak.learning.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
public class HouseController {
    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public List<House> getAllHouses() {
        return houseService.getHouseList();
    }

    @GetMapping(params = "name")
    public List<House> getHouseByName(@RequestParam(name = "name") String name) {
        return houseService.getHouseByName(name);
    }

    @GetMapping(params = "member")
    public List<House> getHouseByMember(@RequestParam(name = "member") String member) {
        return houseService.getHouseByMember(member);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleHouseNotFoundException(NotFoundException.HouseNotFoundException e) {
        return e.getMessage();
    }
}
