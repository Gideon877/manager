package com.xib.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(long teamId) {
        Optional<Team> teamDb = teamRepository.findById(teamId);

        if(teamDb.isPresent()) {
            return teamDb.get();
        }

        throw new ResourceNotFoundException("Record not found with id: " + teamId);
    }

    @Override
    public void deleteTeam(long id) {
        Optional<Team> teamDb = this.teamRepository.findById(id);
        if(teamDb.isPresent()) {
            this.teamRepository.delete(teamDb.get());
        }
        throw new ResourceNotFoundException("Record not found with id: " + id);
    }
}
