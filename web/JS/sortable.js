var positionlist;

$('.sortable-list').sortable({
    connectWith: '.sortable-list',
    placeholder: "highlight",

    create: function(event, ui){
        var startorder = $(this).sortable('toArray');
        positionlist = startorder.join(';');
        document.getElementById('result').setAttribute('value', positionlist);
    },

    // start: function (event, ui) {
    //     ui.item.toggleClass("highlight");
    // },
    // stop: function (event, ui) {
    //     ui.item.toggleClass("highlight");
    // },
    update: function(event, ui) {
        var order = $(this).sortable('toArray');
        positionlist = order.join(';');
        console.log({
            positionstest: positionlist
         });
        document.getElementById('result').setAttribute('value', positionlist);
    }
});

// $('input#confirm').click(function(){
//     var order = $(this).sortable('toArray');
//     positionlist = order.join(';');
//     document.getElementById('result').setAttribute('value', positionlist);
// });