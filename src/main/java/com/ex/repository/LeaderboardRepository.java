package com.ex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.beans.game.LeaderboardBean;

@Repository("leaderboardRepository")
public interface LeaderboardRepository extends JpaRepository<LeaderboardBean, Integer>{

	public List<LeaderboardBean> findAll();
}
