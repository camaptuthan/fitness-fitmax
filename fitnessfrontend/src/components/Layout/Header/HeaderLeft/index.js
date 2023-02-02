import React from "react";
import classNames from "classnames/bind";
import style from "../../../GlobalStyles/GlobalStyles.module.scss";
import { faClockFour, faPhoneAlt } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

let cx = classNames.bind(style);
export default function HeaderLeft() {
  const items = [
    {
      content: "1-800-488-6040",
      path: "tel:18004886040",
      icon: faPhoneAlt,
    },
    {
      content: " Mon - Fri: 8:00AM - 7:00PM | Sat - Sun: Closed",
      path: "",
      icon: faClockFour,
    },
  ];
  return (
    <div className={cx("header-left")}>
      <ul className={cx("header-cont")}>
        {items.map((item, index) => (
          <li key={index}>
            <i>
              <FontAwesomeIcon icon={item.icon} />
            </i>
            {item.path ? (
              <a href={item.path}>{item.content}</a>
            ) : (
              <span>{item.content}</span>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
}
