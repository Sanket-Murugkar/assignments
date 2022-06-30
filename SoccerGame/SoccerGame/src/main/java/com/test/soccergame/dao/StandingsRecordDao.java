package com.test.soccergame.dao;

import com.test.soccergame.entity.TeamStandings;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class StandingsRecordDao {

    private final Set<TeamStandings> teamStandingsList = new HashSet<>();
    public void save(Set<TeamStandings> teamStandings){
        teamStandingsList.addAll(teamStandings);
    }
    public Set<TeamStandings> getAll(){
      return Collections.unmodifiableSet(teamStandingsList);
    }
}
