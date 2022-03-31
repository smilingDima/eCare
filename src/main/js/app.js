import * as ReactDOMClient from 'react-dom/client';

import React from 'react';
import { render } from 'react-dom';
import { OpenAPIProvider } from 'react-openapi-client';

const App = () => (
  <OpenAPIProvider definition="/v3/api-docs">
    <Tariffs/>
  </OpenAPIProvider>
);

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

  return (
    data._embedded.tariffs.map((tariff) =>
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

// Create a root.
const root = ReactDOMClient.createRoot(document.getElementById('react'));
root.render(<App />);
