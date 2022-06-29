package com.test.soccergame.controller;

import com.test.soccergame.dto.TeamStandingsResponseDto;
import com.test.soccergame.service.IStandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.test.soccergame.common.Constants.TEAM_STANDING_DATA_IS_LOADED_SUCCESSFULLY;

@RestController
@RequestMapping("/api/standings")
public class StandingsController {

    @Autowired
    private IStandingService iStandingService;

    @GetMapping(produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public List<TeamStandingsResponseDto> getTeamStandings(@RequestParam(name = "country",required = false) String country,
                                                           @RequestParam(name = "league",required = false) String league,
                                                           @RequestParam(name = "team",required = false) String team,
                                                           @RequestParam(name = "forceReload",required = false) boolean forceReload) {
        return iStandingService.fetchTeamStanding(country,league,team,forceReload);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String refresh() {
         iStandingService.loadTeamStandingData();
         return TEAM_STANDING_DATA_IS_LOADED_SUCCESSFULLY;
    }
}