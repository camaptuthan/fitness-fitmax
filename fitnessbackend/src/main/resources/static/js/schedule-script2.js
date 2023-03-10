$(window).on("load", (event) => {
    getYear();

})
// schedule parts
const scheduleEle = $("#schedule-table");
const scheduleHeaderEle = $("#schedule-header");
const scheduleBodyEle = $("#schedule-body");

//year parts
const yearsEle = $("#list-year");
const currentYearEle = $("#current-year");
const getYear = () => {
    const currentYear = new Date().getFullYear();
    let startYear = 2020;
    while (startYear <= new Date().getFullYear()) {
        yearsEle.append(`<li class="p-0 m-0" id="${startYear}-selector">
                            <a style="display: block;text-align: center" onclick="getWeek(${startYear})">${startYear}</a> 
                          </li>`)
        startYear++
    }
    currentYearEle.html(currentYear);
    $(`#${currentYear}-selector`).addClass("menu-active");
    getWeek(currentYear);
}

const weeksEle = $("#list-week");
const startWeekEle = $("#start-week");
const endWeekEle = $("#end-week");
const getWeek = (year) => {

    yearsEle.children().removeClass("menu-active");
    $(`#${year}-selector`).addClass("menu-active");
    currentYearEle.html(year);

    let time = new Date().getFullYear() === year ? new Date() : new Date(year, 0, 1);

    startWeekEle.html(`${weekStart(time).getDate()}/${weekStart(time).getMonth() + 1}`);
    endWeekEle.html(`${weekEnd(time).getDate()}/${weekEnd(time).getMonth() + 1}`);

    weeksEle.html("");
    let isWeek = '';
    for (let month = 0; month <= 11; month++) {
        for (let day = 1; day <= 31; day++) {
            let start = weekStart(new Date(year, month, day));
            let end = weekEnd(new Date(year, month, day));

            if (isWeek !== (start + end)) {
                let startWeek = `${start.getDate()}/${start.getMonth() + 1}`;
                let endWeek = `${end.getDate()}/${end.getMonth() + 1}`;
                weeksEle.append(`<li class="p-0 m-0" id="day-${startWeek.replace("/", "")}">
                <a style="display: block;text-align: center" onclick="getWeekRange('${start}','${end}')">${startWeek} to ${endWeek}</a> </li>`);
                isWeek = start + end;
            }
        }
    }


    function weekStart(date) {
        return new Date(date.setDate(date.getDate() - date.getDay()));
    }

    function weekEnd(date) {
        return new Date(date.setDate(date.getDate() - date.getDay() + 6));
    }

    getWeekDays(weekStart(time), weekEnd(time));
}


const getWeekRange = (start, end) => {
    let startDate = new Date(start);
    let endDate = new Date(end);

    let startWeek = `${startDate.getDate()}/${startDate.getMonth() + 1}`;
    let endWeek = `${endDate.getDate()}/${endDate.getMonth() + 1}`;

    weeksEle.children().removeClass("menu-active");
    $(`#day-${startWeek.replace("/", "")}`).addClass("menu-active");

    getWeekDays(startDate, endDate);

    startWeekEle.html(startWeek);
    endWeekEle.html(endWeek);
}

const getWeekDays = (weekStart, weekEnd) => {
    let schedule_header = "<th rowspan='2' class='time-col'>Time</th>";
    while (weekStart <= weekEnd) {
        schedule_header += `
                <th>
                <a href="" class="d-block">${weekStart.toLocaleDateString('en-US', {weekday: 'long'})}</a>
                ${weekStart.getDate()}/${weekStart.getMonth() + 1}
                </th>`;
        weekStart.setDate(weekStart.getDate() + 1);
    }
    scheduleHeaderEle.html(schedule_header);

    setTimeout(getSchedule, 100);

}
const getSchedule = () => {
    let start_time = `${startWeekEle[0].innerText}/${currentYearEle[0].innerText}`;
    let end_time = `${endWeekEle[0].innerText}/${currentYearEle[0].innerText}`;
    const api_path = `http://localhost:8080/api/v1/schedule?start=${start_time}&end=${end_time}`;
    $.get(api_path, (result) => {
        scheduleBodyEle.html("");
        const data = result;
        data.forEach((schedule) => {
            const start_schedule = schedule.startTime.toString().substring(0, 5);
            const end_schedule = schedule.endTime.toString().substring(0, 5);
            scheduleBodyEle.append(
                `<tr id="${schedule.id}" data-value="${start_schedule + '/' + end_schedule}" data-exist="${schedule.haveSessions}"style="height: 6rem;">
                    <td class='time-col'>${start_schedule}</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>                            
                </tr>`);

        })
    }).success(() => {
        setTimeout(getSession, 1000);
    });
}

const getSession = () => {

    scheduleBodyEle.children().each((index, element) => {
        let scheduleEle = $(element);
        let schedule_id = scheduleEle.attr("id");
        let schedule_value = scheduleEle.data('value');
        let schedule_exist = scheduleEle.data('exist');
        let schedule_startTime = schedule_value.split("/")[0];
        let schedule_endTime = schedule_value.split("/")[1];
        scheduleEle.children().not(".time-col").html("");
        let start_time = `${startWeekEle[0].innerText}/${currentYearEle[0].innerText}`;
        let end_time = `${endWeekEle[0].innerText}/${currentYearEle[0].innerText}`;
        let api_path = `http://localhost:8080/api/v1/schedule/session/${schedule_id}?start=${start_time}&end=${end_time}`;

        if (schedule_exist) {
            $.get(api_path, (result) => {
                const data = result;
                data.forEach((session) => {
                    let sessionEle = $(`#${schedule_id}`).children().eq(session.weekDay);
                    sessionEle.html(
                        `
                        <div class="w-100 h-100" style="display: none">
                            <h4><a href="">${session.name}</a></h4>
                            <div class="date">${schedule_startTime} – ${schedule_endTime}</div>
                            <div class="name">${session.happenedDate}</div>
                        </div>
                        `);
                    sessionEle.children().fadeIn(1000 + index * 250);
                });
            }).success(() => {
                console.log(api_path);
            });
        }
    });
}