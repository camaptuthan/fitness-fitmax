import "bootstrap/dist/css/bootstrap.min.css";
import "./GlobalStyles.module.scss";

function GlobalStyles({ children }) {
  return <div id="body">{children}</div>;
}

export default GlobalStyles;
