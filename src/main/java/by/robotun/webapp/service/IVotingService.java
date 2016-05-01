package by.robotun.webapp.service;

public interface IVotingService {

	void votingLot(int mark, String idLot, int idUser);
	
	float getVotingLot(String idLot);
	
	Integer checkVotingLot(String idLot, int idUser);
}
