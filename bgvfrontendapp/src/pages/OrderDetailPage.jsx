import { useCartContext } from "../context/cart_context";
import { useAuthContext } from "../context/auth_context";
import { useState } from "react";
import axios from "axios";
import CommonNavigation from "../components/CommonNavigation";
import FormatPrice from "../helpers/FormatPrice";

const OrderDetailPage = () => {
  const { total_amount } = useCartContext();
  const { getToken } = useAuthContext();
  const token = getToken();
  const delivery_fee = 50;
  const grandTotal = total_amount + delivery_fee;
  const [pincode, setPincode] = useState("");
  const [address, setAddress] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const cash = "Cash On Delivery";
  const online = "Online";
  const [payOption, setPayOption] = useState(online);

  const handlePincode = (e) => {
    setPincode(e.target.value);
  };

  const handleAddress = (e) => {
    setAddress(e.target.value);
  };

  const handlePhoneNo = (e) => {
    setPhoneNo(e.target.value);
  };

  const handlePaymentType = (e) => {
    setPayOption(e.target.value);
  };

  const placeOrder = async () => {
    if (payOption == cash) {
      try {
        const response = await axios.post(
          `http://localhost:8080/order/create`,
          {
            paymentAmt: grandTotal,
            paymentType: payOption,
            deliveryPincode: pincode,
            deliveryAddress: address,
            phoneNo: phoneNo,
          },
          {
            headers: { Authorization: `Bearer ${token}` },
          }
        );
        const response2 = await axios.delete(
          `http://localhost:8080/cart/delete-all`,
          {
            headers: { Authorization: `Bearer ${token}` },
          }
        );
      } catch (error) {
        console.log(error);
      }
    } else {
      console.log("Only cash on delivery!!");
    }
  };

  return (
    <>
      <article className="order-summary">
        <CommonNavigation page={"Order Summary"}></CommonNavigation>
        <form action="" onSubmit={placeOrder}>
          <div className="p-2 pt-4">
            <h6>Deliver to:</h6>
            <div class="mb-3">
              <label for="exampleFormControlTextarea1" className="form-label">
                Address:
              </label>
              <textarea
                className="form-control"
                id="exampleFormControlTextarea1"
                rows="3"
                placeholder="Address"
                name="address"
                value={address}
                onChange={handleAddress}
                required
              ></textarea>
              <label for="inputPassword2" className="form-label pt-2">
                Pincode:
              </label>
              <input
                type="text"
                className="form-control"
                id="inputPassword2"
                placeholder="Pincode"
                name="pincode"
                value={pincode}
                onChange={handlePincode}
                required
              />
              <label for="phoneNumber" className="form-label pt-2">
                PhoneNo:
              </label>
              <input
                type="text"
                className="form-control"
                id="phoneNumber"
                placeholder="PhoneNo"
                name="phoneNo"
                value={phoneNo}
                onChange={handlePhoneNo}
                required
              />
            </div>
          </div>
          <div className="p-2">
            <h6>Price Details:</h6>
            <div className="container order-total--amount  text-light">
              <div className="row ">
                <div className="col-6 col-sm-6 col-md-2 col-lg-2 order-total--subdata ">
                  <div>
                    <p>
                      <span>Price</span>
                    </p>
                  </div>
                  <div>
                    <p>
                      <span>Shipping Fee</span>
                    </p>
                  </div>
                  <div>
                    <p>
                      <span className="tot">Total Amount</span>
                    </p>
                  </div>
                </div>
                <div className="col-6 col-sm-6 col-md-2 col-lg-2 order-total--subdata data">
                  <div className="data mt-1">
                    <p className="price">
                      {" "}
                      : {<FormatPrice price={total_amount} />}
                    </p>
                  </div>
                  <div className="data mt-2">
                    <p className="price">
                      {" "}
                      : {<FormatPrice price={delivery_fee} />}
                    </p>
                  </div>
                  <div className="data mt-1">
                    <p className="total">
                      {" "}
                      : {<FormatPrice price={grandTotal} />}
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="p-2">
            <h6>Payment Options:</h6>
            <div class="form-check">
              <input
                className="form-check-input "
                type="radio"
                name="payOption"
                value={online}
                id="flexRadioDefault1"
                onChange={handlePaymentType}
                checked={payOption == online}
              />
              <label className="form-check-label" for="flexRadioDefault1">
                Online Payment
              </label>
            </div>
            <div className="form-check">
              <input
                className="form-check-input"
                type="radio"
                name="payOption"
                value={cash}
                id="flexRadioDefault2"
                onChange={handlePaymentType}
                checked={payOption == cash}
              />
              <label className="form-check-label" for="flexRadioDefault2">
                Cash On Delivery
              </label>
            </div>
          </div>
          <div className="cart-order-btn">
            <button type="submit" className="btn btn-primary mx-2 ">
              Pay
            </button>
          </div>
        </form>
      </article>
    </>
  );
};
export default OrderDetailPage;
