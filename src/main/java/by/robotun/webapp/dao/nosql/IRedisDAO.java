package by.robotun.webapp.dao.nosql;

public interface IRedisDAO {

	void insertVotingCandidate(Integer mark, String idCandidate, Integer idUser);

	Double getVotingCandidate(String idCandidate);

	Integer checkVotingCandidate(String idCandidate, Integer idUser);
}
