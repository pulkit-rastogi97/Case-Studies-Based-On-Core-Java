package com.psl.game.pl;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.psl.game.dto.Game;
import com.psl.game.exception.GameException;
import com.psl.game.service.GameService;
import com.psl.game.service.GameServiceImpl;

public class MainGame {

	public static void main(String[] args) {
		
		GameService gameService = new GameServiceImpl();
		Game game;
		Scanner sc = new Scanner(System.in);
		System.out.println("*********************************************************");
		System.out.println("\t\tWELCOME TO GAME ZONE ");
		System.out.println("*********************************************************");
		System.out.format("%-10s --> %-4s","Game Name","Cost");
		System.out.println();
		HashMap<String,Integer> gameMap = new HashMap<String,Integer>();
		gameMap = gameService.getAllGameDetails();
		for(Entry<String,Integer> entry : gameMap.entrySet())
		{
			System.out.format("%-10s --> %-4d",entry.getKey(),entry.getValue());
			System.out.println();
		}
		System.out.println("*********************************************************");
		System.out.println("\tWould you like to play ? (YES/NO) :: ");
		String ans = sc.next();
		if(ans.equalsIgnoreCase("yes"))
		{
			System.out.println("Enter the userId :: ");
			int userId = sc.nextInt();
			System.out.println("Enter the game name :: ");
			String gameName = sc.next();
			try {
				game = gameService.playGame(userId, gameName);
				System.out.println(game.getUserName()+" thanks for playing "+gameName+" and your current balance is "+game.getBalance());
			} catch (GameException e) {
				System.out.println(e.getMessage());
			}
		}
		else if(ans.equalsIgnoreCase("no"))
		{
			System.out.println("\t**************Thanks For Visiting*****************");
		}
		else
		{
			System.out.println("Only Yes or No is a valid answer");
		}
		sc.close();
	}
}
