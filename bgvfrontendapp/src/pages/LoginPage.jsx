import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { useAuthContext } from "../context/auth_context";
import axios from "axios";
import { useProductsContext } from "../context/products_context";

const LoginPage = () => {
  const [loginDetail, setLoginDetail] = useState({
    username: "",
    password: "",
  });

  const { doLogin } = useAuthContext();
  const { isAddCartLogin } = useProductsContext();
  const navigate = useNavigate();

  const handleChange = (event, field) => {
    let actualValue = event.target.value;
    setLoginDetail({
      ...loginDetail,
      [field]: actualValue,
    });
  };

  const handleFormSubmit = async (event) => {
    event.preventDefault();
    if (
      loginDetail.username.trim() == "" ||
      loginDetail.password.trim() == ""
    ) {
      toast.error("username or password is required !!");
      return;
    }
    try {
      const response = await axios.post(
        "http://localhost:8080/auth/login",
        loginDetail
      );

      doLogin(response, () => {});
      isAddCartLogin ? navigate("/addtocart") : navigate("/");
      toast.success("user logged in successfully !!");
    } catch (error) {
      console.log(error);
      if (error.response?.status == 400 || error.response?.status == 404) {
        const myButton = document.getElementById("myButton1");
        myButton.click();
      } else toast.error("Something went wrong !!");
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
              <h3 className="text-dark fw-bolder fs-4 mb-2">Sign In</h3>
              <div className="fw-normal text-muted mb-4">
                New Here?{" "}
                <Link
                  to="/register"
                  className="text-primary fw-bold text-decoration-none"
                >
                  Create Account
                </Link>
              </div>
              <div className="form-floating mb-3">
                <input
                  type="email"
                  className="form-control"
                  id="floatingInput"
                  placeholder="name@example.com"
                  value={loginDetail.username}
                  onChange={(e) => handleChange(e, "username")}
                />
                <label htmlFor="floatingInput">Email address</label>
              </div>
              <div className="form-floating">
                <input
                  type="password"
                  className="form-control"
                  id="floatingPassword"
                  placeholder="Password"
                  value={loginDetail.password}
                  onChange={(e) => handleChange(e, "password")}
                />
                <label htmlFor="floatingPassword">Password</label>
              </div>
              <div className="mt-2 text-end">
                <Link
                  to="/forgot"
                  className="text-primary fw-bold text-decoration-none"
                >
                  Forget Password?
                </Link>
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
              tabIndex="-1"
              aria-labelledby="exampleModalLabel"
              aria-hidden="true"
            >
              <div className="modal-dialog modal-dialog-centered">
                <div className="modal-content">
                  <div className="modal-header">
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
                      Invalid username or password
                    </div>
                  </div>
                  <div className="modal-footer"></div>
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
          </div>
        </div>
      </article>
    </>
  );
};
export default LoginPage;
