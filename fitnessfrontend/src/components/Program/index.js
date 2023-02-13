import React from "react";
import cx from "../ClassBinding";

import bgProgramsjpg from "../../assets/img/bg-programs.jpg";
import bgProgramssvg from "../../assets/img/bg-programs.svg";
import program1 from "../../assets/img/programs-1.jpg";

export default function Program() {
  const programs = [{}];
  return (
    <section
      className={cx("s-our-programs")}
      style={{ backgroundImage: `url(${bgProgramsjpg})` }}
    >
      <div className={cx("mask")}></div>
      <div
        className={cx("our-programs-effect")}
        style={{ backgroundImage: `url(${bgProgramssvg})` }}
      ></div>
      <div className={cx({ "container ": true }, "container")}>
        <h2 className={cx("title-decor")}>
          Our <span>Programs</span>
        </h2>
        <p className={cx("slogan")}>
          Maecenas consequat ex id lobortis venenatis. Mauris id erat enim.
          Morbi dolor dolor, auctor tincidunt lorem ut, venenatis dapibus miq.
        </p>
        <div className={cx({ row: true })}>
          {programs.map((program, index) => {
            return (
              <div
                className={cx({ "col-sm-6 col-md-3": true }, "program-col")}
                key={index}
              >
                <div className={cx("program-item")}>
                  <div
                    className={cx("program-item-front")}
                    style={{ backgroundImage: `url(${program1})` }}
                  >
                    <div className={cx("program-item-inner")}>
                      <h3>Personal trainer</h3>
                    </div>
                  </div>
                  <div
                    className={cx("program-item-back")}
                    style={{ backgroundImage: `url(${program1})` }}
                  >
                    <div className={cx("program-item-inner")}>
                      <h3>Personal trainer</h3>
                      <a href="program.html" className={cx("btn")}>
                        More
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            );
          })}
        </div>
      </div>
    </section>
  );
}
