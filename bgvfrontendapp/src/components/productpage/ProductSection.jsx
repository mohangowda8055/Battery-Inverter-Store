import cover3 from "../../assets/catbanner-03.jpg";
import cover4 from "../../assets/catbanner-04.jpg";
import { useSidebarContext } from "../../context/sidebar_context";

const ProductSection = () => {
  const { closeSubmenu } = useSidebarContext();

  return (
    <>
      <article
        id="#home"
        className="choose-section-one gradient-bg"
        onMouseOver={closeSubmenu}
      >
        <div className="container-fluid text-white">
          <div className="row ">
            <div className="col-6 col-sm-6 col-md-8 col-lg-8 heading pe-0">
              <h2 className="gradient__text">Inverter & Batteries!!</h2>
            </div>
            <div className="col-6 col-sm-6 col-md-4 col-lg-4 p-0">
              <div className="design">
                <img className="three" src={cover3} alt="" />
                <img className="four" src={cover4} alt="" />
              </div>
            </div>
          </div>
        </div>
      </article>
    </>
  );
};
export default ProductSection;
