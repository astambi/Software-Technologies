function selectTowns() {
    // alert('click selectTowns');
    let li = $(this);
    if (!li.attr('data-selected')) {
        li.attr('data-selected','true');
        li.css('background','#DDD');
    }
    else {
        li.removeAttr('data-selected');
        li.css('background','');
    }
}

function showTowns() {
    // alert('click showTowns');
    let towns = $('#towns [data-selected=true]')
        .map((i, x) => x.innerText).get();
    let townsDiv = $('<div>')
        .text("Selected towns: " + towns.join(', '));
    $('body').append(townsDiv);
}

$(function () {
    $('#towns li').click(selectTowns);
});

// function showTowns() {
//     let selectedTowns = $('#towns [data-selected=true]');
//     let towns = [];
//     for (let t of selectedTowns)
//         towns.push(t.innerText);
//     let townsDiv = $('<div>')
//         .append("Selected towns: " + towns.join(', '));
//     $('body').append(townsDiv);
// }