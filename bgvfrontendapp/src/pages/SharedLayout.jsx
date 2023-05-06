import { Outlet } from "react-router-dom";
import Footer from "../components/footer/Footer";
import Navbar from "../components/navbar/Navbar";
import Sidebar from "../components/sidebar/Sidebar";
import Submenu from "../components/submenu/Submenu";
export const SharedLayout = () => {
  return (
    <>
      <Navbar />
      <Sidebar />
      <Submenu />
      <Outlet />
      <Footer />
    </>
  );
};
