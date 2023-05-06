import image_1 from "../../assets/exide.jpg";
import { useProductsContext } from "../../context/products_context";
import PageNavigation from "../PageNavigation";
import { BiRupee } from "react-icons/bi";
import { TbTruckDelivery } from "react-icons/tb";
import { RiShieldCheckLine } from "react-icons/ri";
import CartQuantity from "./CartQuantity";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { useAuthContext } from "../../context/auth_context";
import { pincodes } from "../../utils/constants";
import FormatPrice from "../../helpers/FormatPrice";
import NoSymFormatPrice from "../../helpers/NoSymFormatPrice";

const AddToCart = () => {
  const { singleBattery, singleInverter, chooseType } = useProductsContext();
  const [cart, setCart] = useState([]);
  const { getToken } = useAuthContext();
  const navigate = useNavigate();
  const [object] = chooseType === "inverter" ? singleInverter : singleBattery;
  const stock = object.stock;
  const [qty, setQty] = useState(1);
  const [pincode, setPincode] = useState("");
  const [oldBattery, setOldBattery] = useState(true);
  const [isPin, setIsPin] = useState(false);
  const token = getToken();

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

  const addToCart1 = async (object, qty, pincode) => {
    const existing = cart.find((item) => item.productId === object.id);
    if (existing) {
      try {
        const newQty = existing.productQuantity + qty;
        const response = await axios.put(
          `http://localhost:8080/cart?cartItemId=${existing.id}`,
          {
            productQuantity: newQty,
            pincode: pincode,
            price: object.price * newQty,
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

      navigate("/cart");
      return;
    }
    try {
      const response = await axios.post(
        "http://localhost:8080/cart/add",
        {
          productId: object.id,
          productName: object.model,
          productBrand: object.brand,
          productMrp: object.price,
          productQuantity: qty,
          pincode: pincode,
          price: object.price * qty,
        },
        {
          headers: { Authorization: `Bearer ${token}` },
        }
      );
      navigate("/cart");
    } catch (error) {
      console.log(error);
    }
  };

  const addToCart = async (object, qty, pincode, oldBattery) => {
    const existing = cart.find((item) => item.productId === object.id);
    if (existing) {
      if (existing.oldBattery === oldBattery) {
        try {
          const newQty = existing.productQuantity + qty;
          const response = await axios.put(
            `http://localhost:8080/cart?cartItemId=${existing.id}`,
            {
              productQuantity: newQty,
              pincode: pincode,
              oldBattery: oldBattery,
              price:
                oldBattery === true
                  ? object.rebate * newQty
                  : object.mrp * newQty,
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
      }
      navigate("/cart");
      return;
    }

    try {
      const response = await axios.post(
        "http://localhost:8080/cart/add",
        {
          productId: object.id,
          productName: object.batteryModelName,
          productBrand: object.brand,
          productMrp: object.mrp,
          productRebate: object.rebate,
          productQuantity: qty,
          pincode: pincode,
          oldBattery: oldBattery,
          price: oldBattery === true ? object.rebate * qty : object.mrp * qty,
        },
        {
          headers: { Authorization: `Bearer ${token}` },
        }
      );
      navigate("/cart");
    } catch (error) {
      console.log(error);
    }
  };

  const setIncrease = () => {
    qty == stock ? setQty(qty) : setQty(qty + 1);
  };
  const setDecrease = () => {
    qty > 1 ? setQty(qty - 1) : setQty(qty);
  };

  const handlePincode = (e) => {
    setPincode(e.target.value);
  };

  const checkPincode = () => {
    let message = document.querySelector(".pincode-info");
    let element = document.querySelector(".pincode");
    const pin = Number(pincode);
    if (pincodes.includes(pin)) {
      let html;
      html = `${pincode} is available`;
      message.innerHTML = html;
      message.style.color = "green";
      element.style.margin = "20px 0px 5px";
    } else {
      let html;
      html = `not available`;
      message.innerHTML = html;
      message.style.color = "red";
      element.style.margin = "20px 0px 5px";
    }
  };

  const handleOldBattery = (e) => {
    setOldBattery(e.target.checked);
  };

  return (
    <>
      <PageNavigation battery={object}></PageNavigation>
      <article className="add-to-cart px-0">
        <div className="container my-3 round gradient-bg text-light">
          <div className="row mt-5">
            <div className="col-md-6">
              <div className="add-to-cart-img">
                <img src={image_1} alt="" className="img-thumbnail" />
              </div>
            </div>
            <div className="col-md-6">
              <div className="product-detail-header">
                <h3>
                  {object.brand} Two Wheeler Battery -
                  {chooseType === "inverter"
                    ? object.model
                    : object.batteryModelName}
                </h3>
              </div>
              <div className="product-detail-price total_price pt-3 pb-2">
                <span className="rupee">
                  <BiRupee color="limegreen" fontSize="2rem" />
                </span>
                <span className="">
                  {chooseType === "inverter" ? (
                    <NoSymFormatPrice price={object.price} />
                  ) : (
                    <NoSymFormatPrice price={object.mrp} />
                  )}
                </span>
                <span className="per-unit text-light"> (Per unit)</span>
              </div>
              {chooseType !== "inverter" && (
                <div className="product-detail-exchange mb-3">
                  Additionally, rebate
                  <span className="bold-font">
                    <span className="upto"> upto </span>
                    {<FormatPrice price={object.mrp - object.rebate} />}
                  </span>
                  <span> per unit on return of simillar old battery.</span>
                  <div className="pro-info-icon">
                    <i className="fa fa-info-circle" aria-hidden="true"></i>
                  </div>
                </div>
              )}
              <div className="product-data-warranty">
                <div className="product-warranty-icon">
                  <TbTruckDelivery
                    color="#06ede2"
                    className="warranty-icon gradient-bg"
                  />
                  <p className="mt-1 text-light">
                    Free <br /> Delivery
                  </p>
                </div>
                <div className="product-warranty-icon">
                  <RiShieldCheckLine
                    color="#06ede2"
                    className="warranty-icon gradient-bg"
                  />
                  <p className="mt-1 text-light">
                    {chooseType === "inverter"
                      ? object.warranty
                      : object.warranty + object.guarantee}{" "}
                    Months <br />
                    Warranty
                  </p>
                </div>
                <div className="product-warranty-icon">
                  <TbTruckDelivery
                    color="#06ede2"
                    className="warranty-icon gradient-bg"
                  />
                  <p className="mt-1 text-light">
                    Free <br /> Delivery
                  </p>
                </div>
                <div className="product-warranty-icon">
                  <TbTruckDelivery
                    color="#06ede2"
                    className="warranty-icon gradient-bg"
                  />
                  <p className="mt-1 text-light">
                    Free <br /> Delivery
                  </p>
                </div>
              </div>
              <div className="product-data-info">
                <p className="text-light">
                  <span className="design">Available</span> :
                  <span> {object.stock > 0 ? "In Stock" : "Out of Stock"}</span>
                </p>
              </div>
              <CartQuantity
                qty={qty}
                setIncrease={setIncrease}
                setDecrease={setDecrease}
              />
              <div className="pincode g-3 ">
                <label
                  htmlFor="inputPassword2"
                  className="form-label text-light m-0"
                >
                  <span className="design">Pincode</span> :
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="inputPassword2"
                  placeholder="Pincode"
                  name="pincode"
                  value={pincode}
                  onChange={handlePincode}
                />
                <button
                  type="submit"
                  className="btn btn-primary m-0"
                  onClick={checkPincode}
                >
                  Check
                </button>
              </div>
              <div className="pincode-info text-center"></div>
              {chooseType !== "inverter" && (
                <div className="form-check ms-2">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    name="oldBattery"
                    id="flexCheckChecked"
                    checked={oldBattery}
                    onChange={handleOldBattery}
                  />
                  <label
                    className="form-check-label text-light ms-1 pt-1"
                    htmlFor="flexCheckChecked"
                  >
                    Old battery return
                  </label>
                </div>
              )}
              <div className="product-data-info pt-3">
                <p className="rupee text-light">
                  <span className="design">Price</span> :
                  <span className="rupee">
                    <BiRupee color="lime" fontSize="2rem" />
                  </span>
                  <span className="">
                    {chooseType === "inverter" ? (
                      <NoSymFormatPrice price={object.price * qty} />
                    ) : oldBattery === true ? (
                      <NoSymFormatPrice price={object.rebate * qty} />
                    ) : (
                      <NoSymFormatPrice price={object.mrp * qty} />
                    )}
                  </span>
                </p>
              </div>
              <button
                type="button"
                className={
                  object.stock > 0
                    ? "btn add-to-cart-btn my-4 btn-primary"
                    : "btn add-to-cart-btn my-4 btn-primary disabled "
                }
                onClick={() => {
                  chooseType === "inverter"
                    ? addToCart1(object, qty, pincode)
                    : addToCart(object, qty, pincode, oldBattery);
                }}
              >
                Add to cart
              </button>
            </div>
          </div>
        </div>
      </article>
    </>
  );
};
export default AddToCart;
