import React, { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import classNames from "classnames/bind";
import style from "./DropdownMenu.module.scss";
import { faCaretDown } from "@fortawesome/free-solid-svg-icons";

let cx = classNames.bind(style);

export default function DropdownMenu({ data }) {
  const [timeOut, setTimeOut] = useState("");

  const dropdownList = [
    {
      content: "Home",
      path: "",
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
      path: "",
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

  //get the closet parent node through classname
  const getParentByClassName = (currentNode, className) => {
    if (currentNode) {
      console.log(currentNode);
      var currentClass = currentNode.className;
      if (currentClass === className) {
        return currentNode;
      }

      var nearestParentNode = currentNode.offsetParent;
      if (nearestParentNode) {
        if (nearestParentNode.className === className) {
          return nearestParentNode;
        }
        return getParentByClassName(nearestParentNode, className);
      }
    }
  };
  // active dropdown when hover
  const handleMouseEnterDropdown = (item) => (event) => {
    if (item.children.length > 0) {
      var menuItem = event.currentTarget;
      if (menuItem) {
        if (timeOut) {
          clearTimeout(timeOut);
          setTimeOut("");
        }
        menuItem.classList.add(cx("active"));
      }
    }
  };

  // deactive dropdown when leave
  const handleMouseLeaveDropdown = (item) => (event) => {
    if (item.children.length > 0) {
      var menuItem = event.currentTarget;

      if (menuItem) {
        var timeOutFn = setTimeout(() => {
          menuItem.classList.remove(cx("active"));

          setTimeOut(timeOutFn);
        }, 1000);
      }
    }
  };

  return (
    <nav className={cx("nav-menu")}>
      <ul className={cx("nav-list")}>
        {dropdownList.map((item, index) => {
          return (
            <li
              key={index}
              className={item.children.length > 0 ? cx("dropdown") : ""}
              onMouseEnter={handleMouseEnterDropdown(item)}
              onMouseLeave={handleMouseLeaveDropdown(item)}
            >
              <a href={item.path}>
                {item.content}
                <i>{item.icon && <FontAwesomeIcon icon={item.icon} />}</i>
              </a>
              {item.children && (
                <ul>
                  {item.children.map((itemChild, index) => {
                    return (
                      <li key={index}>
                        <a href={item.path}>{itemChild.content}</a>
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
