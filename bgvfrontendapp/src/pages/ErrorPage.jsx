import { Link } from "react-router-dom";

const ErrorPage = () => {
  return (
    <>
      <section>
        <h1>404</h1>
        <h3>Sorry, the page you tried cannot be found</h3>
        <Link to="/" className="btn btn-success">
          Home
        </Link>
      </section>
    </>
  );
};
export default ErrorPage;
