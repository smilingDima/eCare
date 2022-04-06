// import DataGrid from 'react-data-grid';
import dynamic from "next/dynamic";

const DynamicReactDataGrid = dynamic(() => import('react-data-grid'), {ssr: false}); //load it on client side only

const Tariffs = (props) => {
    const columns = [{
        name: 'Name', key: 'name',
    }, {
        name: 'Price', key: 'price',
    }, {
        name: 'Id', key: 'id',
    },];
    const data = props.tariffs;
    const tariffs = data._embedded.tariffs;

    return !tariffs.length ? null :
        <DynamicReactDataGrid columns={columns} rows={tariffs}/>;
};

export default Tariffs;