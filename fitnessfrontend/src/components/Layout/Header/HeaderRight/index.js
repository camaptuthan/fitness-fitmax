import React from "react";

import classNames from "classnames/bind";
import style from "./HeaderRight.module.scss";
import {
  faFacebookF,
  faInstagram,
  faTwitter,
  faYoutube,
} from "@fortawesome/free-brands-svg-icons";
import { faSearch } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

let cx = classNames.bind(style);
export default function HeaderRight() {
  const socialList = [
    { path: "https://www.facebook.com/rovadex", icon: faFacebookF },
    { path: "https://twitter.com/RovadexStudio", icon: faTwitter },
    { path: "https://www.youtube.com/", icon: faYoutube },
    { path: "https://www.instagram.com/rovadex", icon: faInstagram },
  ];
  return (
    <div className={cx("header-right")}>
      <form className={cx("search-form")}>
        <input
          type="search"
          className={cx("search-field")}
          placeholder="Search"
        />
        <button type="submit" className={cx("search-submit")}>
          <i>
            <FontAwesomeIcon icon={faSearch} />
          </i>
        </button>
      </form>
      <ul className={cx("social-list")}>
        {socialList.map((item, index) => (
          <li key={index}>
            <a href={item.path}>
              <FontAwesomeIcon icon={item.icon} />
            </a>
          </li>
        ))}
      </ul>
    </div>
  );
}
