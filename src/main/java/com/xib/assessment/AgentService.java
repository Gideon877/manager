package com.xib.assessment;

import com.xib.assessment.Agent;

import java.util.List;

public interface AgentService {

    Agent createAgent(Agent agent);

    Agent updateAgent(Agent agent);

    List<Agent> getAllAgent();

    Agent getAgentById(long agentId);

    void deleteAgent(long id);
}
