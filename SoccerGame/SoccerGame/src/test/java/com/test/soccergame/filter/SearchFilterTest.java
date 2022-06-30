package com.test.soccergame.filter;

import com.test.soccergame.entity.TeamStandings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Set;

import static com.test.soccergame.util.TestUtil.getTeamStandings;

@RunWith(MockitoJUnitRunner.class)
public class SearchFilterTest {

    @InjectMocks
    SearchFilter searchFilter;

    @Test
    public void shouldNotReturnResultsWhenThereIsNoMatch(){
        Set<TeamStandings> rawResponseData = getTeamStandings();
        List<TeamStandings> teamStandings = searchFilter.filter("a", "b", "c", rawResponseData);
        Assert.assertEquals(0,teamStandings.size());
    }

    @Test
    public void shouldReturnResultsWhenThereIsNoMatch(){
        Set<TeamStandings> rawResponseData = getTeamStandings();
        List<TeamStandings> teamStandings = searchFilter.filter("testCountry", "testLeague", "testTeam", rawResponseData);
        Assert.assertEquals(1,teamStandings.size());
    }
}