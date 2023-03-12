$(window).on("load", (event) => {
    fetchingClass();
})
const schedule = $("#schedule-table");
const current_year = $("#current-year");
const start_week = $("#start-week");
const end_week = $("#end-week");
const fetchingScheduleByClassInfor = () => {
    let id = $("#class-service").val();
    let year = current_year[0].innerText;
    let start = start_week[0].innerText;
    let end = end_week[0].innerText;


    let path_api = id ?
        `http://localhost:8080/api/v1/schedule/${id}/${year}?start=${start}&end=${end}` :
        `http://localhost:8080/api/v1/schedule/${year}?start=${start}&end=${end}`;

    console.log(path_api);

    $.get(path_api, function (result) {
        const code = result.code;
        const data = result.data;
        console.log(result);
        if (code === 200) {
            $(`#training-schedule #list-class`).children().removeClass("menu-active");
            $(`#training-schedule #list-class #${id}`).addClass("menu-active");

            const classInformation = data;
            const scheduleInformation = data.scheduleDTO;

            $('#class-name').val(classInformation.id);
            $('#class-name').html(classInformation.name);

            let body = "";
            $("#schedule-body").html("");
            scheduleInformation.forEach(schedule => {
                $("#schedule-body").append(`<tr id="${schedule.id}" style="height: 6rem;">
                                                <td>${schedule.startTime}</td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>`);
                schedule.sessionDTOs.forEach(session => {
                    $(`#${schedule.id} > td`).eq(session.weekDay).html("something").html(
                        `
                        <div class="w-100 h-100">
                            <h4>${session.name}</h4>
                            <div class="date">${schedule.startTime} – ${schedule.endTime}</div>
                            <div class="name">${session.happenedDate}</div>
                        </div>
                        `)
                })
            })
        }
    })
        .fail(function (data) {
            console.log("lỗi quá!")
        })
}

const fetchingClass = () => {
    $.get("http://localhost:8080/api/v1/schedule/registered-class", (data) => {
        // console.log(data);
        data.forEach(c => {
            $("#training-schedule #list-service")
                .append(`<li style="text-align: center" id="${c.servicesId}">
                                <div class="container-fluid p-0 m-0">
                                    <a class="navbar-brand " onclick="setClassValue(${c.servicesId})">
                                      <img src="/img/programs-3.jpg" alt="Logo" width="40" height="40" class="d-block align-text-top rounded">
                                         <p class="d-block w-100 text-center">${c.name}</p>
                                    </a>
                                  </div>
                                </li>`)
        })
    }).then(() => {

    }).fail(function (data) {
        console.log("lỗi quá !")
    })
    getYear();
    $.get(`http://localhost:8080/api/v1/schedule`, function (result) {
            console.log(result);
        }
    )


}
const setClassValue = (element) => {
    $("#class-service").val(element.id)
    fetchingScheduleByClassInfor();
}
const getYear = () => {
    const years = $("#list-year");
    let currentYear = new Date().getFullYear();

    let startYear = 2019;
    while (startYear <= currentYear) {
        years.append(`<li class="p-0 m-0" id="${startYear}-selector"><a style="display: block;text-align: center" onclick="getWeek(${startYear})">${startYear}</a> </li>`)
        startYear++
    }
    current_year.html(currentYear);
    $(`#${currentYear}-selector`).addClass("menu-active");

    getWeek(currentYear);
}
const getWeek = (year) => {

    $("#list-year").children().removeClass("menu-active");
    $(`#${year}-selector`).addClass("menu-active");
    $("#current-year").html(year);

    let time = new Date;

    if (time.getFullYear() === year) {
        $("#start-week").html(`${weekStart(time).getDate()}/${weekStart(time).getMonth() + 1}`);
        $("#end-week").html(`${weekEnd(time).getDate()}/${weekEnd(time).getMonth() + 1}`);
    } else {
        time = new Date(year, 0, 1);
        $("#start-week").html(`${weekStart(time).getDate()}/${weekStart(time).getMonth() + 1}`);
        $("#end-week").html(`${weekEnd(time).getDate()}/${weekEnd(time).getMonth() + 1}`);
    }
    const week = $("#list-week");
    week.html("");
    for (let month = 0; month <= 11; month++) {
        let isWeek = new Date(-1);
        for (let day = 1; day <= 31; day++) {
            // let start = new Date(year, month, day + 7 * day);
            // let end = new Date(year, month, day + 7 + 7 * day);
            let start = weekStart(new Date(year, month, day));
            let end = weekEnd(new Date(year, month, day));

            // let dd = startWeek.getDate();
            // let mm = startWeek.getMonth() + 1;
            // if (dd == 29 && mm == 2)
            //     console.log(`day: ${dd}, month: ${mm}`)

            if (isWeek.toString() !== start.toString()) {
                let startWeek = `${start.getDate()}/${start.getMonth() + 1}`;
                let endWeek = `${end.getDate()}/${end.getMonth() + 1}`;
                week.append(`<li value="" class="p-0 m-0" id="day-${startWeek.replace("/", "")}"><a style="display: block;text-align: center" onclick="getWeekRange('${startWeek}','${endWeek}')">${startWeek} to ${endWeek}</a> </li>`);
                isWeek = start;
            }

        }
    }

    function weekStart(date) {
        return new Date(date.setDate(date.getDate() - date.getDay()));
    }

    function weekEnd(date) {
        var lastday = date.getDate() - date.getDay() + 6;
        return new Date(date.setDate(lastday));
    }


    fetchingScheduleByClassInfor();
}
const getWeekRange = (start, end) => {
    $("#list-week").children().removeClass("menu-active");
    $(`#day-${start.replace("/", "")}`).addClass("menu-active");
    //  currentScroll = $("#list-week").scrollTop();
    const schedule_header = $("#schedule-header");
    let header = "<th></th>";

    schedule_header.html(header);
    $("#start-week").html(start);
    $("#end-week").html(end);
    fetchingScheduleByClassInfor();
}
