import React from "react";
import bgPrice2 from "../../assets/img/bg-price-2.svg";
import cx from "../ClassBinding";
export default function ClubCard() {
  const clubCards = [
    { date: "", price: "", list: [], path: "" },
    { date: "", price: "", list: [], path: "" },
    { date: "", price: "", list: [], path: "" },
  ];
  return (
    <section className={cx("s-club-cards")}>
      <div className={cx({ "container ": true }, "container")}>
        <h2 className={cx("title-decor")}>
          Club <span>Cards</span>
        </h2>
        <p className={cx("slogan")}>
          Maecenas consequat ex id lobortis venenatis. Mauris id erat enim.
          Morbi dolor dolor, auctor tincidunt lorem ut, venenatis dapibus miq.
        </p>
        <div className={cx({ "row ": true })}>
          {clubCards.map((card, index) => {
            return (
              <div
                className={cx({ "col-md-4": true }, "club-card-col")}
                key={index}
              >
                <div
                  className={cx("club-card-item")}
                  style={{ backgroundImage: `url(${bgPrice2})` }}
                >
                  <div className={cx("price-cover")}>
                    <div className={cx("price")}>40</div>
                    <div className={cx("date")}>
                      <span>99</span>3 months
                    </div>
                  </div>
                  <ul className={cx("list")}>
                    <li>Maecenas consequat</li>
                    <li>ex id lobortis venenatis</li>
                    <li>Mauris id erat enim</li>
                    <li className={cx("item-excluded")}>
                      Morbi dolor dolortin
                    </li>
                    <li className={cx("item-excluded")}>
                      lorem ut, venenatis dapibus mi
                    </li>
                  </ul>
                  <a href="program.html" className={cx("btn")}>
                    order now
                  </a>
                </div>
              </div>
            );
          })}
        </div>
      </div>
    </section>
  );
}
