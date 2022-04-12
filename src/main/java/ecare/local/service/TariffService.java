package ecare.local.service;

import ecare.local.model.TariffEntity;

import java.util.Optional;

public interface TariffService {
    public Iterable<TariffEntity> findAll();
    public Optional<TariffEntity> findById(long id);
    public void save(TariffEntity tariffEntity);
    public void deleteById(long id);
}
