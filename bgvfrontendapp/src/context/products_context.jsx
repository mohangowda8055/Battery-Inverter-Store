import React, { useContext, useReducer } from "react";
import { useState } from "react";

const ProductsContext = React.createContext();

export const ProductsProvider = ({ children }) => {
  const [singleBattery, setSingleBattery] = useState({});
  const [singleInverter, setSingleInverter] = useState({});
  const [productType, setProductType] = useState("twov");
  const [isFuel, setFuel] = useState(false);
  const [isAddCartLogin, setAddCartLogin] = useState(false);
  const [chooseType, setChooseType] = useState("");

  return (
    <ProductsContext.Provider
      value={{
        singleBattery,
        setSingleBattery,
        singleInverter,
        setSingleInverter,
        productType,
        setProductType,
        isFuel,
        setFuel,
        isAddCartLogin,
        setAddCartLogin,
        chooseType,
        setChooseType,
      }}
    >
      {children}
    </ProductsContext.Provider>
  );
};

export const useProductsContext = () => {
  return useContext(ProductsContext);
};
