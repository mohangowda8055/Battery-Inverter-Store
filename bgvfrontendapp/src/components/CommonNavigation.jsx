import { NavLink } from "react-router-dom";
import { useSidebarContext } from "../context/sidebar_context";

const CommonNavigation = ({ page }) => {
  const { closeSubmenu } = useSidebarContext();
  return (
    <div className="page-navigation" onMouseOver={closeSubmenu}>
      <NavLink to="/">Home</NavLink>/{page}
    </div>
  );
};
export default CommonNavigation;
