import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import { CartProvider } from "./context/cart_context";
import { ProductsProvider } from "./context/products_context";
import { SidebarProvider } from "./context/sidebar_context";
import { AuthProvider } from "./context/auth_context";

import "./index.css";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <ProductsProvider>
      <SidebarProvider>
        <AuthProvider>
          <CartProvider>
            <App />
          </CartProvider>
        </AuthProvider>
      </SidebarProvider>
    </ProductsProvider>
  </React.StrictMode>
);
