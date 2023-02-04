import React from "react";
import cx from "../ClassBinding";
import crossMax2 from "../../assets/img/crossmax-2.jpg";
export default function CrossfitBanner() {
  return (
    <section className={cx("s-crossfit-banner")}>
      <div
        className={cx("crossfit-banner-left")}
        style={{ backgroundImage: `url(${crossMax2})` }}
      ></div>
      <div className={cx("crossfit-banner-right")}>
        <div className={cx("text-top")}>open</div>
        <h2>crossmax</h2>
        <div className={cx("text-bottom")}>
          free open <a href="program.html">training</a>
        </div>
      </div>
    </section>
  );
}
