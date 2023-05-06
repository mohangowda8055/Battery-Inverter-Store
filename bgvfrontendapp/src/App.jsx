import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { HomePage } from "./pages/HomePage";
import { SharedLayout } from "./pages/SharedLayout";
import AboutPage from "./pages/AboutPage";
import ContactPage from "./pages/ContactPage";
import ProductsPage from "./pages/ProductsPage";
import SingleProductPage from "./pages/SingleProductPage";
import CartPage from "./pages/CartPage";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import OrderDetailPage from "./pages/OrderDetailPage";
import OrdersPage from "./pages/OrdersPage";
import SingleInvBattery from "./pages/SingleInvBattery";
import ScrollToTop from "./helpers/ScrollToTop";
import ForgotPassword from "./pages/ForgotPassword";
import UpdatePassword from "./pages/UpdatePassword";

function App() {
  return (
    <BrowserRouter>
      <ScrollToTop />
      <ToastContainer position="bottom-center" />
      <Routes>
        <Route path="/" element={<SharedLayout />}>
          <Route index element={<HomePage />} />
          <Route path="about" element={<AboutPage />} />
          <Route path="contact" element={<ContactPage />} />
          <Route path="products" element={<ProductsPage />} />
          <Route path="invbattery" element={<SingleInvBattery />} />
          <Route path="addtocart" element={<SingleProductPage />} />
          <Route path="cart" element={<CartPage />} />
          <Route path="placeOrder" element={<OrderDetailPage />} />
          <Route path="orders" element={<OrdersPage />} />
          <Route path="login" element={<LoginPage />} />
          <Route path="register" element={<RegisterPage />} />
          <Route path="forgot" element={<ForgotPassword />} />
          <Route path="update-password" element={<UpdatePassword />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
