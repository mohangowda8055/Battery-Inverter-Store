import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import axios from "axios";

const RegisterPage = () => {
  const [data, setData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phoneNo: "",
    password: "",
  });
  const [focus, setFocus] = useState({
    firstName: false,
    lastName: false,
    email: false,
    phoneNo: false,
    password: false,
    confirm: false,
  });

  const [otp, setOtp] = useState();

  const navigate = useNavigate();
  const [error, setError] = useState({
    errors: {},
    isError: false,
  });

  const handleChange = (event, property) => {
    setData({ ...data, [property]: event.target.value });
  };
  const handleOtp = (e) => {
    setOtp(e.target.value);
  };

  const getPassword = (pass) => {
    const result = pass.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&");
    return result;
  };

  const handleFocus = (e) => {
    setFocus({ ...focus, [e.target.name]: true });
  };

  //submit form
  const submitForm = async (event) => {
    const element = document.getElementById("wrong-otp");
    element.classList.add("visually-hidden");
    event.preventDefault();
    try {
      const email = data.email;
      const type = "register";
      const sendOtp = await axios.post("http://localhost:8080/auth/send-otp", {
        email,
        type,
      });
      if (sendOtp.data == "present") {
        const myButton = document.getElementById("myButton1");
        myButton.click();
      } else {
        const myButton = document.getElementById("myButton");
        myButton.click();
      }
    } catch (error) {
      console.log(error);
      setError({
        errors: error,
        isError: true,
      });
    }
  };

  const verifyOtp = async () => {
    const element = document.getElementById("wrong-otp");
    element.classList.add("visually-hidden");
    try {
      const email = data.email;
      const result = await axios.post("http://localhost:8080/auth/verify-otp", {
        email,
        otp,
      });
      if (result.data != "wrongotp") {
        const myButton = document.getElementById("modalClose");
        myButton.click();
        const response = await axios.post(
          "http://localhost:8080/auth/register",
          data
        );
        toast.success("user is registered successfully !!");
        setData({
          firstName: "",
          lastName: "",
          email: "",
          phoneNo: "",
          password: "",
        });
        navigate("/login");
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
      <article className="wrapper register">
        <div className="container">
          <div className="col-sm-8 offset-sm-2 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4 text-center">
            <form
              id="registrationForm"
              action=""
              className="rounded bg-white shadow p-5"
              onSubmit={submitForm}
            >
              <h3 className="text-dark fw-bolder fs-4 mb-2">
                Create an Account
              </h3>
              <div className="fw-normal text-muted mb-4">
                Already have an account?{" "}
                <Link
                  to="/login"
                  className="text-primary fw-bold text-decoration-none"
                >
                  Sign in here
                </Link>
              </div>
              <div className="form-floating mb-3">
                <input
                  type="text"
                  className="form-control"
                  id="floatingFirstName"
                  placeholder="name@example.com"
                  name="firstName"
                  onChange={(e) => handleChange(e, "firstName")}
                  onBlur={handleFocus}
                  focused={focus.firstName.toString()}
                  value={data.firstName}
                  pattern="^[A-Za-z0-9]{3,20}$"
                  required="true"
                />
                <label htmlFor="floatingFirstName">First Name</label>
                <span className="password-info mt-2">
                  no special symbols and must be between 3-15 letters
                </span>
              </div>
              <div className="form-floating mb-3">
                <input
                  type="text"
                  className="form-control"
                  id="floatingLastName"
                  placeholder="name@example.com"
                  name="lastName"
                  value={data.lastName}
                  onChange={(e) => handleChange(e, "lastName")}
                  onBlur={(e) => handleFocus(e)}
                  focused={focus.lastName.toString()}
                  pattern="^[A-Za-z0-9]{1,20}$"
                  required="true"
                />
                <label htmlFor="floatingLastName">Last Name</label>
                <span className="password-info mt-2">
                  no special symbols and must be between 1-15 letters
                </span>
              </div>
              <div className="form-floating mb-3">
                <input
                  type="email"
                  className="form-control"
                  id="floatingInput"
                  placeholder="name@example.com"
                  name="email"
                  value={data.email}
                  onChange={(e) => handleChange(e, "email")}
                  onBlur={handleFocus}
                  focused={focus.email.toString()}
                  required="true"
                />
                <label htmlFor="floatingInput">Email address</label>
                <span className="password-info mt-2">
                  Please enter valid email address
                </span>
              </div>
              <div className="form-floating mb-3">
                <input
                  type="text"
                  className="form-control"
                  id="floatingPhoneNo"
                  placeholder="name@example.com"
                  name="phoneNo"
                  value={data.phoneNo}
                  onChange={(e) => handleChange(e, "phoneNo")}
                  onBlur={handleFocus}
                  focused={focus.phoneNo.toString()}
                  pattern="^[6-9]\d{9}$"
                  required="true"
                />
                <label htmlFor="floatingPhoneNo">Phone No</label>
                <span className="password-info mt-2">
                  Enter 10 digit mobile no.
                </span>
              </div>
              <div className="form-floating mb-3">
                <input
                  type="text"
                  className="form-control"
                  id="floatingPassword"
                  placeholder="Password"
                  name="password"
                  onChange={(e) => handleChange(e, "password")}
                  onBlur={handleFocus}
                  focused={focus.password.toString()}
                  value={data.password}
                  pattern="^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,20}"
                  required="true"
                />
                <label htmlFor="floatingPassword">Password</label>
                <span className="password-info mt-2">
                  Password should be 8-20 characters and include atleast 1
                  letter, 1 number and 1 special character
                </span>
              </div>
              <div className="form-floating mb-3">
                <input
                  type="text"
                  className="form-control"
                  id="floatingConfirmPassword"
                  placeholder="Password"
                  name="confirm"
                  onBlur={handleFocus}
                  focused={focus.confirm.toString()}
                  onFocus={handleFocus}
                  pattern={getPassword(data.password)}
                  required="true"
                />
                <label htmlFor="floatingConfirmPassword">ConfirmPassword</label>
                <span className="password-info mt-2">
                  Passwords don't match
                </span>
              </div>
              <div className="form-check d-flex align-items-center">
                <input
                  className="form-check-input"
                  type="checkbox"
                  id="gridCheck"
                  checked
                />
                <label className="form-check-label ms-2" htmlFor="gridCheck">
                  i Agree <a href="">Terms & Conditions</a>
                </label>
              </div>
              <button
                type="submit"
                className="btn btn-primary submit_btn w-100 my-4"
              >
                Continue
              </button>
            </form>
            <div
              className="modal fade"
              id="exampleModal1"
              tabindex="-1"
              aria-labelledby="exampleModalLabel"
              aria-hidden="true"
            >
              <div className="modal-dialog modal-dialog-centered">
                <div className="modal-content">
                  <div className="modal-header">
                    <div
                      className="alert alert-danger"
                      id="wrong-otp"
                      role="alert"
                    >
                      OTP did not match, try again!!
                    </div>
                    <button
                      type="button"
                      className="btn-close"
                      data-bs-dismiss="modal"
                      aria-label="Close"
                    ></button>
                  </div>
                  <div className="modal-body">
                    <div
                      className="alert alert-danger"
                      id="wrong-otp"
                      role="alert"
                    >
                      Email id already registered, Go to Login Page
                    </div>
                  </div>
                  <div className="modal-footer"></div>
                </div>
              </div>
            </div>
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
                      <label htmlFor="floatingPhoneNo">Phone No</label>
                      <span className="password-info mt-2">
                        Enter 10 digit mobile no.
                      </span>
                    </div>
                  </div>
                  <div className="modal-footer">
                    <button
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
              data-bs-target="#exampleModal1"
            ></button>
            <button
              id="myButton"
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
export default RegisterPage;
