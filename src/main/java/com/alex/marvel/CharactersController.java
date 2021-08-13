package com.alex.marvel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class CharactersController {

    @Autowired
    private CharactersService charactersService;

    @RequestMapping("/characters")
    public List<Characters> getAllCharacters(){
        return charactersService.getAllCharacters();
    }

    @RequestMapping("/characters/{id}")
    public Characters getCharacter(@PathVariable String id){
        return charactersService.getCharacter(id);
    }
}

