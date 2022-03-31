package ecare.local.dao;

import ecare.local.model.Contract;
import org.springframework.data.repository.CrudRepository;

public interface ContractDAO extends CrudRepository<Contract, Long> {

}
