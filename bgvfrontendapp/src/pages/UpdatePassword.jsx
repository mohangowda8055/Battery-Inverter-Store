import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuthContext } from "../context/auth_context";
import axios from "axios";

const UpdatePassword = () => {
  const [password, setPassword] = useState("");
  const { userId } = useAuthContext();
  const navigate = useNavigate();

  const handleChange = (e) => {
    setPassword(e.target.value);
  };

  const handleFormSubmit = async (event) => {
    event.preventDefault();
    try {
      const result = await axios.put(
        `http://localhost:8080/auth/update-password?userId=${userId}`,
        {
          password,
        }
      );
      navigate("/login");
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
              <h3 className="text-dark fw-bolder fs-4 mb-2">Update Password</h3>
              <div className="form-floating">
                <input
                  type="password"
                  className="form-control"
                  id="floatingPassword"
                  placeholder="Password"
                  value={password}
                  onChange={(e) => handleChange(e)}
                />
                <label htmlFor="floatingPassword">Password</label>
              </div>
              <button
                type="submit"
                className="btn btn-primary submit_btn w-100 my-4"
              >
                Submit
              </button>
            </form>
          </div>
        </div>
      </article>
    </>
  );
};
export default UpdatePassword;
