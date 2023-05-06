import cover1 from "../../assets/inverter2.jpg";
import { useProductsContext } from "../../context/products_context";
import { useAuthContext } from "../../context/auth_context";
import { Link } from "react-router-dom";
import InverterBatteryList from "./InverterBatteryList";
import FormatPrice from "../../helpers/FormatPrice";
import { forwardRef } from "react";

const InverterList = ({ inverter, scrollToRef }) => {
  const { setSingleInverter, setAddCartLogin, setChooseType } =
    useProductsContext();
  const { login } = useAuthContext();

  const fetchSingleInverter = (id) => {
    login ? setAddCartLogin(false) : setAddCartLogin(true);
    setChooseType("inverter");
    const singleInverter = inverter.filter((product) => product.id === id);
    setSingleInverter(singleInverter);
  };

  return (
    <>
      <article className="product-list-section mt-2" ref={scrollToRef}>
        {inverter.map((inv) => {
          const {
            model,
            brand,
            id,
            image,
            price,
            noBatteryReq,
            inverterType,
            recomBatteryCapacity,
            nominalVoltage,
            warranty,
            stock,
            invBatteryDTO,
          } = inv;
          return (
            <>
              <div className="container">
                <div className="row">
                  <div className="col-md-12">
                    <div className="product-table">
                      <div className="col-md-12 pt-4 suitable">
                        <h5>Suitable Inverter !</h5>
                      </div>
                      <img className="py-2" src={cover1} alt="batteryimg" />
                      {stock == 0 ? (
                        <span className="stock gradient-bg"> Out of stock</span>
                      ) : (
                        ""
                      )}
                      <div className="product-title d-flex py-2">
                        <span>{model}</span>
                      </div>
                      <div key={id}>
                        <table className="table table-bordered mb-3">
                          <tbody className="gradient-bg">
                            <tr>
                              <th>Price</th>
                              <td>
                                <span>{<FormatPrice price={price} />}</span>
                              </td>
                            </tr>
                            <tr>
                              <th>Brand</th>
                              <td>{brand}</td>
                            </tr>
                            <tr>
                              <th>Model</th>
                              <td>{model}</td>
                            </tr>
                            <tr>
                              <th>Warranty</th>
                              <td>{warranty}</td>
                            </tr>
                            <tr>
                              <th>No of Battery required</th>
                              <td>{noBatteryReq}</td>
                            </tr>
                            <tr>
                              <th>Inverter Type</th>
                              <td>{inverterType}</td>
                            </tr>
                            <tr>
                              <th>Recommended Battery Capacity</th>
                              <td>{recomBatteryCapacity}</td>
                            </tr>
                            <tr>
                              <th>Nominal Voltage</th>
                              <td>{nominalVoltage}</td>
                            </tr>
                            <tr>
                              <th></th>
                              <td>
                                <Link to={login ? "/addtocart" : "/login"}>
                                  <button
                                    type="button"
                                    className="btn btn-link px-5 "
                                    onClick={() => fetchSingleInverter(id)}
                                  >
                                    Buy
                                  </button>
                                </Link>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <h4 className="px-3">
                {invBatteryDTO.lenght === 0
                  ? ""
                  : `Batteries suitable for ${model}`}
              </h4>
              <InverterBatteryList invBattery={invBatteryDTO} />
            </>
          );
        })}
      </article>
    </>
  );
};
export default forwardRef(InverterList);
