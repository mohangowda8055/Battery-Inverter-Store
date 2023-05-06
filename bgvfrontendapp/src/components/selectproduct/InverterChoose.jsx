import { useState, useEffect, useRef } from "react";
import InverterList from "../productpage/InverterList";
import axios from "axios";

const InverterChoose = () => {
  const [capacity, setCapacity] = useState([]);
  const [capacityId, setCapacityId] = useState("");
  const [inverter, setInverter] = useState([]);
  const scrollToRef = useRef(null);

  useEffect(() => {
    const fetchCapacity = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/inv/capacity`);
        const result = response.data;
        setCapacity(result);
      } catch (error) {
        console.log(error);
      }
    };
    fetchCapacity();
  }, []);

  const handleCapacity = (e) => {
    const capacityId = e.target.value;
    setCapacityId(capacityId);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (capacityId !== "") {
      try {
        const response = await axios.get(
          `http://localhost:8080/inv/inverter-battery?capacityId=${capacityId}`
        );
        const getInverter = response.data;
        setInverter(await getInverter);
        if (scrollToRef.current) {
          scrollToRef.current.scrollIntoView({ behavior: "smooth" });
        }
      } catch (error) {
        console.log(error);
      }
    } else {
      throw new Error("Capacity is null");
    }
  };
  return (
    <>
      <div className="products-page">
        <article className="choose-section-two pb-5 ">
          <div className="battery-form pt-3">
            <h3>Choose your Inverter</h3>
          </div>
          <div className="container mt-4 ">
            <form action="" onSubmit={(e) => handleSubmit(e)}>
              <div className="row">
                <div className="col-md-12">
                  <div className="row gx-3 gy-2 align-items-center ">
                    <div className="col-sm-3">
                      <label htmlFor="specificSizeSelect">Capacity</label>
                      <select
                        className="form-select"
                        id="specificSizeSelect"
                        name="capacityId"
                        value={capacityId}
                        onChange={(e) => handleCapacity(e)}
                        required
                      >
                        <option value={""} disabled>
                          --Select--
                        </option>
                        {capacity.map((cap) => {
                          const { id, capacity } = cap;
                          return (
                            <option key={id} value={id}>
                              {capacity} AH
                            </option>
                          );
                        })}
                      </select>
                    </div>
                    <div></div>
                    <div></div>
                    <div className="col-auto choose-button">
                      <button type="submit" className="btn btn-primary">
                        Submit
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </article>
        <InverterList inverter={inverter} scrollToRef={scrollToRef} />
      </div>
    </>
  );
};
export default InverterChoose;
