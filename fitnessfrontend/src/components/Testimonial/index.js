import React from "react";
import cx from "../ClassBinding";
import bgTestimonial from "../../assets/img/bg-testimonials.jpg";
import testimonial from "../../assets/img/testimonials-1.png";
export default function Testimonial() {
  const slides = [{}, {}, {}];
  return (
    <section
      className={cx("s-testimonials")}
      style={{ backgroundImage: `url(${bgTestimonial})` }}
    >
      <div className={cx("mask")}></div>
      <img
        className={cx("testimonials-effect")}
        src="assets/img/bg-testimonials.svg"
        alt="effect"
      />
      <div className={cx({ "container ": true }, "container")}>
        <div className={cx("testimonials-slider")}>
          {slides.map((slide, index) => {
            return (
              <div className={cx("testimonial-slide")} key={index}>
                <p>
                  “Phasellus vestibulum nec dolor quis varius. Lorem ipsum dolor
                  sit amet, consectetur adipiscing elit. Phasellus gravida magna
                  sit amet euismod lacinia. Lorem ipsum dolor sit amet,
                  consectetur adipiscing elit”
                </p>
                <img src={testimonial} alt="img" />
                <h3 className={cx("name")}>Anna Piters</h3>
                <div className={cx("prof")}>our client</div>
              </div>
            );
          })}
        </div>
      </div>
    </section>
  );
}
