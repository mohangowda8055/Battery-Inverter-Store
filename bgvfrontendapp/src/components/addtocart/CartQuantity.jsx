import { FaMinus, FaPlus } from "react-icons/fa";

const CartQuantity = ({ qty, setIncrease, setDecrease }) => {
  return (
    <div className="cart-button">
      <div className="amount-toggle">
        <div className="qty">
          <span className="design">Quantity</span> :
        </div>
        <button onClick={() => setDecrease()}>
          <FaMinus />
        </button>
        <div className="amount-style">{qty}</div>
        <button onClick={() => setIncrease()}>
          <FaPlus />
        </button>
      </div>
    </div>
  );
};
export default CartQuantity;
