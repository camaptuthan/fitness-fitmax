import React from "react";

import { faSearch } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import SocialList from "../../../SocialList";

import cx from "../../../ClassBinding";

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
