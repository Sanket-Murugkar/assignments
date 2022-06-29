package com.test.soccergame.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamStandingsResponseDto {

    private String countryName;
    private String teamName;
    private String leagueName;
    private Integer overallLeaguePosition;
    private Integer leagueId;
}
