/* CALENDAR */

function  init_calendar() {

    if( typeof ($.fn.fullCalendar) === 'undefined'){ return; }
    console.log('init_calendar');

    var date = new Date(),
        d = date.getDate(),
        m = date.getMonth(),
        y = date.getFullYear(),
        started,
        categoryClass;

    var calendar = $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listMonth'
        },
        selectable: true,
        selectHelper: true,
        select: function(start, end, allDay) {
            $('#fc_create').click();
            console.log("show create modal");

            started = start;
            ended = end;

            $(".antosubmit").on("click", function() {
            //     var title = $("#title").val();
            //     if (end) {
            //         ended = end;
            //     }
            //
            //     categoryClass = $("#event_type").val();
            //
            //     if (title) {
            //         calendar.fullCalendar('renderEvent', {
            //                 title: title,
            //                 start: started,
            //                 end: end,
            //                 allDay: allDay
            //             },
            //             true // make the event "stick"
            //         );
            //     }
            //
            //     $('#title').val('');
            //
            //     calendar.fullCalendar('unselect');
            //
                $('.antoclose').click();
            //
                return false;
            });
        },
        eventClick: function(calEvent, jsEvent, view) {
            $('#fc_edit').click();
            $('#title2').val(calEvent.title);

            categoryClass = $("#event_type").val();

            $(".antosubmit2").on("click", function() {
                calEvent.title = $("#title2").val();

                calendar.fullCalendar('updateEvent', calEvent);
                $('.antoclose2').click();
            });

            calendar.fullCalendar('unselect');
        },
        editable: true,
        // events: [{
        //     title: 'All Day Event',
        //     start: new Date(y, m, 1)
        // }, {
        //     title: 'Long Event',
        //     start: new Date(y, m, d - 5),
        //     end: new Date(y, m, d - 2)
        // }, {
        //     title: 'Meeting',
        //     start: new Date(y, m, d, 10, 30),
        //     allDay: false
        // }, {
        //     title: 'Lunch',
        //     start: new Date(y, m, d + 14, 12, 0),
        //     end: new Date(y, m, d, 14, 0),
        //     allDay: false
        // }, {
        //     title: 'Birthday Party',
        //     start: new Date(y, m, d + 1, 19, 0),
        //     end: new Date(y, m, d + 1, 22, 30),
        //     allDay: false
        // }, {
        //     title: 'Click for Google',
        //     start: new Date(y, m, 28),
        //     end: new Date(y, m, 29),
        //     url: 'http://google.com/'
        // },{
        //     title: 'phoebe',
        //     start: new Date(y, m, 15),
        // }]
    });

};

init_calendar();
$(".fc-widget-content .fc-scroller").css("overflow-y","hidden");

/*
$(".fc-day").each(function (value) {
   if($(this).attr("data-date")==="2018-03-15"){
       $(this).addClass("fc-bgevent");
       console.log("add class");
   }



});
*/

// $(".fc-day").on("click",function () {
//    console.log("click grid",$(this).attr("data-date"));
// });

$(".fc-prev-button").on("click",function () {
    $(".fc-widget-content .fc-scroller").css("overflow-y","hidden");
});
$(".fc-next-button").on("click",function () {
    $(".fc-widget-content .fc-scroller").css("overflow-y","hidden");
});