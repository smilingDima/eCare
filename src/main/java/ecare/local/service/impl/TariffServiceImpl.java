package ecare.local.service.impl;

import ecare.local.dao.TariffDao;
import ecare.local.dto.TariffDto;
import ecare.local.mapper.TariffMapper;
import ecare.local.model.TariffEntity;
import ecare.local.service.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {
    private final TariffDao tariffDao;

    @Override
    public Iterable<TariffDto> findAll() {
        return TariffMapper.INSTANCE.tariffEntityToTariffDto(tariffDao.findAll());
    }

    @Override
    public Iterable<TariffDto> findAll(Pageable pageble) {
        return TariffMapper.INSTANCE.tariffEntityToTariffDto(tariffDao.findAll(pageble));
    }

    @Override
    public TariffDto findById(long id) {
        Optional<TariffEntity> tariffEntityOptional = tariffDao.findById(id);
//        TODO: tariffEntityOptional.isPresent() - then get, else - exception
        TariffEntity tariffEntity = tariffEntityOptional.get();
        return TariffMapper.INSTANCE.tariffEntityToTariffDto(tariffEntity);
    }

    @Override
    public void deleteById(long id) {
        tariffDao.deleteById(id);
    }

    @Override
    public void save(TariffDto tariffDto) {
        tariffDao.save(TariffMapper.INSTANCE.tariffDtoToTariffEntity(tariffDto));
    }
}