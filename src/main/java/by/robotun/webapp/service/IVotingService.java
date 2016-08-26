package by.robotun.webapp.service;

public interface IVotingService {

	void votingLot(Integer mark, String idCandidate, Integer idUser);
	
	float getVotingLot(String idCandidate);
	
	Integer checkVotingLot(String idCandidate, Integer idUser);
}
