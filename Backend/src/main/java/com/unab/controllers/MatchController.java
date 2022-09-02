package com.unab.controllers;

import com.unab.models.MatchGame;
import com.unab.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/matches")
public class MatchController {
    @Autowired
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<MatchGame> getMatches() {
        return matchService.getMatches();
    }

    @PostMapping
    public void addNewMatch(@RequestBody MatchGame match){
        System.out.println(match  + " Partido");
        matchService.addNewMatch(match);
    }
}
