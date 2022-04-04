import React from 'react';
import { useOperation } from 'react-openapi-client';

const Tariffs = (props) => {
//  const { loading, data, error } = useOperation('getItemResource-tariff-get', props.id);
  const { loading, data, error } = useOperation('getCollectionResource-tariff-get_1');
  if (loading) {
    return <div>Loading...</div>;
  }
  if (error) {
    return <div>Error: {error}</div>;
  }
  const tariffs = data._embedded.tariffs;
  return !tariffs.length ? null : (
    tariffs.map((tariff) =>
    <div className="App">
      <h3>{tariff.name}</h3>
      <ul>
        <li>
          <strong>id:</strong> {tariff.id}
        </li>
        <li>
          <strong>price:</strong> {tariff.price}
        </li>
      </ul>
    </div>
  ));
};

export default Tariffs;