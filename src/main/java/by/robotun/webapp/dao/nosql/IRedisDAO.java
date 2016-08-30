package by.robotun.webapp.dao.nosql;

public interface IRedisDAO {

	void insertVotingCandidate(Integer mark, String idCandidate, String idUser);

	Double getVotingCandidate(String idCandidate);

	Integer checkVotingCandidate(String idCandidate, String idUser);
}
