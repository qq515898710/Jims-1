package org.mo.jims.coop.repository;

import org.mo.jims.coop.entity.Sell;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("sellRepository")
public interface SellRepository extends BaseRepository<Sell, String> {

}
