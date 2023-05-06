import { Link, NavLink } from "react-router-dom";
import logo from "../../assets/vite.svg";
import { CartButtons } from "./CartButtons";
import { FaUserAlt, FaBars, FaTimes } from "react-icons/fa";
import React from "react";
import { useSidebarContext } from "../../context/sidebar_context";
import { useAuthContext } from "../../context/auth_context";

const Navbar = () => {
  const {
    isSidebarOpen,
    openSidebar,
    closeSidebar,
    openSubmenu,
    closeSubmenu,
  } = useSidebarContext();
  const { doLogout, login } = useAuthContext();

  const logout = () => {
    doLogout();
  };

  const displaySubmenu = (e) => {
    const page = e.target.textContent;
    const tempBtn = e.target.getBoundingClientRect();
    const center = (tempBtn.left + tempBtn.right) / 2;
    const bottom = tempBtn.bottom - 3;
    openSubmenu(page, { center, bottom });
  };

  return (
    <>
      <nav className={`${isSidebarOpen ? " fixed-top" : " fixed-top "}`}>
        <div className="nav-center">
          <div className="nav-header ">
            {isSidebarOpen ? (
              ""
            ) : (
              <button onClick={openSidebar} className="nav-toggle">
                <FaBars />
              </button>
            )}
            {isSidebarOpen ? (
              <button className="close-btn" onClick={closeSidebar}>
                <FaTimes />
              </button>
            ) : (
              ""
            )}
            <Link to="/" onClick={closeSubmenu} className="nav-anc">
              <img src={logo} alt="logo" className="logo" />
              <span className="text-white"> BGV</span>
            </Link>
          </div>
          <div className="links-container">
            <ul className="links">
              <li className="nav-item pe-3">
                <a
                  href="#about"
                  onClick={closeSidebar}
                  className="nav-link nav-anc only"
                  aria-current="page"
                  onMouseOver={displaySubmenu}
                >
                  Products
                </a>
              </li>
              <li className="nav-item pe-3">
                <a
                  href="#about"
                  onClick={closeSubmenu}
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
                  onClick={closeSubmenu}
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
                    onClick={closeSubmenu}
                  >
                    Orders
                  </NavLink>
                </li>
              )}
              {login && (
                <li className="nav-item pe-3 ">
                  <CartButtons />
                </li>
              )}
              {login && (
                <li className="nav-item pe-3">
                  <Link to="/" onClick={logout} className="nav-link nav-anc">
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
                    className="nav-link nav-anc"
                    onClick={closeSubmenu}
                  >
                    <span>
                      <FaUserAlt />
                    </span>
                    <span className="nav-image ps-1"> Login</span>
                  </Link>
                </li>
              )}
            </ul>
          </div>
        </div>
      </nav>
    </>
  );
};
export default Navbar;
