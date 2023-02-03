import React from "react";
import SocialList from "../../SocialList";

import style from "../../GlobalStyles/GlobalStyles.module.scss";
import classNames from "classnames/bind";
let cx = classNames.bind(style);
export default function Footer() {
  return (
    <footer>
      <div className={cx({ "container ": true })}>
        <div className={cx({ "row ": true })}>
          <div
            className={cx({ "col-sm-6 col-lg-3": true }, "footer-item-logo")}
          >
            <a href="index-2.html" className={cx("logo-footer")}>
              <img src="assets/img/footer-logo2.svg" alt="logo" />
            </a>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            </p>
            <SocialList />
          </div>
          <div
            className={cx(
              {
                "col-sm-6 col-lg-3": true,
              },
              "footer-item footer-item-list"
            )}
          >
            <h3>Links</h3>
            <ul className={cx("footer-link")}>
              <li>
                <a href="#">Sed ut perspiciatis unde</a>
              </li>
              <li>
                <a href="#">Omnis iste natus error sit</a>
              </li>
              <li>
                <a href="#">Voluptatem accusantium</a>
              </li>
              <li>
                <a href="#">Doloremque laudantium</a>
              </li>
            </ul>
          </div>
          <div className={cx({ "col-sm-6 col-lg-3": true }, "footer-item")}>
            <h3>Contact us</h3>
            <ul className={cx("footer-cont")}>
              <li>
                <i className="fa fa-phone" aria-hidden="true"></i>
                <a href="tel:18004886040">1-800-488-6040</a>
              </li>
              <li>
                <i className="fa fa-envelope" aria-hidden="true"></i>
                <a href="mailto:crossFit@gmail.com">CrossFit@gmail.com</a>
              </li>
              <li>
                <i className="fa fa-map-marker" aria-hidden="true"></i>
                <a href="contacts.html">London,Street 225r.21</a>
              </li>
            </ul>
          </div>
          <div className={cx({ "col-sm-6 col-lg-3 ": true }, "footer-item")}>
            <h3>Blog</h3>
            <ul className={cx("footer-blog")}>
              <li>
                <a href="blog.html" className={cx("img-cover")}>
                  <img src="assets/img/footer-icon-1.jpg" alt="img" />
                </a>
                <div className={cx("footer-blog-info")}>
                  <div className={cx("name")}>
                    <a href="blog.html">Sed ut perspiciatis</a>
                  </div>
                  <p>Omnis iste natus error sit voluptatem…</p>
                </div>
              </li>
              <li>
                <a href="blog.html" className={cx("img-cover")}>
                  <img src="assets/img/footer-icon-2.jpg" alt="img" />
                </a>
                <div className={cx("footer-blog-info")}>
                  <div className={cx("name")}>
                    <a href="blog.html">Sed ut perspiciatis</a>
                  </div>
                  <p>Omnis iste natus error sit voluptatem…</p>
                </div>
              </li>
            </ul>
          </div>
        </div>
        <div className={cx("footer-bottom")}>
          <div className={cx("copyright")}>
            <a href="#" target="_blank"></a>
          </div>
          <ul className={cx("footer-menu")}>
            <li className={cx("active")}>
              <a href="index-2.html">Home</a>
            </li>
            <li>
              <a href="about.html">About</a>
            </li>
            <li>
              <a href="services.html">Services</a>
            </li>
            <li>
              <a href="blog.html">News</a>
            </li>
            <li>
              <a href="contacts.html">Contacts</a>
            </li>
          </ul>
        </div>
      </div>
    </footer>
  );
}
