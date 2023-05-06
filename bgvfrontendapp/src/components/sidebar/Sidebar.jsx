import React from "react";
import logo from "../../assets/vite.svg";
import { Link, NavLink } from "react-router-dom";
import { FaTimes, FaUserAlt } from "react-icons/fa";
import { useSidebarContext } from "../../context/sidebar_context";
import { CartButtons } from "../navbar/CartButtons";
import { useAuthContext } from "../../context/auth_context";
import { useProductsContext } from "../../context/products_context";

const Sidebar = () => {
  const { isSidebarOpen, closeSidebar } = useSidebarContext();
  const { doLogout, login } = useAuthContext();
  const { setProductType, setFuel, setChooseType } = useProductsContext();

  const handleProductType = (type, fuel) => {
    setProductType(type);
    setFuel(fuel);
  };

  const logout = () => {
    doLogout();
  };

  return (
    <aside className={`${isSidebarOpen ? "sidebar show-sidebar" : "sidebar"}`}>
      <div className="sidebar-header">
        <img src={logo} className="logo" alt="coding addict" />
        <button className="close-btn" onClick={closeSidebar}>
          <FaTimes />
        </button>
      </div>
      <ul className="links">
        <li className="nav-item dropdown pe-3" data-bs-display="static">
          <Link
            to="#"
            className="nav-link dropdown-toggle nav-anc"
            id="navbarDarkDropdownMenuLink"
            role="button"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            Products
          </Link>
          <ul
            className={`${
              isSidebarOpen
                ? "dropdown-menu dropdown-menu-white"
                : "dropdown-menu dropdown-menu-white"
            }`}
            aria-labelledby="navbarDarkDropdownMenuLink"
          >
            <li>
              <Link
                to="/products"
                className="dropdown-item "
                onClick={() => {
                  handleProductType("twov", false);
                  setChooseType("battery");
                  closeSidebar();
                }}
              >
                Two Wheeler
              </Link>
            </li>
            <li>
              <Link
                to="/products"
                className="dropdown-item "
                onClick={() => {
                  handleProductType("fourv", true);
                  setChooseType("battery");
                  closeSidebar();
                }}
              >
                Four Wheeler
              </Link>
            </li>
            <li>
              <Link
                to="/products"
                className="dropdown-item "
                onClick={() => {
                  handleProductType("threev", false);
                  setChooseType("battery");
                  closeSidebar();
                }}
              >
                Three Wheeler
              </Link>
            </li>
            <li>
              <Link
                to="/products"
                className="dropdown-item"
                onClick={() => {
                  handleProductType("inv", false);
                  setChooseType("inverter");
                  closeSidebar();
                }}
              >
                Inverter
              </Link>
            </li>
            <li>
              <Link
                to="/products"
                className="dropdown-item"
                onClick={() => {
                  handleProductType("invbattery", false);
                  setChooseType("inverterbattery");
                  closeSidebar();
                }}
              >
                Inverter Battery
              </Link>
            </li>
            <li>
              <Link className="dropdown-item" onClick={closeSidebar}>
                Others
              </Link>
            </li>
          </ul>
        </li>
        <li className="nav-item pe-3">
          <a
            href="#about"
            onClick={closeSidebar}
            className="nav-link nav-anc"
            aria-current="page"
          >
            About
          </a>
        </li>
        <li className="nav-item pe-3">
          <a
            className="nav-link nav-anc"
            aria-current="page"
            href="#contact"
            onClick={closeSidebar}
          >
            Contact
          </a>
        </li>
        {login && (
          <li className="nav-item pe-3">
            <NavLink
              to="/orders"
              className="nav-link nav-anc"
              aria-current="page"
              href="#contact"
              onClick={closeSidebar}
            >
              Orders
            </NavLink>
          </li>
        )}
        {login && (
          <li className="nav-item pe-3">
            <CartButtons />
          </li>
        )}
        {login && (
          <li className="nav-item pe-3">
            <Link
              to="/"
              onClick={() => {
                logout();
                closeSidebar();
              }}
              className="nav-link nav-anc"
            >
              <span>
                <FaUserAlt />
              </span>
              <span className="nav-image ps-1"> Logout</span>
            </Link>
          </li>
        )}
        {!login && (
          <li className="nav-item pe-3">
            <Link
              to="/login"
              onClick={closeSidebar}
              className="nav-link nav-anc"
            >
              <span>
                <FaUserAlt />
              </span>
              <span className="nav-image ps-1"> Login</span>
            </Link>
          </li>
        )}
      </ul>
    </aside>
  );
};

export default Sidebar;
