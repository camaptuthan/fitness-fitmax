import React from "react";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faFacebookF,
  faInstagram,
  faTwitter,
  faYoutube,
} from "@fortawesome/free-brands-svg-icons";

import cx from "../ClassBinding";

export default function SocialList() {
  const socialList = [
    { path: "https://www.facebook.com/rovadex", icon: faFacebookF },
    { path: "https://twitter.com/RovadexStudio", icon: faTwitter },
    { path: "https://www.youtube.com/", icon: faYoutube },
    { path: "https://www.instagram.com/rovadex", icon: faInstagram },
  ];
  return (
    <ul className={cx("social-list")}>
      {socialList.map((item, index) => (
        <li key={index}>
          <a href={item.path}>
            <FontAwesomeIcon icon={item.icon} />
          </a>
        </li>
      ))}
    </ul>
  );
}
