import React from "react";

import { faSearch } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import classNames from "classnames/bind";
import style from "../../../GlobalStyles/GlobalStyles.module.scss";
import SocialList from "../../../SocialList";
let cx = classNames.bind(style);

export default function HeaderRight() {
  return (
    <div className={cx("header-right")}>
      <form className={cx("search-form")}>
        <input
          type="search"
          className={cx("search-form__field")}
          placeholder="Search"
        />
        <button type="submit" className={cx("search-form__submit")}>
          <i>
            <FontAwesomeIcon icon={faSearch} />
          </i>
        </button>
      </form>
      <SocialList />
    </div>
  );
}
