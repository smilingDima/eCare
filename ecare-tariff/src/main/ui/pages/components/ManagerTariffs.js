import DataGrid from 'react-data-grid';
import Link from 'next/link'

// Component for Actions column for tariff
// id of tariff is parameter
const EditTariff = (props) => {
    return <Link href= {"tariffEdit/" + props.id}>
        <a>Edit</a>
    </Link>
}

// Table with all tariffs
const ManagerTariffs = (props) => {
    const columns = [{
        name: 'Name', key: 'name',
    }, {
        name: 'Price', key: 'price',
    }, {
        name: 'Actions', key: 'id',
    },];
    const data = props.tariffs;
    const tariffs = data._embedded.tariffs;

    if (!tariffs.length) {
        return (<h1>Empty tariffs.</h1>)
    }

    // In tariffs replacing id column with EditTariff component
    const rows = [];
    tariffs.forEach(tariff => {
        rows.push(
            // https://stackoverflow.com/a/39333479/2879364
            (({name, price}) => ({name, price, id: <EditTariff id={tariff.id} />}))(tariff)
        )
    })

    return <DataGrid columns={columns} rows={rows} />;
};

export default ManagerTariffs;
