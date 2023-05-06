import image_1 from "../../assets/exide.jpg";
import CartQuantity2 from "./CartQuantity2";
import { BiRupee } from "react-icons/bi";
import { useAuthContext } from "../../context/auth_context";
import { useState, useEffect } from "react";
import axios from "axios";
import NoSymFormatPrice from "../../helpers/NoSymFormatPrice";

const CartItem = ({
  id,
  productId,
  productName,
  productBrand,
  pincode,
  productMrp,
  productRebate,
  price,
  productQuantity,
  oldBattery,
  setCart,
}) => {
  const { getToken } = useAuthContext();
  const token = getToken();
  const [qty, setQty] = useState(productQuantity);
  const [pincode_, setPincode] = useState(pincode);
  const [oldBattery_, setOldBattery] = useState(oldBattery);
  const [price_, setPrice] = useState(price);

  useEffect(() => {
    if (oldBattery_ === true) {
      const newPrice = productRebate * qty;
      setPrice(newPrice);
    } else {
      const newPrice = productMrp * qty;
      setPrice(newPrice);
    }
  }, [qty]);

  useEffect(() => {
    const fetchCartItem = async () => {
      try {
        const response = await axios.put(
          `http://localhost:8080/cart?cartItemId=${id}`,
          {
            productQuantity: qty,
            pincode: pincode_,
            oldBattery: oldBattery_,
            price: price_,
          },
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
    fetchCartItem();
  }, [price_]);

  const setIncrease = async (id) => {
    let type = "";
    let prod = "";
    if (id >= 1 && id < 1000) {
      type = "twov";
      prod = "battery";
    } else if (id >= 1000 && id < 2000) {
      type = "fourv";
      prod = "battery";
    } else if (id >= 2000 && id < 3000) {
      type = "threev";
      prod = "battery";
    } else if (id >= 3000 && id < 4000) {
      type = "inv";
      prod = "inverter";
    } else if (id >= 4000 && id < 5000) {
      type = "inv-battery";
      prod = "invbattery";
    } else {
      type = "others";
      prod = "battery";
    }
    try {
      const response = await axios.get(
        `http://localhost:8080/${type}/${prod}?${prod}Id=${id}`
      );
      const stock = response.data.stock;
      if (qty == stock) {
        setQty(qty);
      } else {
        const newQty = qty + 1;
        setQty(newQty);
      }
    } catch (error) {
      console.log(error);
    }
  };

  const setDecrease = () => {
    if (qty > 1) {
      const newQty = qty - 1;
      setQty(newQty);
    } else {
      const newQty = qty;
      setQty(newQty);
    }
  };

  const removeItem = async (id) => {
    try {
      const response = await axios.delete(
        `http://localhost:8080/cart/delete?cartItemId=${id}`,
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

  return (
    <>
      <div className="row">
        <div className="cart-body gradient-bg text-light mt-3">
          <div className="col-12 col-sm-12 col-md-12 col-lg-12 product-details">
            <div className="cart-img">
              <img src={image_1} alt="" className="img-fluid" />
            </div>
          </div>
          <div className="col-12 col-sm-12 col-md-12 col-lg-12">
            <div className="product-details-header">
              {productBrand} Two Wheeler Battery <br />
              {productName}
            </div>
            <div className="cart-item-base_price">
              <p>
                <span className="background">Mrp</span> :{" "}
                <span className="rupee">
                  <BiRupee color="limegreen" fontSize="1.5rem" />
                </span>
                {<NoSymFormatPrice price={productMrp} />}
              </p>
            </div>
            <div className="cart-quantity">
              <CartQuantity2
                productId={productId}
                qty={qty}
                setIncrease={setIncrease}
                setDecrease={setDecrease}
              />
            </div>
          </div>
          <div className=" col-12 col-sm-12 col-md-12 col-lg-12">
            <div className="cart-item-pincode">
              <p>
                <span className="background">Pincode</span> :{"   "}
                <span>{pincode_}</span>
              </p>
            </div>
            <div className="cart-item-price ">
              <p>
                <span className="background">Total</span> :{" "}
                <span className="rupee">
                  <BiRupee color="limegreen" fontSize="1.5rem" />
                </span>
                {<NoSymFormatPrice price={price_} />}
              </p>
            </div>
            <div className="cart-item-remove">
              <button
                type="button"
                className="btn btn-primary"
                onClick={() => removeItem(id)}
              >
                Remove
              </button>
            </div>
          </div>
          <div className=" col-12 col-sm-12 col-md-12 col-lg-12"></div>
          <div className=" col-12 col-sm-12 col-md-12 col-lg-12"></div>
        </div>
      </div>
    </>
  );
};
export default CartItem;
