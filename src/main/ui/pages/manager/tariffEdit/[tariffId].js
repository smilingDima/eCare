import Head from 'next/head';
import ManagerRoutes from "../../components/ManagerRoutes";
import { apiGetTariff, apiPatchTariff } from '../../springApi/apiTariffs';
import { useRouter } from 'next/router';
import { useState } from "react";

const TariffProperty = (props) => {
    // https://stackoverflow.com/questions/54150783/react-hooks-usestate-with-object
    const handleInputChange = e => props.state.setInputValues(
        {...props.state.inputValues, [e.target.name]: e.target.value}
    );

    return(
        <label className="block">
            <span className="text-gray-700">{props.description}</span>
            <input name={props.name}
                   type={props.type}
                   defaultValue={props.value}
                   step={props.step}
                   onChange={handleInputChange}
                   className="mt-1 block w-full rounded-md bg-gray-100 border-transparent
                              focus:border-gray-500 focus:bg-white focus:ring-0"/>
        </label>
    )
}

export default function ManagersTariff() {
    const router = useRouter()
    const { tariffId } = router.query

    const [inputValues, setInputValues] = useState({});
    let state = {inputValues: inputValues, setInputValues: setInputValues}

    const updateTariff = async event => {
        event.preventDefault()
        const res = await apiPatchTariff(event.target.elements.id.value, inputValues)
    }

    const {tariff: tariff, isError: isError, isLoading: isLoading} = apiGetTariff(tariffId);
    if (isLoading ) { return <div>Loading ..</div>; }
    if (isError) { return <div>Error</div>; }


    return (
        <>
            <Head>
                <title>Tariff {tariffId} editing</title>
            </Head>
            <ManagerRoutes />

            <h1 className="text-2xl font-bold">Tariff {tariff.name}</h1>
            <form onSubmit={updateTariff} className="mt-8 max-w-md text-lg">
                <div className="grid grid-cols-1 gap-6 py-8">
                    <input type="hidden" name="id" value={tariff.id}/>
                    <TariffProperty name="name" description="Name" value={tariff.name} type="text" state={state}/>
                    <TariffProperty name="price" description="Price" value={tariff.price} type="number" step="0.01" state={state}/>

                    {/*Todo:*/}
                    <TariffProperty name="Options" type="checkbox" state={state}/>

                    <button type="submit">Save</button>
                </div>
            </form>
        </>
    )
}