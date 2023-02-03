import React, { useEffect, useState } from "react";
import Footer from "../Footer";
import Header from "../Header";

import style from "../../GlobalStyles/GlobalStyles.module.scss";
import classNames from "classnames/bind";
let cx = classNames.bind(style);

export default function DefaultLayout({ children }) {
  // const [loaded, setLoaded] = useState(false);
  useEffect(() => {
    document.body.classList.add(cx("page-loaded"));
  }, []);
  return (
    <>
      <Header />
      <div>{children}</div>
      <Footer />
    </>
  );
}
