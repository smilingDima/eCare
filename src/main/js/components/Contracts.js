import React from 'react';
import { useOperation } from 'react-openapi-client';

const Contracts = (props) => {
//  const { loading, data, error } = useOperation('getItemResource-tariff-get', props.id);
  const { loading, data, error } = useOperation('getCollectionResource-contract-get_1');
  if (loading) {
    return <div>Loading...</div>;
  }
  if (error) {
    return <div>Error: {error}</div>;
  }
  const contracts = data._embedded.contracts;
  return !contracts.length ? null : (
    contracts.map((contract) =>
        <div className="App">
          <h3>{contract.name}</h3>
          <ul>
            <li>
              <strong>id:</strong> {contract.id}
            </li>
            <li>
              <strong>phoneNumber:</strong> {contract.phoneNumber}
            </li>
          </ul>
        </div>
    )
  );
};

export default Contracts;