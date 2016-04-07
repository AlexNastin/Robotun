package by.robotun.webapp.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import by.robotun.webapp.service.IVotingService;

@Controller
public class VotingController {

	@Autowired
	private IVotingService votingService;

	@RequestMapping(value = "/redisTest", method = RequestMethod.GET)
	public String test1(Locale locale, Model model) {
		return "test1";
	}

	@RequestMapping(value = "/voting", method = RequestMethod.GET)
	public @ResponseBody String voting(@RequestParam(value = "mark") int mark,
			@RequestParam(value = "idLot") String idLot, @RequestParam(value = "idUser") int idUser) {
		votingService.votingLot(mark, idLot, idUser);
		return "Ваш голос учтен. Спасибо.";
	}

	@RequestMapping(value = "/getVoting", method = RequestMethod.GET)
	public @ResponseBody Integer getVotingLot(@RequestParam(value = "idLot") String idLot) {
		return votingService.getVotingLot(idLot);
	}
}
