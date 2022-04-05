const Tariffs = (props) => {
    const data = props.tariffs
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