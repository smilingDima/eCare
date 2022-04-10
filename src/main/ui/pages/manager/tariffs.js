import Head from 'next/head';
import ManagerRoutes from "../components/ManagerRoutes";
import {apiGetTariffs} from '../springApi/apiTariffs';
import ManagerTariffs from "../components/ManagerTariffs";

export default function ManagersTariff() {
    const {tariffs: tariffs, isError:isError, isLoading: isLoading} = apiGetTariffs();

    if (isLoading) { return <div>Loading ..</div>; }
    if (isError) { return <div>Error</div>; }

    return (
<>
    <Head>
        <title>Tariffs editing</title>
    </Head>
    <ManagerRoutes />

    <h1 className="box-content h-32 w-32">Tariffs</h1>
    <div className="grid grid-cols-1 gap-6">
        <input type="date" className="mt-1 block w-full"/>
    </div>
    <br />
    <ManagerTariffs tariffs={tariffs}/>
    <br />
</>
    )
}