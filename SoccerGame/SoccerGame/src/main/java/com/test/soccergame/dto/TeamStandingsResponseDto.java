package com.test.soccergame.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamStandingsResponseDto {

    private String country;
    private String team;
    private String league;
    private Integer overallLeaguePosition;
    private Integer leagueId;
}