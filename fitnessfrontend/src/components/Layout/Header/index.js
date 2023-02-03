import React from "react";

import logo from "../../../assets/img/logo.svg";
import DropdownMenu from "../../DropdownMenu";
import HeaderLeft from "./HeaderLeft";
import HeaderRight from "./HeaderRight";

import cx from "../../ClassBinding";

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
