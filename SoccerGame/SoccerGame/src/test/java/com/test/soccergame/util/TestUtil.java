package com.test.soccergame.util;

import com.test.soccergame.client.response.RawResponseData;
import com.test.soccergame.entity.TeamStandings;

import java.util.HashSet;
import java.util.Set;

public class TestUtil {

    public static RawResponseData[] getRawResponseData() {
        RawResponseData[] rawResponseData = new RawResponseData[1];
        RawResponseData rawResponseData1 = new RawResponseData();
        rawResponseData1.setCountry_name("testCountry");
        rawResponseData1.setTeam_name("testTeam");
        rawResponseData1.setLeague_name("testLeagueName");
        rawResponseData1.setOverall_league_position("11");
        rawResponseData1.setHome_league_position("22");
        rawResponseData1.setAway_league_position("111");
        rawResponseData1.setLeague_id("555");
        rawResponseData[0]=rawResponseData1;
        return rawResponseData;
    }

    public static Set<TeamStandings> getTeamStandings(){
        Set<TeamStandings> standingsHashSet = new HashSet<>();
        TeamStandings standings = new TeamStandings();
        standings.setTeamName("testTeam");
        standings.setLeagueName("testLeague");
        standings.setCountryName("testCountry");
        standingsHashSet.add(standings);
        return standingsHashSet;
    }
}
