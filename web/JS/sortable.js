var positionlist;

$('.sortable-list').sortable({
    connectWith: '.sortable-list',
    placeholder: "highlight",

    create: function(event, ui){
        var startorder = $(this).sortable('toArray');
        positionlist = startorder.join(';');
    },

    // start: function (event, ui) {
    //     ui.item.toggleClass("highlight");
    // },
    // stop: function (event, ui) {
    //     ui.item.toggleClass("highlight");
    // },
    update: function(event, ui) {
        var changedList = this.id;
        var order = $(this).sortable('toArray');
        var positions = order.join(';');
        console.log({
            id: changedList,
            positions: positions
         });
    }
});

$('input#confirm').click(function(){
    document.getElementById('result').value = positionlist;
});