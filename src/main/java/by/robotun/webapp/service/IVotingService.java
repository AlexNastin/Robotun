package by.robotun.webapp.service;

public interface IVotingService {

	void votingCandidate(Integer mark, String idCandidate, Integer idUser);
	
	float getVotingCandidate(String idCandidate);
	
	Integer checkVotingCandidate(String idCandidate, Integer idUser);
}
