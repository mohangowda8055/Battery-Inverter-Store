import React, { useContext, useReducer, useState } from "react";
import reducer from "../reducers/auth_reducer";

const isLoggedin = () => {
  let data = localStorage.getItem("data");
  if (data != null) {
    return true;
  } else {
    return false;
  }
};

const initialState = {
  login: isLoggedin(),
};

const AuthContext = React.createContext();

export const AuthProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);
  const [userId, setUserId] = useState();

  //isLogin
  const isLoggedIn = () => {
    let data = localStorage.getItem("data");

    if (data != null) {
      dispatch({ type: "ISLOGGEDIN" });
    } else {
      dispatch({ type: "ISLOGGEDOUT" });
    }
  };

  //doLogin
  const doLogin = (data, next) => {
    localStorage.setItem("data", JSON.stringify(data));
    isLoggedIn();
    next();
  };

  //doLogout
  const doLogout = (next) => {
    localStorage.removeItem("data");
    isLoggedIn();
    next();
  };

  const getToken = () => {
    if (isLoggedin) {
      const token = JSON.parse(localStorage.getItem("data")).data.token;
      return token;
    } else {
      return null;
    }
  };

  return (
    <AuthContext.Provider
      value={{
        ...state,
        isLoggedIn,
        doLogin,
        doLogout,
        getToken,
        userId,
        setUserId,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export const useAuthContext = () => {
  return useContext(AuthContext);
};
