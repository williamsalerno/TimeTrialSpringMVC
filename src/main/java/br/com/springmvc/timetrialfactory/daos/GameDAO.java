package br.com.springmvc.timetrialfactory.daos;

import java.util.List;

import br.com.springmvc.timetrialfactory.models.Game;

public interface GameDAO {
	
	List<Game> listGames();
	
	Game findById(Long id);
	
	void saveGame(Game game);
	
	void updateGame(Game game);
	
	void deleteGame(Game game);

}
