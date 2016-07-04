package by.robotun.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.robotun.webapp.domain.Person;
import by.robotun.webapp.service.IVotingService;

@RestController
public class VotingController {

	@Autowired
	private IVotingService votingService;

	@Autowired
	private MessageSource messages;

	@RequestMapping(value = "/voting", method = RequestMethod.GET)
	public String voting(@RequestParam(value = "mark") int mark, @RequestParam(value = "idLot") String idLot,
			@RequestParam(value = "idUser") int idUser, Locale locale) {
		votingService.votingLot(mark, idLot, idUser);
		return messages.getMessage("voiting.insert", null, locale);
	}

	@RequestMapping(value = "/getVoting", method = RequestMethod.GET)
	public float getVotingLot(@RequestParam(value = "idLot") String idLot) {
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
