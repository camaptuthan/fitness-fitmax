import React, { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import classNames from "classnames/bind";
import style from "./DropdownMenu.module.scss";
import { faCaretDown } from "@fortawesome/free-solid-svg-icons";

let cx = classNames.bind(style);

export default function DropdownMenu({ data }) {
  const [dropdown, setDropdown] = useState();
  const active = cx("active");
  const dropdownList = [
    {
      content: "Home",
      path: "#",
      icon: faCaretDown,
      children: [
        {
          path: "",
          content: "Crossfit",
        },
        {
          path: "",
          content: "Fitness",
        },
        {
          path: "",
          content: "Crossfit Lite",
        },
      ],
    },
    {
      content: "About",
      path: "",
      icon: null,
      children: [],
    },
    { content: "Service", path: "", icon: null, children: [] },
    {
      content: "Pages",
      path: "#",
      icon: faCaretDown,
      children: [
        {
          path: "",
          content: "Program",
        },
        {
          path: "",
          content: "Trainer",
        },
      ],
    },
    { content: "News", path: "", icon: null, children: [] },
    { content: "Contacts", path: "", icon: null, children: [] },
  ];
  return (
    <nav className={cx("nav-menu")}>
      <ul className={cx("nav-list")}>
        {dropdownList.map((item, index) => {
          return (
            <li
              key={index}
              className={item.children.length > 0 ? cx("dropdown") : ""}
              onMouseEnter={(e) => {
                if (item.children.length > 0) {
                  var menuItem = e.currentTarget;
                  setDropdown(menuItem);
                  menuItem.classList.add(active);
                }
              }}
            >
              <a href={item.path}>
                {item.content}
                <i>{item.icon && <FontAwesomeIcon icon={item.icon} />}</i>
              </a>
              {item.children && (
                <ul>
                  {item.children.map((itemChild, index) => {
                    return (
                      <li
                        key={index}
                        onMouseLeave={(e) => {
                          dropdown.classList.remove(active);
                        }}
                      >
                        <a href={itemChild.path}>{itemChild.content}</a>
                      </li>
                    );
                  })}
                </ul>
              )}
            </li>
          );
        })}
      </ul>
    </nav>
  );
}
