import { RiMotorbikeFill, RiCarFill } from "react-icons/ri";
import { MdElectricRickshaw } from "react-icons/md";
import { GiCarBattery } from "react-icons/gi";
import { FaCarBattery, FaTractor } from "react-icons/fa";
import { Link } from "react-router-dom";
import { useProductsContext } from "../../context/products_context";

const HomeProductsSection = () => {
  const { setProductType, setFuel, setChooseType } = useProductsContext();

  const handleProductType = (type, fuel) => {
    setProductType(type);
    setFuel(fuel);
  };
  return (
    <>
      <article className="home-wrapper-2">
        <div className="container-fluid">
          <div className="row mb-5">
            <div className="col-12 col-md-12 col-lg-12">
              <h2 className="service-title  text-center">
                Click on type of battery or inverter you need
              </h2>
            </div>
          </div>
          <div className="row">
            <div className=" services col-11 col-sm-11 col-md-12 col-lg-12">
              <div className=" gap-15 card ">
                <Link
                  to="/products"
                  onClick={() => {
                    handleProductType("twov", false);
                    setChooseType("battery");
                  }}
                >
                  <span className="figure">
                    <RiMotorbikeFill size={35}></RiMotorbikeFill>
                  </span>
                  <h6 className="service-name">
                    Two
                    <br />
                    Wheelers
                  </h6>
                </Link>
              </div>
              <div className=" gap-15 card ">
                <Link
                  to="/products"
                  onClick={() => {
                    handleProductType("fourv", true);
                    setChooseType("battery");
                  }}
                >
                  <span className="figure">
                    <RiCarFill size={35}></RiCarFill>
                  </span>
                  <h6 className="service-name">
                    Four
                    <br />
                    Wheelers
                  </h6>
                </Link>
              </div>
              <div className=" gap-15 card ">
                <Link
                  to="/products"
                  onClick={() => {
                    handleProductType("threev", false);
                    setChooseType("battery");
                  }}
                >
                  <span className="figure">
                    <MdElectricRickshaw size={35}></MdElectricRickshaw>
                  </span>
                  <h6 className="service-name">
                    Three
                    <br />
                    Wheelers
                  </h6>
                </Link>
              </div>
              <div className=" gap-15 card ">
                <Link
                  to="/products"
                  onClick={() => {
                    handleProductType("inv", false);
                    setChooseType("inverter");
                  }}
                >
                  <span className="figure">
                    <GiCarBattery size={35}></GiCarBattery>
                  </span>
                  <h6 className="service-name">
                    Inverters
                    <br />
                  </h6>
                </Link>
              </div>
              <div className=" gap-15 card ">
                <Link
                  to="/products"
                  onClick={() => {
                    handleProductType("invbattery", false);
                    setChooseType("inverterbattery");
                  }}
                >
                  <span className="figure">
                    <FaCarBattery size={35}></FaCarBattery>
                  </span>
                  <h6 className="service-name">
                    Inverter
                    <br />
                    Battery
                  </h6>
                </Link>
              </div>
              <div className=" gap-15 card ">
                <a href="">
                  <span className="figure">
                    <FaTractor size={35}></FaTractor>
                  </span>
                  <h6 className="service-name">
                    Others
                    <br />
                  </h6>
                </a>
              </div>
            </div>
          </div>
        </div>
      </article>
    </>
  );
};
export default HomeProductsSection;
