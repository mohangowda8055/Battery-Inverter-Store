const auth_reducer = (state, action) => {
  if (action.type === "ISLOGGEDIN") {
    return { ...state, login: true };
  }
  if (action.type === "ISLOGGEDOUT") {
    return { ...state, login: false };
  }
  throw new Error(`No Matching "${action.type}" - action type`);
};
export default auth_reducer;
