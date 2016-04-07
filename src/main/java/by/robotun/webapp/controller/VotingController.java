package by.robotun.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.robotun.webapp.domain.Person;
import by.robotun.webapp.service.IVotingService;

@RestController
public class VotingController {

	@Autowired
	private IVotingService votingService;

	@RequestMapping(value = "/voting", method = RequestMethod.GET)
	public String voting(@RequestParam(value = "mark") int mark, @RequestParam(value = "idLot") String idLot,
			@RequestParam(value = "idUser") int idUser) {
		votingService.votingLot(mark, idLot, idUser);
		return "Ваш голос учтен. Спасибо.";
	}

	@RequestMapping(value = "/getVoting", method = RequestMethod.GET)
	public Integer getVotingLot(@RequestParam(value = "idLot") String idLot) {
		return votingService.getVotingLot(idLot);
	}

	@RequestMapping(value = "/checkVoting", method = RequestMethod.GET)
	public Integer checkVotingLot(@RequestParam(value = "idLot") String idLot, HttpSession httpSession) {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		Integer vote = 0;
		if (person != null) {
			vote = votingService.checkVotingLot(idLot, person.getId());
		}
		return vote;
	}

}
