import React from 'react';
import * as ReactDOMClient from 'react-dom/client';

import { render } from 'react-dom';
import { OpenAPIProvider } from 'react-openapi-client';

import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';

import 'react-tabs/style/react-tabs.css';

import Contracts from './components/Contracts';
import Tariffs from './components/Tariffs';

const TabsList = () => (
  <Tabs>
    <TabList>
      <Tab>Contracts</Tab>
      <Tab>Tariffs</Tab>
    </TabList>

    <TabPanel>
      <h2>Contracts</h2>
      <Contracts />
    </TabPanel>
    <TabPanel>
      <h2>Tariffs</h2>
      <Tariffs />
    </TabPanel>
  </Tabs>
);
const App = () => (
  <OpenAPIProvider definition="/v3/api-docs">
    <TabsList/>
  </OpenAPIProvider>
);

// Create a root.
const root = ReactDOMClient.createRoot(document.getElementById('react'));
root.render(<App/>);