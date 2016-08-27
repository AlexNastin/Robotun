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

	@RequestMapping(value = "/voting", method = RequestMethod.POST)
	public String voting(@RequestParam(value = "mark") Integer mark, @RequestParam(value = "idCandidate") String idCandidate, @RequestParam(value = "idUser") Integer idUser, Locale locale) {
		votingService.votingCandidate(mark, idCandidate, idUser);
		return messages.getMessage("voiting.insert", null, locale);
	}

	@RequestMapping(value = "/getVoting", method = RequestMethod.GET)
	public float getVotingLot(@RequestParam(value = "idCandidate") String idCandidate) {
		return votingService.getVotingCandidate(idCandidate);
	}

	@RequestMapping(value = "/checkVoting", method = RequestMethod.POST)
	public Integer checkVotingLot(@RequestParam(value = "idCandidate") String idCandidate, HttpSession httpSession) {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		Integer vote = 0;
		if (person != null) {
			vote = votingService.checkVotingCandidate(idCandidate, person.getId());
		}
		return vote;
	}
}
