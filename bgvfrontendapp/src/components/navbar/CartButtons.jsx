import { FaShoppingCart } from "react-icons/fa";
import { Link } from "react-router-dom";
import { useSidebarContext } from "../../context/sidebar_context";

export const CartButtons = () => {
  const { closeSidebar } = useSidebarContext();
  return (
    <>
      <Link
        to="/cart"
        onClick={() => {
          closeSidebar();
        }}
        className="nav-link nav-anc"
        href="#contact"
      >
        <span>
          <FaShoppingCart />
        </span>
        <span className="nav-image ps-1"> Cart</span>
      </Link>
    </>
  );
};
