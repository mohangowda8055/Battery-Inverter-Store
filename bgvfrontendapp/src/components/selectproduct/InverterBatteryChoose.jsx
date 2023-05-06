import { useState, useEffect, useRef } from "react";
import ProductsList from "../productpage/ProductsList";
import axios from "axios";

const InverterBatteryChoose = () => {
  const [backupId, setBackupId] = useState("");
  const [backup, setBackup] = useState([]);
  const [warrantyId, setWarrantyId] = useState("");
  const [warranty, setWarranty] = useState([]);
  const [invBattery, setInvBattery] = useState([]);
  const [enable, setEnable] = useState(true);
  const scrollToRef = useRef(null);

  useEffect(() => {
    const fetchBackup = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/inv-battery/backup-duration`
        );
        const result = response.data;
        setBackup(result);
      } catch (error) {
        console.log(error);
      }
    };
    fetchBackup();
  }, []);

  const fetchWarranty = async (e) => {
    const backupId = e.target.value;
    if (backupId !== "") {
      try {
        const response = await axios.get(
          `http://localhost:8080/inv-battery/warranty?backupDurationId=${backupId}`
        );
        const getWarranty = response.data;
        setWarranty(await getWarranty);
        setBackupId(backupId);
        setEnable(false);
      } catch (error) {
        console.log(error);
      }
    } else {
      setWarranty([]);
      setEnable(true);
    }
  };

  const handleWarranty = (e) => {
    const warrantyId = e.target.value;
    setWarrantyId(warrantyId);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (warrantyId !== "" && backupId !== "") {
      try {
        const response = await axios.get(
          `http://localhost:8080/inv-battery/batteries?backupDurationId=${backupId}&warrantyId=${warrantyId}`
        );
        const getInvBattery = response.data;
        setInvBattery(await getInvBattery);
        if (scrollToRef.current) {
          scrollToRef.current.scrollIntoView({ behavior: "smooth" });
        }
      } catch (error) {
        console.log(error);
      }
    } else {
      throw new Error("Backup is null");
    }
  };

  return (
    <>
      <div className="products-page">
        <article className="choose-section-two pb-5 ">
          <div className="battery-form pt-3">
            <h5>Choose your Inverter Battery</h5>
          </div>
          <div className="container mt-4 ">
            <form action="" onSubmit={(e) => handleSubmit(e)}>
              <div className="row">
                <div className="col-md-12">
                  <div className="row gx-3 gy-2 align-items-center ">
                    <div className="col-sm-3">
                      <label htmlFor="specificSizeSelect">
                        Backup Duration
                      </label>
                      <select
                        className="form-select"
                        id="specificSizeSelect"
                        name="backupId"
                        value={backupId}
                        onChange={(e) => fetchWarranty(e)}
                        required
                      >
                        <option value={""} disabled>
                          --Select--
                        </option>
                        {backup.map((back) => {
                          const { id, backupDuration } = back;
                          return (
                            <option key={id} value={id}>
                              {backupDuration} hours
                            </option>
                          );
                        })}
                      </select>
                    </div>
                    <div className="col-sm-3">
                      <label htmlFor="specificSizeSelect">Warranty</label>
                      <select
                        className="form-select"
                        id="specificSizeSelect"
                        name="warrantyId"
                        value={warrantyId}
                        disabled={enable}
                        onChange={(e) => handleWarranty(e)}
                        required
                      >
                        <option value={""} disabled>
                          --Select--
                        </option>
                        {warranty.map((war) => {
                          const { id, totalWarranty } = war;
                          return (
                            <option key={id} value={id}>
                              {totalWarranty} months
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
        <ProductsList battery={invBattery} scrollToRef={scrollToRef} />
      </div>
    </>
  );
};
export default InverterBatteryChoose;
