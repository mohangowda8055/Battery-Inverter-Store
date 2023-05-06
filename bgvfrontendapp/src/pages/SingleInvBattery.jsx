import cover1 from "../assets/inverter1.jpg";
import { Link } from "react-router-dom";
import { useAuthContext } from "../context/auth_context";
import { useProductsContext } from "../context/products_context";
import PageNavigation from "../components/PageNavigation";
import FormatPrice from "../helpers/FormatPrice";

const SingleInvBattery = () => {
  const { singleBattery, setAddCartLogin } = useProductsContext();
  const { login } = useAuthContext();
  const object = singleBattery[0];

  const fetchSingleBattery = (id) => {
    login ? setAddCartLogin(false) : setAddCartLogin(true);
    const singleProduct = battery.filter((product) => product.id === id);
    setSingleBattery(singleProduct);
  };
  return (
    <>
      <PageNavigation battery={object}></PageNavigation>
      <article className="product-list-section mt-2">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              {singleBattery.map((bat) => {
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
                  backupDuration,
                } = bat;
                return (
                  <>
                    <div className="product-table">
                      <div className="col-md-12 pt-4 suitable">
                        {/* <h5>Inverter Battery !</h5> */}
                      </div>
                      <img className="py-2" src={cover1} alt="batteryimg" />
                      <div className="product-title d-flex py-2">
                        <span>{batteryModelName}</span>
                      </div>
                      <table key={id} className="table table-bordered mb-3">
                        <tbody className="gradient-bg">
                          <tr>
                            <th>Base Price</th>
                            <td>
                              <span className="rupee"></span>
                              <span>{<FormatPrice price={mrp} />}</span>
                            </td>
                          </tr>
                          <tr>
                            <th>Backup Duration</th>
                            <td>{backupDuration} hours</td>
                          </tr>
                          <tr>
                            <th>Capacity(AH)</th>
                            <td>{ah}</td>
                          </tr>
                          <tr>
                            <th>
                              <span>Rebate on return of old battery</span>
                            </th>
                            <td>
                              <span className="rupee"></span>
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
                            <th>Terminal Layout</th>
                            <td>{terminalLayout}</td>
                          </tr>
                          <tr>
                            <th></th>
                            <td>
                              <Link to={login ? "/addtocart" : "/login"}>
                                <button
                                  type="button"
                                  className="btn btn-link px-5 "
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
export default SingleInvBattery;
