package br.com.sistemas.magna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.sistemas.magna.model.Time;
import br.com.sistemas.magna.repository.TimeRepository;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeRepository teamRepository;

    @GetMapping
    public List<Time> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> getTeamById(@PathVariable Long id) {
        Time team = teamRepository.findById(id)
                                  .orElse(null);
        if (team != null) {
            return new ResponseEntity<>(team, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Time> createTeam(@RequestBody Time team) {
        try {
            Time createdTeam = teamRepository.save(team);
            return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> updateTeam(@PathVariable Long id, @RequestBody Time teamDetails) {
        Time team = teamRepository.findById(id)
                                  .orElse(null);
        if (team != null) {
            team.setNomeTime(teamDetails.getNomeTime());
            team.setNomeCentroDeTreinamento(teamDetails.getNomeCentroDeTreinamento());
            team.setNomeEstadio(teamDetails.getNomeEstadio());
            return new ResponseEntity<>(teamRepository.save(team), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Time> deleteTeam(@PathVariable Long id) {
        try {
            teamRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

