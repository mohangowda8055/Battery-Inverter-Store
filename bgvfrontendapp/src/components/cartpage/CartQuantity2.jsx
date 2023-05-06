import { FaMinus, FaPlus } from "react-icons/fa";

const CartQuantity2 = ({ qty, setIncrease, setDecrease, productId }) => {
  return (
    <div className="cart-button">
      <div className="amount-toggletwo">
        <div className="product-quantity">
          <span className="background">Quantity</span> :{" "}
        </div>
        <button
          onClick={() => {
            setDecrease(productId);
          }}
        >
          <FaMinus />
        </button>
        <div className="amount-styletwo">{qty}</div>
        <button
          onClick={() => {
            setIncrease(productId);
          }}
        >
          <FaPlus />
        </button>
      </div>
    </div>
  );
};
export default CartQuantity2;
