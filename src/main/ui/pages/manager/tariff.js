import Head from 'next/head';
import ManagersRoutes from "./managersRoutes";
import {apiTariffs, apiTariff} from '../springApi/apiTariffs';
import Tariffs from "./components/Tariffs";
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
    <ManagersRoutes />

    <h1 className="box-content h-32 w-32">Tariff</h1>
    <div className="grid grid-cols-1 gap-6">
        <input type="date" className="mt-1 block w-full"/>
    </div>
    <br />
    <Tariffs tariffs={tariffs}/>
    <br />

    <div className="Tariff_1">{JSON.stringify(tariff, null, 4)}</div>
</>
    )
}