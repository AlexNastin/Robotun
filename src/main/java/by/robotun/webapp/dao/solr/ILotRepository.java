package by.robotun.webapp.dao.solr;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import by.robotun.webapp.domain.solr.LotSolr;

@Repository("lotRepository")
public interface ILotRepository extends SolrCrudRepository<LotSolr, Integer> {
}
