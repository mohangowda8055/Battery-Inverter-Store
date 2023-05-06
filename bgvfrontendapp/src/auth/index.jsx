export const getCurrentUserDetail = () => {
  if (isLoggedIn()) {
    return JSON.parse(localStorage.getItem("data")).user;
  } else {
    return undefined;
  }
};

export const getToken = () => {
  if (isLoggedIn()) {
    console.log(isLoggedIn());
    const token = JSON.parse(localStorage.getItem("data")).data.token;
    console.log(token);
    return token;
  } else {
    return null;
  }
};
