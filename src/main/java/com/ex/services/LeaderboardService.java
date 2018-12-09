package com.ex.services;

import java.util.ArrayList;
import java.util.List;

import com.ex.beans.game.LeaderboardBean;

public class LeaderboardService {
	
	//dummy data for leaderboards until we get the database connected
	static ArrayList<LeaderboardBean> leaders = new ArrayList<LeaderboardBean>();
	
	static {
		leaders.add(new LeaderboardBean("Ian", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2009128));
		leaders.add(new LeaderboardBean("Margy", 1980832));
		leaders.add(new LeaderboardBean("Joe", 1800982));
		leaders.add(new LeaderboardBean("Ian", 1708702));
		leaders.add(new LeaderboardBean("James", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2082347));
		leaders.add(new LeaderboardBean("Ian", 2082347));
		
	}
	public List<LeaderboardBean> getAll(){
		return leaders;
	}
}
