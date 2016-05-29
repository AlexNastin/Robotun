package by.robotun.webapp.dao.solr;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import by.robotun.webapp.domain.solr.LotSolr;

@Repository("lotRepository")
public interface ILotRepository extends SolrCrudRepository<LotSolr, Integer> {

	@Query("name:*?0* OR description:*?0*")
	List<LotSolr> findLots(String key);

}
