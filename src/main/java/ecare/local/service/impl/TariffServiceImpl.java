package ecare.local.service.impl;

import ecare.local.dao.TariffDao;
import ecare.local.model.TariffEntity;
import ecare.local.service.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {
    private final TariffDao tariffDAO;

    @Override
    public Iterable<TariffEntity> findAll() {
        return tariffDAO.findAll();
    }

    @Override
    public Optional<TariffEntity> findById(long id) {
        return tariffDAO.findById(id);
    }

    @Override
    public void save(TariffEntity tariff) {
        tariffDAO.save(tariff);
    }

    @Override
    public void deleteById(long id) {
        tariffDAO.deleteById(id);
    }
}
