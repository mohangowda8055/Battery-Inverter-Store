import { SIDEBAR_OPEN, SIDEBAR_CLOSE } from "../actions";

const sidebar_reducer = (state, action) => {
  if (action.type === SIDEBAR_OPEN) {
    return { ...state, isSidebarOpen: true };
  }
  if (action.type === SIDEBAR_CLOSE) {
    return { ...state, isSidebarOpen: false };
  }
  if (action.type === "SUBMENU_OPEN") {
    return { ...state, isSubmenuOpen: true };
  }
  if (action.type === "SUBMENU_CLOSE") {
    return { ...state, isSubmenuOpen: false };
  }

  throw new Error(`No Matching "${action.type}" - action type`);
};

export default sidebar_reducer;
