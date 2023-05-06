import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuthContext } from "../context/auth_context";
import axios from "axios";

const ForgotPassword = () => {
  const [email, setEmail] = useState("");
  const { setUserId } = useAuthContext();
  const navigate = useNavigate();

  const [otp, setOtp] = useState();

  const handleChange = (e) => {
    setEmail(e.target.value);
  };

  const handleOtp = (e) => {
    setOtp(e.target.value);
  };

  const handleFormSubmit = async (event) => {
    event.preventDefault();
    try {
      const sendOtp = await axios.post("http://localhost:8080/auth/send-otp", {
        email,
      });
      if (sendOtp.data == "Sent OTP") {
        const myButton = document.getElementById("myButton1");
        myButton.click();
      }
    } catch (error) {
      console.log(error);
    }
  };

  const verifyOtp = async () => {
    const element = document.getElementById("wrong-otp");
    element.classList.add("visually-hidden");
    try {
      const result = await axios.post("http://localhost:8080/auth/verify-otp", {
        email,
        otp,
      });
      if (result.data != "nouserid" && result.data != "wrongotp") {
        const num = parseInt(result.data);
        setUserId(num);
      }

      if (result.data != "nouserid" && result.data != "wrongotp") {
        const myButton = document.getElementById("modalClose");
        myButton.click();
        navigate("/update-password");
      } else {
        const element = document.getElementById("wrong-otp");
        element.classList.remove("visually-hidden");
      }
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <>
      <article className="wrapper login">
        <div className="container">
          <div className="col-sm-8 offset-sm-2 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4 text-center">
            <form
              action=""
              className="rounded bg-white shadow p-5"
              onSubmit={handleFormSubmit}
            >
              <h3 className="text-dark fw-bolder fs-4 mb-2">Forgot Password</h3>
              <div className="form-floating mb-3">
                <input
                  type="email"
                  className="form-control"
                  id="floatingInput"
                  placeholder="name@example.com"
                  value={email}
                  onChange={(e) => handleChange(e)}
                />
                <label htmlFor="floatingInput">Email address</label>
              </div>
              <button
                type="submit"
                className="btn btn-primary submit_btn w-100 my-4"
              >
                Send OTP
              </button>
            </form>
            <div
              className="modal fade"
              id="exampleModal"
              tabindex="-1"
              aria-labelledby="exampleModalLabel"
              aria-hidden="true"
            >
              <div className="modal-dialog modal-dialog-centered">
                <div className="modal-content">
                  <div className="modal-header">
                    <div
                      className="alert alert-danger visually-hidden d-block"
                      id="wrong-otp"
                      role="alert"
                    >
                      OTP did not match, try again!!
                    </div>
                    <h5 className="modal-title" id="exampleModalLabel">
                      Enter OTP sent to your mail
                    </h5>
                    <button
                      id="modalClose"
                      type="button"
                      className="btn-close"
                      data-bs-dismiss="modal"
                      aria-label="Close"
                    ></button>
                  </div>
                  <div className="modal-body">
                    <div className="form-floating mb-3">
                      <input
                        type="text"
                        className="form-control"
                        id="floatingPhoneNo"
                        placeholder="1234"
                        name="otp"
                        value={otp}
                        onChange={(e) => handleOtp(e)}
                        required
                      />
                      <label htmlFor="floatingPhoneNo">OTP</label>
                      <span className="password-info mt-2">
                        Enter 4 digit OTP
                      </span>
                    </div>
                  </div>
                  <div className="modal-footer">
                    <button
                      id="myButton"
                      type="button"
                      className="btn btn-primary"
                      onClick={verifyOtp}
                    >
                      verify
                    </button>
                  </div>
                </div>
              </div>
            </div>
            <button
              id="myButton1"
              type="submit"
              className="btn btn-light my-4 d-inline"
              data-bs-toggle="modal"
              data-bs-target="#exampleModal"
            ></button>
          </div>
        </div>
      </article>
    </>
  );
};
export default ForgotPassword;
