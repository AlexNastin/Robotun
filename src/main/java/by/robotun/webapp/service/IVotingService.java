package by.robotun.webapp.service;

public interface IVotingService {

	void votingCandidate(Integer mark, String idCandidate, String idUser);
	
	float getVotingCandidate(String idCandidate);
	
	Integer checkVotingCandidate(String idCandidate, String idUser);
}
