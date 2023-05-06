import React, { useContext, useState } from "react";

const CartContext = React.createContext();

export const CartProvider = ({ children }) => {
  const [total_amount, setTotal_Amount] = useState(0);

  return (
    <CartContext.Provider
      value={{
        total_amount,
        setTotal_Amount,
      }}
    >
      {children}
    </CartContext.Provider>
  );
};

export const useCartContext = () => {
  return useContext(CartContext);
};
