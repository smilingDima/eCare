package ecare.local.mapper;

import ecare.local.dto.TariffDto;
import ecare.local.model.TariffEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TariffMapper {
    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);

    Iterable<TariffDto> tariffEntityToTariffDto (Iterable<TariffEntity> tariffEntities);
    TariffDto tariffEntityToTariffDto(TariffEntity tariffEntityOptional);
    TariffEntity tariffDtoToTariffEntity(TariffDto tariffDto);

}
