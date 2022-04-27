package ecare.local.dao;

import ecare.local.model.ContractEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContractDao extends CrudRepository<ContractEntity, Long> {

}
