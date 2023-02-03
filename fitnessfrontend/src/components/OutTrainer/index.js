import React from "react";
import SocialList from "../SocialList";

import bgContacts from "../../assets/img/bg-contacts.svg";

import style from "../GlobalStyles/GlobalStyles.module.scss";
import classNames from "classnames/bind";
let cx = classNames.bind(style);

export default function OutTrainer() {
  const outTrainer = [
    {
      path: "",
      img: "https://media.istockphoto.com/id/1359766322/photo/portrait-of-a-young-man-and-woman-working-out-in-a-gym.jpg?b=1&s=170667a&w=0&k=20&c=V4GRwPgikFDFgeYy8nxBPKEmHLCD1qT59aaTDT3Y_uw=",
      name: "Sam piters",
      prof: "Weightlifting",
      des: "Maecenas consequat ex id lobortis venenatis. Mauris id erat enim. Morbi dolor dolor, auctor tincidunt lorem ut, venenatis dapibus miq.",
      socialList: "",
    },
    {
      path: "",
      img: "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBUWFRgWFRIYGBgaHBoaGBwcHBkaGB0aHBoaGRoaHBgcIy4lHB4rIRoYJjgmKy8xNTU1GiQ7QDs0Py40NTEBDAwMEA8QHhISHzYrJCwxNDExNDQxMTE0NDQ0ND80NDQ0NDQ0NDQ0NDQ0NDQ0MTQxNDQ0NDQ0NDQ0NDQ0NDExNP/AABEIAO4A1AMBIgACEQEDEQH/xAAcAAEAAQUBAQAAAAAAAAAAAAAABQIDBAYHAQj/xAA+EAACAQIDBQUFBQYGAwAAAAABAgADEQQSIQUGMUFRImFxgZEHEzKhsVJzssHwNUJicoLRFCOSosLhNLPS/8QAGQEBAQEBAQEAAAAAAAAAAAAAAAECAwQF/8QAIREBAQEBAAIDAQADAQAAAAAAAAECEQMhEjFBURMiYRT/2gAMAwEAAhEDEQA/AOyxEQEREBERAREQEREBIfbO3EoDXVuAUWuTxsASP114SrbO0fdAAaXDMxtchFtmIHC9iT5cDrbkW9eNdq73e4u9srZrpfQXHJje56AzOtcaznv223antJVABTRSxuAL5j/t0HzkbW9pOIpDNUp0iunZs2YX1AuDbh48Zy5MQFc9Mx7XnoQOfAaeEu18c1WooK9hNRmNxk45j1J5nrM9rr8c/wAde2N7VsNUbJXRqN/3jqgP8XNfGdCp1AwDKQQQCCDcEHUEEcRPlCtiiXJUXOa40vfXU279Z1jcPe9aOWhVcBG1U/uKTa4tfsDW9tRryuJqa/rGs/x1uIBiacyIiAiIgIiICIiAiIgIiICIiAiIgIiICIiByH2k7VcYkoLlMiAWJHNswNud+R6eE05Nk16hZ2DNfLl49rUAjXuM37f3Z+bG07gZWUH0JuNO+STpomUfC4Nh04W+noJw3rlerx57lzDaOwHVM3uyCCb5v3uR4cOswamUp7tqao44Ah7nhchhfQnlbT5zvFNAw7Qvcc5iY7YeHqLlemp5g27SnhdW4g+ETq2RwxHpIc5DZullABtY2IvcCY1baIJGQa2I1A+0SD8xfwnRdv7t0bliGBAOqhcrHlmAHHTn6maJtfYZoupLgg2IsOAjOpTWbI7x7P8AHtVwilst1JWwIvYcCQNFJ+fHnNpmtbi4BaWEQpmGcBiC2YA2t2e42myztPp5b9kREqEREBERAREQEREBERAREQEREBERAREQNK31pK2Iw4v2stT5ZSPzlimQDYsPUXmXvPgv8+nUA+zmN9AFFQDT+oj06TRdq7FrO7v7wKpvYg2ubXAJNwBwE8+/enr8XrLo2HdbaNK61VQNSJzTd/ZOOpMje+V6ZIzrmN1ubWBtZjax5cZIb3YPE1qvuqNQIgUFySb6m2gAubDWO/jfx/U3tLEodMy38ROfbzDtBr6ajztcTHOxKqkolZXfNbQluza+Zhbs+ssbdpOlJA1iQ+XTqeA+sZk6mrfjzj6E2QqCjTFMqUCKFKkFSALaEcZnTWvZ/gzSwFBCSSQ768e271B+KbLO8+njvq8IiJUIiICJ4Z7AREQEREBERAREQEREBERAREQIrbmDZ0unxC1hfiAQbeOn1mr4Zw2hm+NOc1KgSu6E2sx9OXyI9Zx8s/Xo8OvxIMbsqjhceGkw9qXXFXHBhY+Q0kNvDtNMhQVXoVlJKHJUKtpzIWzIeutrTVNh7SY4gVsVimfICEVFqNmYgrwVLWsTx14TnJ6ejvK6DtCoEQtYAznm1HD1aZckIrM7Wte4K5bA8+M2jb+PAQXBS9jkOhF78QeHDhNKxdXMQe785cT2x5dcnHdd29t0q1NchFgALdLCwE2AGfOuxdrvQcFDpzE7Zu1tgV6atzPGeiV5LE/ERKyTwz2UmUeSsSiViQIiICIiAiIgIiICIiAiIgIiIHh4TkO+btSxbOfgcqM3JWyqLHoCPnOo7Qx601JJueSjif7CaFiwtdqi1AGD6MO61vKcvJqfTv4c2+1KPUdAVIJA0MsilXXtOw08APlNIxG0MRgKrUblkGqE80PDXn08pibU3yrOCoGUGcvi9XeRVvZtHNUJZrkch16TBw57CHu/MzF2Ns5sQzO5JVdWPUnlJ07NJS6D4SbDqNLgd/8A3Oksz6cNZ1qdRwM6T7NMaxDIeA4Tmt5032dYSy5us6Rwv06gjXEqlFMWEqm2C88iICViUSsSBERAREQEREBERARExcbjadFC9RwqjiT9B1PcIGVKHcAEkgAcSTYes5nt72mEXXDplHDO4BbxCcB538Joe1N4K+II97WZ7cAxFge5RoPSF47HtXfnBULj3vvG+zT7fD+L4fnOdbxe0vE1QVoWoJoLqc1Qg/xEaf0gHvmlPVvMZ2/XnC8dX3HxQq4QZmu9NmRr8dDmU9/ZYehl65Dsw4X+k5zupttsPUN2tTqaP3HXK/lc37ie6dGRyOhBnl8meV7vBe5Ye8mxUxKC+jr8LdOoPdNKp7lVmfKXULfVtb27hOl0amZeH95dcg2OiqB85masdLmfrUa2z0o01pUxoOJ5kniTMnY2EBUg6AG9/rM3FU1LXDX6aaTSt5duWD4ei3ZOlVhwPVF+hPl1lzLqm9TOeo3buOVsS7UrFL5QeTZRYuLcib268Z0DcTfHCU0FOszUmGmZgSh/qW9vMCcpXnaVq9v15n8p6pOPn6vb19T4PF06iB6bq6HgysGX1Evz5cwO06tJs9Oo6N1RmUnuOU6za92d/wDF4eoWrVHxCNYMjPcr/Erm5B7uB+crPHeIkPu/vJh8Ypai+q2zodHW/C69O8XEmJWSViUSoSD2IiAiIgIiICIiAnEd/t4mxFdlVv8ALpkqg5G2hfxP0tOw7Xr5KFVxxRHYeIUkT5zxT3MjUY1ViZjZuXMfrSXXMsOfIyquI2usofjLTP8Ar8pWkCnLp6Tad395/dqKda7INFcasg6Ec1+Y7+WuZYKzOszU5W87ub2OrUKlwHp1AwOoZTdTKsbiAq56jBVXUknT9d05vsTbL4Z7qM6N8SE2Hip5N+ulvNv7afEuLjIi8EBuB3k2F2PyE4/4r3n49X/oz8e89sveDeNq3Yo5kp8zezv/APK/M8+k1zJL9pQyTtnMzOR5Nbur2qBKgv69J5a08d9JplURqPWes9tALmUF9Ly2pP6/Pp4QJbY+1auHqpWpPldTx/dI5qRzU8xPojdzbCYvDpXUWzCzLzVwbMvkRx5ix5z5mU99z+uU697FMYTTxNIn4HRx/WrKf/WISun3lYluXBDL2IiAiIgIiICIiBEb1/8AhYn7p/wmfOFatmay3Y9FF/pO9+0LA1K+GWijZVeqgrG9j7oZmYDrcqot3zWqOESkAtNAoHJQBOe9/F38Pj+Tla7OxDfDhq58Kbn8p5W2ViVHaw1UDqab289J11Kz34aeMzEcETn/AJr/AB2vgn9cCYG48bf9H5zOQTou9mwKdVCwULUGoYCx05N1E5yhtx8DOudTTjvFzV/LKWEe8lLNNuaiq9h3xSSwtz4mUKLtc8oZje/IwLyiGWeK0qzQLTLMSq2h/XKZbtMnd7ZP+JrBDcIozNbjbgFB5X69AZLeTtXMtvIiSx0lWYDiwHcD9TOs4PdPDpqtJb8iRn+b3l3/AAoT4EX/AEqPoJyvmn8d54L+1yH36jhp6f3nUvYZUBqYvUfDR0vro1S+nmPUTKxNEVFsyKe4gH5TWE2VXwuMw9fBKbtUVSq3sQzAFSPsMLg9OOkufLNXjPk8NzO9d9l0cJal1eE6vM9iIgIiICIiAiJ40DVN5MZmbIOC/XnINjy5yjH1mLk9Sbyms2qzx713T6PjzM5kZ9IC2s8q1Fym0stRzr0mI+BfWzGxmXRjbVxQyHwnJqtcFib8ST6kzpO1dkVWRlVxdgQLgjjNAxO6uJp6lA38pv8AI2M7eKyd7XDzy3nIxBVj3kstTZfiUr4gj6wuvDWd+vNxkKb6Dzlbtyl3A4Ko5slN2PcD9eAk7hdy8Swu+RAepzEf0j+8l1mfdWY1fqNazyg1pvuF9nq8Xrs38qqv1vL+D3Gw6v2s1ToGYZR5KBfzmb5ctTw6c4Na+g1PdNv9nDjPUHOyf8p0DDYVKC5VpIg6Kqrf0Ej6+GVawrKgVrFWIsMw5X6kH6mY15PlOOmPH8b1Mu+lhLPuTxtMNcQWew1ktwXUzi9H0jCgzTEbEtTdWU2ZTceX1EyKtTt8Zr22sZlewifa2dnt2PZ+KWrTSovB1B8DzHkbjymavCaZ7NMUXwrX/dqMB4FVa3qT6zc14T2S9nXzNTlsVRESskREBERAREQND2jhQrsOhb6mRuNBGWbHvLRs9/tAevA/rvkM+HNRNCAyn1nk3P8Abj6Hi13Mq5g6oC3Y6S4dpZjlRAx56cPE8pFHZVViA9Sy9F4nz5SVpKUXKiWAkjWudevhmYHMNTa1uAmLU2cx5C0vh6vEEDxMsVap5vfoOsXhLWNU2MDxC+Yni4BUOpUW6ATytiDbV7eEja+ODGy5mvpM+mvaZFcAWutvATxqyg3LchpIA4pUPaK5vs3vbx6nunjbRcguUCjq+lh4SrxPf4otoqnvOXSeuxSxNiedtDNOq7RxVWwos2W/xAZU/wBR4+V5LbK2dUXtVaj1GOuubKPI8fExSRMPi8/JtO785aOHZ73OUdOczKFMnl87S+FRdWYC3feJ2s2yLOFwOThwnm0MRlWwmPitoMPgcEdL24dBITFbSLAhhY98vE779vKeJLPIfHuCzGSeBomz1CLKAbd5mv4+raw4Fj8iYk9rrXrrqHs2rqmGCX1ZmY+dgPkBN+XhOGblbYy1Cl9Cez+U7dhHzIh6qD8p659Pna++r8RErJERAREQERECG3lwpeiWX4k7Q8Of5ek0mhtDmOP7wnTHUEEEXB0PgZy/efZjYVmc3NMnRhy6BuhnHy577j0+Dcn+tSNDHU2tcsD8per7RpqPivOY7R3gynsNc92v0kedtO1s9QgdBxnOZ1x6LrPXQcZtsnRbfnI2tXrE6AHzsJrVPbKLwJJ6nrC7ZZzYNYcydFHeTyk+NWbyma6VjozqO7Vj6CEwZAZqlYoi8Toinrrx7tOk1rE7xlLilqx0943L+RT9TIbGYuo/xO7DvYt58begmpis68uZ9Nkxe81KmSuGpj+dhmY/yg6nxMl9jbFq1rVcYWtxSkdL97j/AI+vSa3ulghn98yghTZbkA5vtAHiRN1Xa7/wt5gMPI8ZNcnqGO691Mo54KoFtLacO6DUfkjeQB/OQNbaDsezTytxtmAPkDxHhLS7SrDr5lfy4zHHVsIR3/eqKf5F/vLT7Ed9TVIHeBf6yFG2a40sB35hKDt91+Nr+HCWM1P0d3UHxu7a9w01mWNkovBOB0LdO+81dd8VXiwlnEbz+87Kt85ef8Z/ftI7Y2ivwCwC8bcB3TQ8fi87swPZHZHjJHbFQlCF0B49ZAUVyradPHn9cvNv18Yz9lVylVG759J7Ea+HpHqin5CfMaGxB759K7qtfB4c9aSH/aJ2jy1LRESskREBERAREQE03f1z7ogTcpou/wBUAQwscrZR0EhdsuQVAsLg8h1H95NMZDbbGitzF/yMzGkK+LboPG0ttiGIsWNunKWiJ5LxLaEz0MRwM8iVlmYfaNVNFqMB0vceh0mSNuVeeVvK30tI1VvwlXuT0kslbmtT6qXpbeI4q1uma48gRcHvBl07cB4u48QD6kEX8Zr5Fp5J8MrPLqJ2ptU8A4b1B87yg7Wb7QkLEfCL/l0lveM9zmB6ytKRHBiPDSY+zeDeImcBHInyt9qbE8WY+J09JVaewZUvtTPpDcr/AMDCfcUvwCfN5n0huT+z8J9xS/AIiVOxESskREBERAREQPGOk5l7Q8RwWdJxDWE5JvzVvUtFajUGMhNuPqg7m/4gSaea1t9v8wfyj6mZi1EmIlaoZplQBMinQvxldJ1HEWl01Ps2hZBaduBnjC3MSk1DLTteFUuby1LgEW7oLOrUS77vvlDLaGeM7Zd7npp6yQkfs2pqV8/yP5SQkWEREK8M+jtx/wBn4T7il+AT5xM+jtx/2fhPuKX4BES/SeiIlZIiICIiAiIgY2MOk45vab1TOxY7hOPb2j/MMlajW2E07HVC1Rm/isPAaD6Tb8Q+VWPQE+k1RaWUd8Qq2KNhca90rUqeGh6GVI1jb0lFVf1zlUdO6WbEcpcWtyM9z34QLebulJN5U4755pzgGgHpPcl54yWgU3noYcIKEykNbxhKvYE9seclpC0DZl8R9ZNCSkIiLQqkz6P3H/Z+E+4pfgE+cTPo7cb9nYP7il+EREqeiIlZIiICIiAiIgY2NHZnIt80tUPjOv4kaTmG/NHW8lajnm1Hsjd+k112Mltt1NQvLjIZhEVUXXnAe8tZ7aQGlOvXp87yzlJ4CZN+k9zGBiin1uJ6ykd4mQx7hKLwnFoMeQlQq9RKved08Ld0KqDy2735Txm7hLbGEteodZOIb6yCAkzgzdF9PSSkXZ7aVTwiFUkT6N3G/Z+E+4pfgE+czPo3cf8AZ+E+4pfgERKnYiJWSIiB/9k=",
      name: "Sam piters",
      prof: "Weightlifting",
      des: "Maecenas consequat ex id lobortis venenatis. Mauris id erat enim. Morbi dolor dolor, auctor tincidunt lorem ut, venenatis dapibus miq.",
      socialList: "",
    },
    {
      path: "",
      img: "https://www.beachfitbondi.com.au/wp-content/uploads/2019/08/Grace-min.png",
      name: "Sam piters",
      prof: "Weightlifting",
      des: "Maecenas consequat ex id lobortis venenatis. Mauris id erat enim. Morbi dolor dolor, auctor tincidunt lorem ut, venenatis dapibus miq.",
      socialList: "",
    },
    {
      path: "",
      img: "https://www.beachfitbondi.com.au/wp-content/uploads/2019/08/Zane1-min.png",
      name: "Sam piters",
      prof: "Weightlifting",
      des: "Maecenas consequat ex id lobortis venenatis. Mauris id erat enim. Morbi dolor dolor, auctor tincidunt lorem ut, venenatis dapibus miq.",
      socialList: "",
    },
  ];
  return (
    <section
      className={cx("s-out-trainer")}
      style={{ backgroundImage: `url(${bgContacts})` }}
    >
      <div className={cx({ "container ": true })}>
        <h2 className={cx("title-decor")}>
          Our <span>Trainer</span>
        </h2>
        <p className={cx("slogan")}>
          Maecenas consequat ex id lobortis venenatis. Mauris id erat enim.
          Morbi dolor dolor, auctor tincidunt lorem ut, venenatis dapibus miq.
        </p>
        <div className={cx({ "row ": true })}>
          {outTrainer.map((trainer, index) => {
            return (
              <div className={cx("col-md-6", "out-trainer-col")} key={index}>
                <div className={cx("out-trainer-item")}>
                  <a href={trainer.path} className={cx("out-trainer-img")}>
                    <img
                      className={cx("rx-lazy")}
                      src={trainer.img}
                      data-src={trainer.img}
                      alt="img"
                    />
                  </a>
                  <div className={cx("out-trainer-info")}>
                    <h3>
                      <a href={trainer.path}>{trainer.name}</a>
                    </h3>
                    <div className={cx("prof")}>{trainer.prof}</div>
                    <p>{trainer.des}</p>
                    <SocialList />
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
