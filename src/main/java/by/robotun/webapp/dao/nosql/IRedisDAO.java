package by.robotun.webapp.dao.nosql;

public interface IRedisDAO {

	void insertVotingLot(Integer mark, String idLot, Integer idUser);

	Integer getVotingLot(String idLot);

	Integer checkVotingLot(String idLot, Integer idUser);
}