package com.test.soccergame.service;

import com.test.soccergame.client.StandingApiClient;
import com.test.soccergame.client.response.RawResponseData;
import com.test.soccergame.dao.StandingsRecordDao;
import com.test.soccergame.dto.TeamStandingsResponseDto;
import com.test.soccergame.entity.TeamStandings;
import com.test.soccergame.filter.SearchFilter;
import com.test.soccergame.mapper.TeamStandingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class StandingService implements IStandingService{
    @Autowired
    private StandingApiClient standingApiClient;
    @Autowired
    private StandingsRecordDao standingsRecordDao;
    @Autowired
    private TeamStandingsMapper teamStandingsMapper;
    @Autowired
    private SearchFilter searchFilter;
    @Override
    public List<TeamStandingsResponseDto> fetchTeamStanding(String country,
                                                            String league,
                                                            String team,
                                                            boolean forceReload) {
        if(forceReload){
            loadTeamStandingData();
        }
        Set<TeamStandings> teamStandings = standingsRecordDao.getAll();
        List<TeamStandings> teamStandingsFilteredList = searchFilter.filter(country, league,
                                                                            team, teamStandings);
        return teamStandingsMapper.toTeamStandings(teamStandingsFilteredList);
    }

    @Override
    public void loadTeamStandingData(){
        RawResponseData[] rawResponseData = standingApiClient.loadData();
        if(rawResponseData != null && rawResponseData.length>0){
            Set<TeamStandings> teamStandingsList = teamStandingsMapper.
                    toTeamStandingsEntity(Arrays.asList(rawResponseData));
            standingsRecordDao.save(teamStandingsList);
        }
    }
}