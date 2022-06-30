package com.test.soccergame.service;

import com.test.soccergame.dto.TeamStandingsResponseDto;

import java.util.List;

public interface IStandingService {

    List<TeamStandingsResponseDto> fetchTeamStanding(String country,
                                                     String league,
                                                     String team,
                                                     boolean forceReload);

    void loadTeamStandingData();
}
