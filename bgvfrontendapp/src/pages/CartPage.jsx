import { useCartContext } from "../context/cart_context";
import { NavLink } from "react-router-dom";
import CartItem from "../components/cartpage/CartItem";
import { useEffect, useState } from "react";
import { useAuthContext } from "../context/auth_context";
import axios from "axios";
import CommonNavigation from "../components/CommonNavigation";
import FormatPrice from "../helpers/FormatPrice";

const CartPage = () => {
  const { getToken } = useAuthContext();
  const [cart, setCart] = useState([]);
  const { total_amount, setTotal_Amount } = useCartContext();
  const token = getToken();
  const delivery_fee = 50;

  const clearCart = async () => {
    try {
      const response = await axios.delete(
        `http://localhost:8080/cart/delete-all`,
        {
          headers: { Authorization: `Bearer ${token}` },
        }
      );
      const result = response.data.cartItems;
      setCart(result);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    const fetchCart = async () => {
      try {
        const response = await axios.get("http://localhost:8080/cart/", {
          headers: { Authorization: `Bearer ${token}` },
        });
        const result = response.data.cartItems;
        setCart(result);
      } catch (error) {
        console.log(error);
      }
    };
    fetchCart();
  }, []);

  useEffect(() => {
    let total = 0;
    cart.map((item) => {
      total = total + item.price;
    });
    setTotal_Amount(total);
  }, [cart]);

  if (cart.length === 0) {
    return (
      <>
        <article className="cart-page">
          <CommonNavigation page={"Cart"}></CommonNavigation>
          <div className="cart-empty">
            <h3>Cart is Empty</h3>
            <NavLink to="/products">
              <button type="button" className="btn btn-primary mt-3">
                Continue Shopping
              </button>
            </NavLink>
          </div>
        </article>
      </>
    );
  }

  return (
    <>
      <article className=" cart-page px-0">
        <CommonNavigation page={"Cart"}></CommonNavigation>
        <div className="container-fluid">
          {cart.map((product) => {
            return <CartItem key={product.id} {...product} setCart={setCart} />;
          })}
        </div>
        <div className="cart-clear-btn me-3">
          <button
            type="button"
            className="btn btn-primary me-2 "
            onClick={clearCart}
          >
            Clear Cart
          </button>
        </div>
        <hr />
        <div className="container order-total--amount  text-light">
          <div className="row">
            <div className="col-6 col-sm-6 col-md-3 col-lg-3 order-total--subdata gradient-bg">
              <div>
                <p>
                  <span>Base Price </span>
                </p>
              </div>
              <div>
                <p>
                  <span>Shipping Fee </span>
                </p>
              </div>
              <div>
                <p>
                  <span>Order Total </span>
                </p>
              </div>
            </div>
            <div className="col-6 col-sm-6 col-md-2 col-lg-2 order-total--subdata data gradient-bg">
              <div className="data mb-1 mt-1">
                <p className="price">
                  {" "}
                  : {<FormatPrice price={total_amount} />}
                </p>
              </div>
              <div className="data mb-2">
                <p className="price">
                  {" "}
                  : {<FormatPrice price={delivery_fee} />}
                </p>
              </div>
              <div className="data">
                <p className="total">
                  : {<FormatPrice price={total_amount + delivery_fee} />}
                </p>
              </div>
            </div>
          </div>
        </div>

        <div className="cart-order-btn">
          <NavLink to="/">
            <button type="button" className="btn btn-primary mx-2">
              Continue Shopping
            </button>
          </NavLink>
          <NavLink to="/placeOrder">
            <button type="button" className="btn btn-primary mx-2 ">
              Proceed To Order
            </button>
          </NavLink>
        </div>
      </article>
    </>
  );
};
export default CartPage;
