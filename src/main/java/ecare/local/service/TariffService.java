package ecare.local.service;

import ecare.local.dto.TariffDto;
import org.springframework.data.domain.Pageable;


public interface TariffService {
    public Iterable<TariffDto> findAll();
    public Iterable<TariffDto> findAll(Pageable pageable);
    public TariffDto findById(long id);
    public void save(TariffDto tariffDto);
    public void deleteById(long id);
}
