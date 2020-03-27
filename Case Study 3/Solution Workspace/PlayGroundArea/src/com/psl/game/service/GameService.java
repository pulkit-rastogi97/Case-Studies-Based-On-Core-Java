package com.psl.game.service;

import java.util.HashMap;

import com.psl.game.dto.Game;
import com.psl.game.exception.GameException;

public interface GameService {
	
	HashMap<String,Integer> getAllGameDetails();
	public Game playGame(int userId,String gameName) throws GameException;
	
}
