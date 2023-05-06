import { useState, useEffect } from "react";
import axios from "axios";
import { useAuthContext } from "../context/auth_context";
import { NavLink } from "react-router-dom";
import CommonNavigation from "../components/CommonNavigation";
import FormatPrice from "../helpers/FormatPrice";

const OrdersPage = () => {
  const [orders, setOrders] = useState([]);
  const { getToken } = useAuthContext();
  const token = getToken();
  useEffect(() => {
    const fetchOrders = async () => {
      try {
        const response = await axios.get("http://localhost:8080/order/show", {
          headers: { Authorization: `Bearer ${token}` },
        });
        const result = response.data;
        setOrders(result);
      } catch (error) {
        console.log(error);
      }
    };
    fetchOrders();
  }, []);

  if (orders.length === 0) {
    return (
      <>
        <article className="orders-page">
          <CommonNavigation page={"Orders"}></CommonNavigation>
          <div className="cart-empty">
            <h3>No Orders To Show</h3>
            <NavLink to="/">
              <button type="button" className="btn btn-primary mt-3">
                Go to HomePage
              </button>
            </NavLink>
          </div>
        </article>
      </>
    );
  }
  return (
    <>
      <article className="orders-page">
        <CommonNavigation page={"Orders"}></CommonNavigation>
        <div className="container-fluid">
          <div className="row orders pb-2">
            {orders.map((order) => {
              const {
                productName,
                orderStatus,
                productQty,
                productPrice,
                orderItemId,
                orderId,
              } = order;
              return (
                <>
                  <div
                    className="cart-body order mt-3 ms-1 gradient-bg text-light"
                    key={orderItemId}
                  >
                    <div className="col-12 col-sm-12 col-md-8 col-lg-8 order-left mt-2">
                      <div className="product-details-header ">
                        <h4>
                          Two Wheeler Battery <br />
                          {productName}
                        </h4>
                      </div>
                      <div className="product-details-header">
                        <p className="mb-0">
                          <span>Status</span> : {orderStatus}
                        </p>
                      </div>
                      <div className="product-details-header ">
                        <p className="mb-0">
                          <span>Order Id</span> : {orderId}
                        </p>
                      </div>
                      <div className="product-details-header mb-0">
                        <p className="mb-0">
                          <span>Quantity</span> : {productQty}
                        </p>
                      </div>

                      <div className="product-details-header mb-0">
                        <p>
                          <span>Price</span> :{" "}
                          {<FormatPrice price={productPrice} />}
                        </p>
                      </div>
                    </div>
                    <div className=" col-5 col-sm-5 col-md-4 col-lg-4 order-right mt-2">
                      <div
                        className={`${
                          orderStatus === "Cancelled"
                            ? "cart-item-remove invisible "
                            : " cart-item-remove "
                        }`}
                      >
                        <button
                          type="button"
                          className="btn btn-primary"
                          onClick={() => cancelItem(orderId)}
                        >
                          Cancel Order
                        </button>
                      </div>
                    </div>
                  </div>
                </>
              );
            })}
          </div>
        </div>
      </article>
    </>
  );
};
export default OrdersPage;
