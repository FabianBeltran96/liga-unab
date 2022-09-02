package com.unab.services;

import com.unab.models.MatchGame;
import com.unab.models.Team;
import com.unab.models.User;
import com.unab.repositories.MatchRepository;
import com.unab.repositories.TeamRepository;
import com.unab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    private final MatchRepository matchRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;


    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<MatchGame> getMatches() {
        return matchRepository.findAll();
    }

    public MatchGame addNewMatch(MatchGame match) {
        System.out.println("match");

        System.out.println(match);
        User user = userRepository.findUserById(match.getUser().getId());
        System.out.println(user);
        Team local_team = teamRepository.findTeamById(match.getLocalTeam().getId());
        System.out.println(local_team);
        Team visitor_team = teamRepository.findTeamById(match.getVisitorTeam().getId());
        System.out.println(visitor_team);
        match.setUser(user);
        match.setVisitorTeam(visitor_team);
        match.setLocalTeam(local_team);
        System.out.println(match);
        return matchRepository.save(match);
    }
}
