function addCountryToTable(country, capital) {
    let row = $('<tr>')
        .append($('<td>').text(country))
        .append($('<td>').text(capital))
        .append($('<td>')
            .append($('<a href="#" onclick="moveRowUp(this)">[Up]</a>'))
            .append(" ")
            .append($('<a href="#" onclick="moveRowDown(this)">[Down]</a>'))
            .append(' ')
            .append($('<a href="#" onclick="deleteRow(this)">[Delete]</a>'))
        );
    $('#countriesTable').append(row);
    fixRowLinks();
    return row;
}
function addInitialCountries() {
    addCountryToTable("Bulgaria", "Sofia");
    addCountryToTable("Germany", "Berlin");
    addCountryToTable("France", "Paris");
    addCountryToTable("Spain", "Madrid");
    addCountryToTable("Portugal", "Lisbon");
    addCountryToTable("The Netherlands", "Amsterdam");
}
function addCountry() {
    let country = $('#newCountryText');
    let capital = $('#newCapitalText');
    let row = addCountryToTable(country.val(), capital.val());
    row.hide();
    row.fadeIn();
    country.val('');
    capital.val('');
    fixRowLinks();
}
function deleteRow(link) {
    let row = $(link).parent().parent();
    row.fadeOut(function () {
        row.remove();
        fixRowLinks();
    });
}
function moveRowUp(link) {
    let row = $(link).parent().parent();
    row.fadeOut(function () {
        row.insertBefore(row.prev());
        row.fadeIn();
        fixRowLinks();
    });
}
function moveRowDown(link) {
    let row = $(link).parent().parent();
    row.fadeOut(function () {
        row.insertAfter(row.next());
        row.fadeIn();
        fixRowLinks();
    });
}
function fixRowLinks() {
    // show all links in the table
    $('#countriesTable a').show();
    let tableRows = $('#countriesTable tr');
    // hide the [Up] link in the first table row
    $(tableRows[1]).find("a:contains('Up')").hide();
    // hide the [Down] link in the last table row
    $(tableRows[tableRows.length - 1]).find("a:contains('Down')").hide();
}
$(addInitialCountries);