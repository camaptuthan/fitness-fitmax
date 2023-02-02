import React from "react";
import classNames from "classnames/bind";
import style from "../../GlobalStyles/GlobalStyles.module.scss";

import logo from "../../../assets/img/logo.svg";
import DropdownMenu from "../../DropdownMenu";
import HeaderLeft from "./HeaderLeft";
import HeaderRight from "./HeaderRight";

let cx = classNames.bind(style);

export default function Header() {
  return (
    <header className={cx("header")}>
      <a href="#" className={cx("nav-btn")}>
        <span></span>
        <span></span>
        <span></span>
      </a>
      <div className={cx("top-panel")}>
        <div className={cx({ "container ": true }, "container-style")}>
          <HeaderLeft />
          <HeaderRight />
        </div>
      </div>
      <div className={cx("header-menu")}>
        <div className={cx({ "container ": true }, "container-style")}>
          <div className={cx("header-logo")}>
            <a href="index-2.html" className={cx("logo")}>
              <img src={logo} alt="logo" />
            </a>
          </div>
          <DropdownMenu />
        </div>
      </div>
    </header>
  );
}
