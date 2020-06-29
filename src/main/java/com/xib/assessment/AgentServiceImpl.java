package com.xib.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public Agent createAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent updateAgent(Agent agent) {
        Optional<Agent> agentDb = this.agentRepository.findById(agent.getId());

        if(agentDb.isPresent()) {
            Agent agentUpdate = agentDb.get();
            agentUpdate.setId(agent.getId());
            agentUpdate.setFirstName(agent.getFirstName());
            agentUpdate.setLastName(agent.getLastName());
            agentUpdate.setIdNumber(agent.getIdNumber());
            agentRepository.save(agentUpdate);
            return agentUpdate;
        }
        throw new ResourceNotFoundException("Record not found with id: " + agent.getId());
    }

    @Override
    public List<Agent> getAllAgent() {
        return this.agentRepository.findAll();
    }

    @Override
    public Agent getAgentById(long agentId) {

        Optional<Agent> agentDb = this.agentRepository.findById(agentId);

        if(agentDb.isPresent()) {
            return agentDb.get();
        }
        throw new ResourceNotFoundException("Record not found with id: " + agentId);
    }

    @Override
    public void deleteAgent(long id) {
        Optional<Agent> agentDb = this.agentRepository.findById(id);
        if(agentDb.isPresent()) {
            this.agentRepository.delete(agentDb.get());
        }
        throw new ResourceNotFoundException("Record not found with id: " + id);
    }
}
