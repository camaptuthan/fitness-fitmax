import React from "react";
import cx from "../ClassBinding";
export default function Crossfit() {
  const packages = [
    {
      title: "body bulding",
      des: "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.",
      img: "",
      path: "",
    },
    {
      title: "group workouts",
      des: "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.",
      img: "",
      path: "",
    },
    {
      title: "boxing",
      des: "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.",
      img: "",
      path: "",
    },
  ];
  return (
    <section className={cx("s-crossfit")}>
      <div className={cx({ "container ": true })}>
        <img
          src="assets/img/placeholder-all.png"
          data-src="assets/img/group-circle-2.svg"
          alt="img"
          className={cx("crossfit-icon-1 rx-lazy")}
        />
        <img
          src="assets/img/placeholder-all.png"
          data-src="assets/img/line-red-1.svg"
          alt="img"
          className={cx("crossfit-icon-2 rx-lazy")}
        />
        <img
          src="assets/img/placeholder-all.png"
          data-src="assets/img/tringle-about-top.svg"
          alt="img"
          className={cx("crossfit-icon-3 rx-lazy")}
        />
        <h2 className={cx("title-decor")}>
          Welcome To <span>Crossfit</span>
        </h2>
        <p className={cx("slogan")}>
          Maecenas consequat ex id lobortis venenatis. Mauris id erat enim.
          Morbi dolor dolor, auctor tincidunt lorem ut, venenatis dapibus miq.
        </p>
        <div className={cx({ "row ": true })}>
          {packages.map((packageItem, index) => {
            return (
              <div
                className={cx({ "col-md-4": true }, "crossfit-col")}
                key={index}
              >
                <div className={cx("crossfit-item")}>
                  <img
                    className={cx("rx-lazy")}
                    src="assets/img/placeholder-all.png"
                    data-src="assets/img/serv-1.svg"
                    alt="img"
                  />
                  <h3>{packageItem.title}</h3>
                  <p>{packageItem.des}</p>
                  <a className={cx("btn")} href={packageItem.path}>
                    view Schedule
                  </a>
                </div>
              </div>
            );
          })}
        </div>
      </div>
    </section>
  );
}
