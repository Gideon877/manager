package com.xib.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @CrossOrigin
    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAllTeams() {
        return  ResponseEntity.ok().body(teamService.getAllTeams());
    }

    @CrossOrigin
    @GetMapping("/team/{id}")
    public ResponseEntity<Team> findTeam(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(teamService.getTeamById(id));
    }

    @CrossOrigin
    @PostMapping("/team")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        return ResponseEntity.ok().body(teamService.createTeam(team));
    }

    @CrossOrigin
    @DeleteMapping("/team/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable long id) {
        this.teamService.deleteTeam(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
