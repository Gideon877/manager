package com.xib.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AgentController {
    @Autowired
    private AgentService agentService;

    @CrossOrigin
    @GetMapping("/agents")
    public ResponseEntity<List<Agent>> getAllAgent() {
        return ResponseEntity.ok().body(agentService.getAllAgent());
    }

    @CrossOrigin
    @GetMapping("/agent/{id}")
    public ResponseEntity<Agent> findAgent(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(agentService.getAgentById(id));
    }

    @CrossOrigin
    @PostMapping("/agent")
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent, @Valid Team team) {
        return ResponseEntity.ok().body(this.agentService.createAgent(agent));
    }

    @PutMapping("/agent/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable long id, Agent agent) {
        agent.setId(id);
        return ResponseEntity.ok().body(this.agentService.updateAgent(agent));
    }

    @DeleteMapping("/agent/{id}")
    public ResponseEntity<?> deleteAgent(@PathVariable long id) {
        this.agentService.deleteAgent(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }

}
