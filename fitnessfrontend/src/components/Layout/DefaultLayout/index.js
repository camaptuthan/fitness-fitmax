import React, { useEffect, useState } from "react";
import Footer from "../Footer";
import Header from "../Header";

import cx from "../../ClassBinding";

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
