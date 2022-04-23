package ecare.local.dao;

import ecare.local.model.TariffEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TariffDao extends PagingAndSortingRepository<TariffEntity, Long> {

}
