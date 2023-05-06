import ChooseSection from "../components/selectproduct/ChooseSection";
import InverterBatteryChoose from "../components/selectproduct/InverterBatteryChoose";
import InverterChoose from "../components/selectproduct/InverterChoose";
import ProductSection from "../components/productpage/ProductSection";
import { useProductsContext } from "../context/products_context";

const ProductsPage = () => {
  const { chooseType } = useProductsContext();
  if (chooseType === "inverter") {
    return (
      <>
        <ProductSection />
        <InverterChoose />
      </>
    );
  } else if (chooseType === "inverterbattery") {
    return (
      <>
        <ProductSection />
        <InverterBatteryChoose />
      </>
    );
  } else
    return (
      <>
        <ProductSection />
        <ChooseSection></ChooseSection>
      </>
    );
};
export default ProductsPage;
