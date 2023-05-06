import React, { useContext, useReducer } from "react";
import { useState } from "react";

// const initialState = {
//   brand_id: "",
//   model_id: "",
//   brands_loading: false,
//   brands_error: false,
//   brands: [],
//   models_loading: false,
//   models_error: false,
//   models: [],
//   battery_loading: false,
//   battery_error: false,
//   battery: [],
//   enable: true,
// };

const ProductsContext = React.createContext();

export const ProductsProvider = ({ children }) => {
  // const [state, dispatch] = useReducer(reducer, initialState);
  const [singleBattery, setSingleBattery] = useState({});
  const [singleInverter, setSingleInverter] = useState({});
  const [productType, setProductType] = useState("twov");
  const [isFuel, setFuel] = useState(false);
  const [isAddCartLogin, setAddCartLogin] = useState(false);
  const [chooseType, setChooseType] = useState("");

  return (
    <ProductsContext.Provider
      value={{
        // ...state,
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
