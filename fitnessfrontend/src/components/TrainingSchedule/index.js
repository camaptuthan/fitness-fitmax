import React from "react";
import bgTable1 from "../../assets/img/bg-table-1.svg";
import cx from "../ClassBinding";
export default function TrainingSchedule() {
  const dates = [{}];
  return (
    <section
      className={cx("s-training-schedule")}
      style={{ backgroundImage: `url(${bgTable1})` }}
    >
      <div className={cx("container")}>
        <h2 className={cx("title-decor")}>
          Training <span>Schedule</span>
        </h2>
        <p className={cx("slogan")}>
          Maecenas consequat ex id lobortis venenatis. Mauris id erat enim.
          Morbi dolor dolor, auctor tincidunt lorem ut, venenatis dapibus miq.
        </p>
        <div className={cx("training-schedule-cover")}>
          <h3 className={cx("training-schedule-top")}>1-7 APRIL, 2019</h3>
          <div className={cx("training-schedule-table")}>
            <table>
              <thead>
                <th></th>
                <th>monday</th>
                <th>tuesday</th>
                <th>wednesday</th>
                <th>thursday</th>
                <th>friday</th>
                <th>saturday</th>
                <th>sunday</th>
              </thead>
              <tbody>
                {dates.map((date, index) => {
                  return (
                    <tr key={index}>
                      <td>9-00</td>
                      <td>
                        <h4>body bulding</h4>
                        <div className={cx("date")}>9-00 – 11:00</div>
                        <div className={cx("name")}>Mark Klark</div>
                      </td>
                      <td></td>
                      <td></td>
                      <td>
                        <h4>boxing</h4>
                        <div className={cx("date")}>9-00 – 11:00</div>
                        <div className={cx("name")}>Mark Klark</div>
                      </td>
                      <td></td>
                      <td></td>
                      <td>
                        <h4>boxing</h4>
                        <div className={cx("date")}>9-00 – 11:00</div>
                        <div className={cx("name")}>Mark Klark</div>
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </section>
  );
}
