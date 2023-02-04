import React from "react";
import cx from "../../ClassBinding";

import effect1 from "../../../assets/img/effect-1.svg";
import effect2 from "../../../assets/img/effect-2.svg";
import slide1 from "../../../assets/img/slide-1.jpg";
export default function CrossfitSlider() {
  const slider = [
    {
      title: "",
      des: " Maecenas consequat ex id lobortis venenatis. Mauris id erat enim. Morbi dolor dolor, auctor tincidunt lorem ut, venenatis dapibus mi. Nunc venenatis sollicitudin nisl vel auctor.",
    },
  ];
  return (
    <section className={cx("s-crossfit-slider")}>
      <div className={cx("s-crossfit-slider")}>
        {slider.map((slider, index) => {
          return (
            <div className={cx("crossfit-slide")} key={index}>
              <div className={cx("crossfit-slider-effect effect-1")}>
                <div data-hover-only="true" className={cx("scene")}>
                  <span
                    className={cx("scene-item")}
                    data-depth="0.2"
                    style={{ backgroundImage: `url(${effect1})` }}
                  ></span>
                </div>
              </div>
              <div className={cx("crossfit-slider-effect effect-2")}>
                <div data-hover-only="true" className={cx("scene")}>
                  <span
                    className={cx("scene-item")}
                    data-depth="0.4"
                    style={{ backgroundImage: `url(${effect2})` }}
                  ></span>
                </div>
              </div>
              <div
                className={cx("crossfit-slide-bg")}
                style={{ backgroundImage: `url(${slide1})` }}
              ></div>
              <div className={cx({ "container ": true }, "container-style")}>
                <div className={cx("crossfit-slide-cover")}>
                  <h2 className={cx("title")}>
                    push <span>yourself</span>
                  </h2>
                  <p>{slider.des}</p>
                </div>
              </div>
            </div>
          );
        })}
      </div>
      <div className={cx("slider-navigation")}>
        <div className={cx({ "container ": true }, "container-style")}>
          <div className={cx("slider-navigation-cover")}></div>
        </div>
      </div>
    </section>
  );
}
