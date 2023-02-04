import React from "react";
import cx from "../ClassBinding";

import blog4 from "../../assets/img/blog-4.jpg";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faComment, faUser } from "@fortawesome/free-solid-svg-icons";
import { faCalendar } from "@fortawesome/free-regular-svg-icons";
export default function Post() {
  const posts = [{}, {}, {}, {}];
  return (
    <section className={cx("s-related-posts", "home-related-posts")}>
      <div className={cx({ " container": true }, "container-style")}>
        <h2 className={cx("title-decor")}>
          Latest <span>News</span>
        </h2>
        <p className={cx("slogan")}>
          Maecenas consequat ex id lobortis venenatis. Mauris id erat enim.
          Morbi dolor dolor, auctor tincidunt lorem ut, venenatis dapibus miq.
        </p>
        <div className={cx({ "row ": true })}>
          {posts.map((post, index) => {
            return (
              <div
                className={cx({ "col-md-6": true }, "related-post-col")}
                key={index}
              >
                <div className={cx("post-item-cover")}>
                  <div className={cx("post-header")}>
                    <div className={cx("related-post-categ")}>fitness</div>
                    <div className={cx("post-thumbnail")}>
                      <a href="single-blog.html">
                        <img
                          className={cx("rx-lazy")}
                          src={blog4}
                          data-src={blog4}
                          alt="img"
                        />
                      </a>
                    </div>
                  </div>
                  <div className={cx("post-content")}>
                    <div className={cx("meta")}>
                      <span className={cx("post-date")}>
                        <i aria-hidden="true">
                          <FontAwesomeIcon icon={faCalendar} />
                        </i>
                        October 31, 2019
                      </span>
                    </div>
                    <h3 className={cx("title")}>
                      <a href="single-blog.html">
                        Sed ut perspiciatis unde omnis
                      </a>
                    </h3>
                    <div className={cx("text")}>
                      <p>
                        Sed ut perspiciatis unde omnis iste natus error sit
                        voluptatem accusantium doloremque laudantium, totam
                        rem...
                      </p>
                    </div>
                  </div>
                  <div className={cx("post-footer")}>
                    <div className={cx("meta")}>
                      <span className={cx("post-by")}>
                        <i aria-hidden="true">
                          <FontAwesomeIcon icon={faUser} />
                        </i>
                        <a href="#">By Rovadex</a>
                      </span>
                      <span className={cx("post-comment")}>
                        <i aria-hidden="true">
                          <FontAwesomeIcon icon={faComment} />
                        </i>

                        <a href="#">2 Comments(s)</a>
                      </span>
                    </div>
                    <a href="single-blog.html" className={cx("btn")}>
                      <span>read more</span>
                    </a>
                  </div>
                </div>
              </div>
            );
          })}
        </div>
      </div>
    </section>
  );
}
