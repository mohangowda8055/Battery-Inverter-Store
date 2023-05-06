import React, { useContext, useReducer, useState } from "react";
import reducer from "../reducers/sidebar_reducer";
import { SIDEBAR_OPEN, SIDEBAR_CLOSE } from "../actions";
import { services } from "../utils/constants";

const initialState = {
  isSidebarOpen: false,
  isSubmenuOpen: false,
};

const SidebarContext = React.createContext();

export const SidebarProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);
  const [location, setLocation] = useState({});
  const [links, setLinks] = useState([]);

  const openSidebar = () => {
    dispatch({ type: SIDEBAR_OPEN });
  };
  const closeSidebar = () => {
    dispatch({ type: SIDEBAR_CLOSE });
  };
  const openSubmenu = (text, coordinates) => {
    setLinks(services);
    setLocation(coordinates);
    dispatch({ type: "SUBMENU_OPEN" });
  };
  const closeSubmenu = () => {
    dispatch({ type: "SUBMENU_CLOSE" });
  };

  return (
    <SidebarContext.Provider
      value={{
        ...state,
        openSidebar,
        closeSidebar,
        openSubmenu,
        closeSubmenu,
        location,
        links,
      }}
    >
      {children}
    </SidebarContext.Provider>
  );
};

export const useSidebarContext = () => {
  return useContext(SidebarContext);
};
