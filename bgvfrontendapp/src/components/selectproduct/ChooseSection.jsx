import axios from "axios";
import { useEffect, useState, useRef } from "react";
import ProductsList from "../productpage/ProductsList";
import { useProductsContext } from "../../context/products_context";

const ChooseSection = () => {
  const { productType, isFuel } = useProductsContext();
  const scrollToRef = useRef(null);
  const url = `http://localhost:8080/${productType}/brand`;
  const modelUrl = `http://localhost:8080/${productType}/model`;
  const batteryUrl = `http://localhost:8080/${productType}/batteries`;

  const [brands, setBrands] = useState([]);
  const [brandId, setBrandId] = useState("");
  const [models, setModels] = useState([]);
  const [fuelId, setFuelId] = useState("");
  const [modelId, setModelId] = useState("");
  const [battery, setBattery] = useState([]);
  const [enable, setEnable] = useState(true);

  useEffect(() => {
    const fetchBrands = async () => {
      try {
        const response = await axios.get(url);
        const getBrands = response.data;
        setBrands(getBrands);
      } catch (error) {
        console.log(error);
      }
    };
    fetchBrands(url);
  }, [productType]);

  const setBrand = async (e) => {
    const brandId = e.target.value;
    if (brandId !== "") {
      try {
        const response = await axios.get(`${modelUrl}?brandId=${brandId}`);
        const getModels = response.data;
        setModels(await getModels);
        setBrandId(brandId);
        setEnable(false);
      } catch (error) {
        console.log(error);
      }
    } else {
      setModels([]);
      setEnable(true);
    }
  };

  const setModel = (e) => {
    const modelId = e.target.value;
    setModelId(modelId);
  };

  const setFuel = (e) => {
    const fuelId = e.target.value;
    setFuelId(fuelId);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (modelId !== "") {
      try {
        const response = await axios.get(
          isFuel
            ? `${batteryUrl}?fuelId=${fuelId}&modelId=${modelId}`
            : `${batteryUrl}?modelId=${modelId}`
        );
        const getBattery = response.data;
        setBattery(await getBattery);
        if (scrollToRef.current) {
          scrollToRef.current.scrollIntoView({ behavior: "smooth" });
        }
      } catch (error) {
        console.log(error);
      }
    } else {
      throw new Error("Model is null");
    }
  };

  return (
    <>
      <div className="products-page">
        <article className="choose-section-two pb-5 ">
          <div className="battery-form pt-3">
            <h3>Choose your battery !</h3>
          </div>
          <div className="container mt-4 ">
            <form action="" onSubmit={(e) => handleSubmit(e)}>
              <div className="row">
                <div className="col-md-12">
                  <div className="row gx-3 gy-2 align-items-center ">
                    <div className="col-sm-3">
                      <label htmlFor="specificSizeSelect">Brand</label>
                      <select
                        className="form-select"
                        id="specificSizeSelect"
                        name="brandId"
                        value={brandId}
                        onChange={(e) => setBrand(e)}
                        required
                      >
                        <option value={""} disabled>
                          --Select--
                        </option>
                        {brands.map((brand) => {
                          const { id, brandName } = brand;
                          return (
                            <option key={id} value={id}>
                              {brandName}
                            </option>
                          );
                        })}
                      </select>
                    </div>
                    <div className="col-sm-3">
                      <label htmlFor="specificSizeSelect">Model</label>
                      <select
                        className="form-select"
                        id="specificSizeSelect"
                        name="modelId"
                        value={modelId}
                        disabled={enable}
                        onChange={(e) => setModel(e)}
                        required
                      >
                        <option value={""} disabled>
                          --Select--
                        </option>
                        {models.map((model) => {
                          const { id, modelName } = model;
                          return (
                            <option key={id} value={id}>
                              {modelName}
                            </option>
                          );
                        })}
                      </select>
                    </div>
                    {isFuel && (
                      <div className="col-sm-3">
                        <label htmlFor="specificSizeSelect">Fuel Type</label>
                        <select
                          className="form-select"
                          id="specificSizeSelect"
                          name="fuelId"
                          value={fuelId}
                          disabled={enable}
                          onChange={(e) => setFuel(e)}
                          required
                        >
                          <option value={""} disabled>
                            --Select--
                          </option>
                          <option value={1}>Petrol</option>
                          <option value={2}>Disel</option>
                        </select>
                      </div>
                    )}
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
        <ProductsList battery={battery} scrollToRef={scrollToRef} />
      </div>
    </>
  );
};
export default ChooseSection;
