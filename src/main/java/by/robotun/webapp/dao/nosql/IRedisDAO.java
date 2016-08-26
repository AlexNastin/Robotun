package by.robotun.webapp.dao.nosql;

public interface IRedisDAO {

	void insertVotingLot(Integer mark, String idCandidate, Integer idUser);

	Double getVotingLot(String idCandidate);

	Integer checkVotingLot(String idCandidate, Integer idUser);
}
