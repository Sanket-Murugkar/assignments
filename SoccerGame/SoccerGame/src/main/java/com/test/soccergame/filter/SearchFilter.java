package com.test.soccergame.filter;

import com.test.soccergame.entity.TeamStandings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class SearchFilter {
    public List<TeamStandings> filter(String countryName,
                                      String leagueName,
                                      String teamName ,
                                      Set<TeamStandings> inputList){
        return inputList.stream().
                filter(countryPredicate(countryName).
                        and(leaguePredicate(leagueName).
                                and(teamPredicate(teamName)))).
                collect(Collectors.toList());
    }

    private  Predicate<TeamStandings> countryPredicate(String countryName) {
        return teamStandings-> StringUtils.equals(countryName, teamStandings.getCountryName());
    }

    private  Predicate<TeamStandings> leaguePredicate(String leagueName) {
        return teamStandings-> StringUtils.equals(leagueName, teamStandings.getLeagueName());
    }
    private  Predicate<TeamStandings> teamPredicate(String teamName) {
        return teamStandings-> StringUtils.equals(teamName, teamStandings.getTeamName());
    }
}