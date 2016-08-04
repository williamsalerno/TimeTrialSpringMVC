package br.com.springmvc.timetrialfactory.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springmvc.timetrialfactory.models.Game;
import br.com.springmvc.timetrialfactory.services.GameService;
import br.com.springmvc.timetrialfactory.validation.GameValidator;

@Controller
@Transactional
@RequestMapping("/games")
public class GamesController {

	@Autowired
	private GameService service;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new GameValidator());
	}

	// Método POST para salvar um novo jogo no bd.
	@RequestMapping(method = POST, value = "/newGame")
	@CacheEvict(value = "games", allEntries = true)
	public ModelAndView save(@Valid Game game, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return gamesForm();
		}
		service.saveGame(game);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		return new ModelAndView("redirect:list");
	}

	// Método GET para carregar a página de form de novo jogo.
	@RequestMapping(method = RequestMethod.GET, value = "/form")
	public ModelAndView gamesForm() {
		ModelAndView modelAndView = new ModelAndView("games/newGame");
		modelAndView.addObject("game", new Game());
		return modelAndView;
	}

	// Método GET para carregar a lista de jogos do bd.
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	@Cacheable(value = "games")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("games/list");
		modelAndView.addObject("games", service.listGames());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/details/{id}")
	public ModelAndView show(Long id) {
		ModelAndView modelAndView = new ModelAndView("games/details");
		Game game = (Game) service.findGameById(id);
		modelAndView.addObject("game", game);
		return modelAndView;
	}

}
