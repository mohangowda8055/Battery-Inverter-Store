import { Link } from "react-router-dom";
import { MdOutlineMail } from "react-icons/md";
import { BsTelephoneOutbound } from "react-icons/bs";
import { TfiLocationPin } from "react-icons/tfi";
const Footer = () => {
  return (
    <>
      <footer className="py-4">
        <div className="container">
          <div className="row">
            <div className=" footer-top col-12 col-sm-12 col-md-6 col-lg-6 pb-2">
              <div className="footer-top-data email">
                <div className="pe-2">
                  <img src="src/assets/newsletter.png" alt="newsletter" />
                </div>
                <h3 className="text-white">Write any query</h3>
              </div>
            </div>
            <div className="col-12 col-sm-12 col-md-6 col-lg-6 ">
              <div className=" footer-top-data input-group ms-auto">
                <input
                  type="text"
                  className="form-control"
                  placeholder="Your Queiry"
                  aria-label="Your Email Address"
                  aria-describedby="basic-addon2"
                />
                <span className="input-group-text" id="basic-addon2">
                  Send
                </span>
              </div>
            </div>
          </div>
        </div>
      </footer>
      <footer className="py-4">
        <div className="container">
          <div className="row justify-content-evenly">
            <div className="col-12 col-sm-12 col-md-4 col-lg-4 py-3 ps-4">
              <h4 className="mb-3 info">Information</h4>
              <div className="footer-links d-flex flex-column">
                <Link className="text-white py-1 mb-0">Privacy Policy</Link>
                <Link className="text-white py-1 mb-0">Refund Policy</Link>
                <Link className="text-white py-1 mb-0">Shipping Policy</Link>
                <Link className="text-white py-1 mb-0">Terms & Conditions</Link>
                <Link className="text-white py-1 mb-0">About Us</Link>
              </div>
            </div>
            <div className="col-12 col-sm-12 col-md-4 col-lg-4 py-3 ps-4">
              <h4 className="mb-3 contact">Contact Us</h4>
              <div>
                <a
                  href="mailto:gaganmahaesh337@gmail.com"
                  className="mt-1 d-block mb-0 text-white"
                >
                  <span>
                    <MdOutlineMail size={20} color={"white"} />
                  </span>{" "}
                  gaganmahaesh337@gmail.com
                </a>
                <a
                  href="tel:+91 9980524751"
                  className="mt-2 d-block mb-2 text-white"
                >
                  <span className="pe-2">
                    <BsTelephoneOutbound size={18} color={"white"} />
                  </span>
                  +91 9980524751
                </a>
                <address className="text-white fs-12">
                  <span>
                    <TfiLocationPin size={18} color={"white"} />
                  </span>{" "}
                  <span>No. 73, Agrahara Dasarahalli,</span>
                  <br /> <span className="ps-3">
                    Magadi Main Road,
                  </span> <br />{" "}
                  <span className="ps-3">(near Veeresh Cinemas),</span>
                  <br />{" "}
                  <span className="ps-3">
                    Bangalore <br />
                    <span className="ps-3">PinCode: 560079</span>
                  </span>
                </address>
              </div>
            </div>
          </div>
        </div>
      </footer>
      <footer>
        <div className="footer-bottom">
          <div className="container">
            <div className="row justify-content-between text-white">
              <div className="col-12 col-sm-12 col-md-12 col-1g-12">
                <p className="mt-2 text-center">
                  Copyright by &copy; BGV - {new Date().getFullYear()} Powered
                  by Mohan Gowda
                </p>
              </div>
            </div>
          </div>
        </div>
      </footer>
    </>
  );
};
export default Footer;
