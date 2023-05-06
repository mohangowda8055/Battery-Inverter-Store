const NoSymFormatPrice = ({ price }) => {
  return Intl.NumberFormat("en-IN", {
    style: "currency",
    currency: "INR",
    currencyDisplay: "code",
    maximumFractionDigits: 2,
  })
    .format(price)
    .replace("INR", "")
    .trim();
};
export default NoSymFormatPrice;
