package com.xib.assessment;

import com.xib.assessment.Team;

import java.util.List;

public interface TeamService {

    Team createTeam(Team team);

    List<Team> getAllTeams();

    Team getTeamById(long teamId);

    void deleteTeam(long id);

}
