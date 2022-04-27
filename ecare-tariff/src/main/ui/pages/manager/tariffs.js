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

    <h1 className="text-2xl font-bold">Tariffs</h1>
    <ManagerTariffs tariffs={tariffs}/>
</>
    )
}