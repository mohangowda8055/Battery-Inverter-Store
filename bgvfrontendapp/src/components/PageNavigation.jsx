import { NavLink } from "react-router-dom";
import { useSidebarContext } from "../context/sidebar_context";

const PageNavigation = ({ battery }) => {
  const { closeSubmenu } = useSidebarContext();
  return (
    <div className="page-navigation" onMouseOver={closeSubmenu}>
      <NavLink to="/">Home</NavLink>/{battery.batteryModelName}
    </div>
  );
};
export default PageNavigation;
