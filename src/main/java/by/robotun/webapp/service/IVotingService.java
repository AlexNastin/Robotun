package by.robotun.webapp.service;

public interface IVotingService {

	void votingLot(int mark, String idLot, int idUser);
	
	Integer getVotingLot(String idLot);
}
