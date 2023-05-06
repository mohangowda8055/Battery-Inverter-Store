import cover1 from "../../assets/exide.jpg";
import { Link } from "react-router-dom";
import { useProductsContext } from "../../context/products_context";
import FormatPrice from "../../helpers/FormatPrice";

const InverterBatteryList = ({ invBattery }) => {
  const { setSingleBattery, setChooseType } = useProductsContext();

  const fetchSingleInvBattery = (id) => {
    setChooseType("inverterbattery");
    const singleInvBattery = invBattery.filter((product) => product.id === id);
    setSingleBattery(singleInvBattery);
  };
  return (
    <div className="container">
      {invBattery.map((bat) => {
        const { id, brand, batteryModelName, mrp, backupDuration } = bat;
        return (
          <>
            <div className="row mb-3 inv-bat-list " key={id}>
              <div className="col-6 col-md-3 col-lg-3 inv-bat-list-col mt-2 gradient-bg">
                <div className="inv-bat-img mt-4">
                  <img src={cover1} alt="" className="img-thumbnail" />
                </div>
              </div>
              <div className="col-6 col-md-3 col-lg-3 inv-bat-list-col mt-2 gradient-bg">
                <div className="product-details-header mt-2 text-light">
                  <h4>
                    {brand} Inverter Battery <br />
                    {batteryModelName}
                  </h4>
                </div>
                <div className="inv-bat-brand">
                  <p>Brand: {brand}</p>
                </div>
                <div className="inv-bat-brand">
                  <p>Backup Time: {backupDuration} hrs</p>
                </div>
                <div className="inv-bat-mrp">
                  <p>Mrp: {<FormatPrice price={mrp} />}</p>
                </div>
                <div className="cart-item-remove">
                  <Link to="/invbattery">
                    <button
                      type="button"
                      className="btn btn-primary mt-1"
                      onClick={() => fetchSingleInvBattery(id)}
                    >
                      Buy
                    </button>
                  </Link>
                </div>
              </div>
            </div>
          </>
        );
      })}
    </div>
  );
};
export default InverterBatteryList;
