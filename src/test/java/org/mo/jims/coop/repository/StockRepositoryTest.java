package org.mo.jims.coop.repository;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.entity.Stock;
import org.mo.open.common.entity.User;
import org.mo.open.common.util.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class StockRepositoryTest extends BaseTest {

	@Autowired
	private StockRepository stockRepository;

	@Test
	public void testInsert() {
		
	}
	@Test
	public void testCountByProviderInfoGoodInfoUserTime() {
		int countByProviderInfoGoodInfoUserTime = stockRepository
				.countByProviderInfoGoodInfoUserTime(null, null, "莫梓奇", null,
						null);
		System.out.println(countByProviderInfoGoodInfoUserTime);
	}

	@Test
	public void testSelectAllByProviderInfoGoodInfoUserTime() {
		List<Stock> selectAllByProviderInfoGoodInfoUserTime = stockRepository.selectAllByProviderInfoGoodInfoUserTime(null, null,
				"莫梓奇", null, null, 0, 10);
		System.out.println(selectAllByProviderInfoGoodInfoUserTime.size());
		Iterator<Stock> iterator = selectAllByProviderInfoGoodInfoUserTime.iterator();
		while(iterator.hasNext()){
			Stock next = iterator.next();
			System.out.println(next.getProviderInfo().getName());
		}
	}

}
