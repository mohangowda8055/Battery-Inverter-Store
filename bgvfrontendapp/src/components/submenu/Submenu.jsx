import { useEffect, useRef } from "react";
import { Link } from "react-router-dom";
import { useSidebarContext } from "../../context/sidebar_context";
import { useProductsContext } from "../../context/products_context";

const Submenu = () => {
  const { isSubmenuOpen, location, closeSubmenu } = useSidebarContext();
  const { setProductType, setFuel, setChooseType } = useProductsContext();
  const container = useRef(null);

  const handleProductType = (type, fuel) => {
    setProductType(type);
    setFuel(fuel);
  };

  useEffect(() => {
    const submenu = container.current;
    const { center, bottom } = location;
    submenu.style.left = `${center}px`;
    submenu.style.top = `${bottom}px`;
  }, [location]);

  return (
    <>
      <aside
        className={`${isSubmenuOpen ? "submenu show" : "submenu "}`}
        ref={container}
      >
        <div className={`submenu-center col-2`}>
          <Link
            to="/products"
            onClick={() => {
              handleProductType("twov", false);
              setChooseType("battery");
              closeSubmenu();
            }}
          >
            Two Wheelers
          </Link>
          <Link
            to="/products"
            onClick={() => {
              handleProductType("fourv", true);
              setChooseType("battery");
              closeSubmenu();
            }}
          >
            Four Wheelers
          </Link>
          <Link
            to="/products"
            onClick={() => {
              handleProductType("threev", false);
              setChooseType("battery");
              closeSubmenu();
            }}
          >
            Three Wheelers
          </Link>
          <Link
            to="/products"
            onClick={() => {
              handleProductType("inv", false);
              setChooseType("inverter");
              closeSubmenu();
            }}
          >
            Inverter
          </Link>
          <Link
            to="/products"
            onClick={() => {
              handleProductType("invbattery", false);
              setChooseType("inverterbattery");
              closeSubmenu();
            }}
          >
            Inverter Battery
          </Link>
          <Link
            to="/products"
            onClick={() => {
              closeSubmenu();
            }}
          >
            Others
          </Link>
        </div>
      </aside>
    </>
  );
};
export default Submenu;
