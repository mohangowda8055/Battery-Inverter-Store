import cover2 from "../../assets/Amaron1.jpg";
import { Link } from "react-router-dom";
import { useProductsContext } from "../../context/products_context";
import { useAuthContext } from "../../context/auth_context";
import FormatPrice from "../../helpers/FormatPrice";
import { forwardRef } from "react";

const ProductsList = ({ battery, scrollToRef }) => {
  const { setSingleBattery, setAddCartLogin, chooseType } =
    useProductsContext();
  const { login } = useAuthContext();

  const fetchSingleBattery = (id) => {
    login ? setAddCartLogin(false) : setAddCartLogin(true);
    const singleProduct = battery.filter((product) => product.id === id);
    setSingleBattery(singleProduct);
  };

  return (
    <>
      <article className="product-list-section mt-2 " ref={scrollToRef}>
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              {battery.map((bat) => {
                const {
                  ah,
                  batteryModelName,
                  brand,
                  guarantee,
                  id,
                  image,
                  mrp,
                  rebate,
                  series,
                  terminalLayout,
                  voltage,
                  warranty,
                  stock,
                } = bat;
                return (
                  <>
                    <div className="product-table">
                      <div className="col-md-12 pt-4 suitable">
                        <h5>Suitable Battery !</h5>
                      </div>
                      <img className="py-2" src={cover2} alt="batteryimg" />
                      {stock == 0 ? (
                        <span className="stock gradient-bg"> Out of stock</span>
                      ) : (
                        ""
                      )}
                      <div className="product-title d-flex py-2">
                        <span>{batteryModelName}</span>
                      </div>
                      <table
                        key={id}
                        className="table table-bordered gradient-bg mb-3"
                      >
                        <tbody>
                          {chooseType === "inverterbattery" && (
                            <tr>
                              <th>Backup Duration</th>
                              <td>{bat.backupDuration} hours</td>
                            </tr>
                          )}

                          <tr>
                            <th>Capacity(AH)</th>
                            <td>{ah}</td>
                          </tr>
                          <tr>
                            <th>Base Price</th>
                            <td>{<FormatPrice price={mrp} />}</td>
                          </tr>
                          <tr>
                            <th>
                              <span>Rebate on return of old battery</span>
                            </th>
                            <td>
                              <span>{<FormatPrice price={rebate} />}</span>
                            </td>
                          </tr>
                          <tr>
                            <th>Brand</th>
                            <td>{brand}</td>
                          </tr>
                          <tr>
                            <th>Series</th>
                            <td>{series}</td>
                          </tr>
                          <tr>
                            <th>Voltage</th>
                            <td>{voltage}</td>
                          </tr>
                          <tr>
                            <th>Guarantee</th>
                            <td>{guarantee}</td>
                          </tr>
                          <tr>
                            <th>Warranty</th>
                            <td>{warranty}</td>
                          </tr>
                          <tr>
                            <th>Terminals Pole</th>
                            <td>{terminalLayout}</td>
                          </tr>
                          <tr>
                            <th></th>
                            <td>
                              <Link to={login ? "/addtocart" : "/login"}>
                                <button
                                  type="button"
                                  className="btn btn-primary px-5 "
                                  onClick={() => fetchSingleBattery(id)}
                                >
                                  Buy
                                </button>
                              </Link>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                    <div className="product-space"></div>
                  </>
                );
              })}
            </div>
          </div>
        </div>
      </article>
    </>
  );
};
export default forwardRef(ProductsList);
