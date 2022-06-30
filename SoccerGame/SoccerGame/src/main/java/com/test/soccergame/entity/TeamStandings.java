package com.test.soccergame.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class TeamStandings {

    private String id;
    private String countryName;
    private String leagueName;
    private String teamName;
    private Integer overallLeaguePosition;
    private Integer homeLeaguePosition;
    private Integer awayLeaguePosition;
    private Integer leagueId;
}
