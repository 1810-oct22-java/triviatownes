package com.ex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ex.beans.game.HighScoreBean;
import com.ex.beans.game.PlayerBean;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<HighScoreBean, Integer> {
	
	public PlayerBean findByUsernameLikeIgnoreCase(String username);
	
	//@Query("SELECT * FROM GLOBALSTATS")
	//public List<HighScoreBean> oddQuery();

	public List<HighScoreBean> findAll();
	
	
	public HighScoreBean save();
}
