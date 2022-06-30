package com.test.soccergame.controller;

import com.test.soccergame.dto.TeamStandingsResponseDto;
import com.test.soccergame.service.IStandingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Get Team standings")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
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