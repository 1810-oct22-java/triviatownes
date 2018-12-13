package com.ex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ex.beans.game.HighScorePlayerBean;
import com.ex.beans.game.PlayerBean;

@Repository("HighScoreBeanRepository")
public interface HighScoreBeanRepository extends JpaRepository<HighScorePlayerBean, Integer>{

	public List <HighScorePlayerBean> findAll();
	
	HighScorePlayerBean save(HighScorePlayerBean persisted);
	
	public PlayerBean findById(PlayerBean pb);
	
}
