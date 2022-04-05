import Head from 'next/head';
import ManagersRoutes from "./managersRoutes";
import {apiTariffs, apiTariff} from '../springApi/apiTariffs';
import Tariffs from "./components/Tariffs";
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';

import 'react-tabs/style/react-tabs.css';

import React from "react";

export default function ManagersTariff() {
    const {tariffs: tariffs, isError:isError1, isLoading: isLoading1} = apiTariffs();

    const {tariff: tariff, isError: isError2, isLoading: isLoading2} = apiTariff(1);
    if (isLoading1 || isLoading2) { return <div>Loading ..</div>; }
    if (isError1 || isError2) { return <div>Error</div>; }

    return (
<>
    <Head>
        <title>Tariffs editing</title>
    </Head>
    <h1 class="box-content h-32 w-32">Tariff</h1>
    <div className="grid grid-cols-1 gap-6">
        <input type="date" className="mt-1 block w-full"/>
    </div>
    <ManagersRoutes />

    const TabsList = () => (
    <Tabs>
        <TabList>
            <Tab>Contracts</Tab>
            <Tab>Tariffs</Tab>
        </TabList>

        <TabPanel>
            <h2>Contracts</h2>
            {/*<Contracts />*/}
        </TabPanel>
        <TabPanel>
            <h2>Tariffs</h2>
            <div className="Tariffs"><Tariffs tariffs={tariffs}/></div>
        </TabPanel>
    </Tabs>

    <br />
    <div className="Tariff_1">{JSON.stringify(tariff, null, 4)}</div>
</>
    )
}