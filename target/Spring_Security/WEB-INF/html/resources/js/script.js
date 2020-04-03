//
//
// $(function ($) {
//     // $('#sendDataAdd').css({border: '1px solid red'});
//     $('#sendDataAdd').click(function (e) {
//         e.preventDefault();
//         $('#ajax').html('<span>Send</span>').fadeIn(1000, function () {
//             var result = $('#contactFormAdd').serializeArray();
//             $.ajax({
//                 url:,
//                 type: 'POST',
//                 data: result,
//                 dataType: 'json',
//                 context: document.getElementById('#ajax'),
//                 success: function (data, status, jqXHR) {
//                     var block = $(this);
//                     $(this).find('span').fadeOut(1000, function () {
//                         $(this).text('addad').fadeIn(300);
//
//                     });
//                     $(this).delay(1000).fadeOut(1000, function () {
//                         $('#down').append('<h3>' + data.firstName + '</h3>' + '<p>' + data.email + '</p>)');
//                     });
//                 }
//             });
//             alert(result);
//         });
//     });
//
// });

$(function ($) {
    // $('#sendDataAdd').css({border: '1px solid red'});
    $('#sendDataAdd').click(function (e) {
        alert('stop');
        e.preventDefault();
        $('#ajax').html('<span>Send</span>').fadeIn(1000, function () {
            var result = $('#contactFormAdd').serializeArray();
            console.log(result);
            var block = $(this);
            $(this).find('span').fadeOut(1000, function () {
                $(this).text('added').fadeIn(300);

            });
            $(this).delay(2000).fadeOut(2000, function () {
                $('#down').css({border: '2px solid green'});
                $('#down').append('<h3>' + result.firstName + '</h3>' + '<p>' + result.email + '</p>'+ '<p>' + 'drsgrg'+ '</p>');
            });

            alert(result);
        });
    });

});

