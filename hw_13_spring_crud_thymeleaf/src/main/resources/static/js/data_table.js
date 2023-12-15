$(document).ready(function() {
    $('#selectSize').change(function(){
        let pageSize = $(this).find("option:selected").attr('value');
        let pageData = document.getElementById('pageData');
        const sortBy = pageData.getAttribute('data-sort-by');
        const sortType = pageData.getAttribute('data-sort-type');
        const parkId = pageData.getAttribute('data-park-id');
        submitRequest(sortBy, sortType, 1, pageSize, parkId)
    });
});

function runPagination(currentPage) {
    let pageData = document.getElementById('pageData');
    const sortBy = pageData.getAttribute('data-sort-by');
    const sortType = pageData.getAttribute('data-sort-type');
    const pageSize = pageData.getAttribute('data-page-size');
    const parkId = pageData.getAttribute('data-park-id');
    submitRequest(sortBy, sortType, currentPage, pageSize, parkId)
}

function submitRequest(sortBy, sortType, currentPage, pageSize, parkId) {
    let data_table_car_submit = document.getElementById('data_table_car_submit');
    if (data_table_car_submit !== null) {
        let data_table_car = document.getElementById('data_table_car');
        if (data_table_car !== null) {
            let input = document.createElement("input");
            input.setAttribute("type", "hidden");
            input.setAttribute("name", "sortBy");
            input.setAttribute("value", sortBy);
            data_table_car.appendChild(input);
            input = document.createElement("input");
            input.setAttribute("type", "hidden");
            input.setAttribute("name", "sortType");
            input.setAttribute("value", sortType);
            data_table_car.appendChild(input);
            input = document.createElement("input");
            input.setAttribute("type", "hidden");
            input.setAttribute("name", "currentPage");
            input.setAttribute("value", currentPage);
            data_table_car.appendChild(input);
            input = document.createElement("input");
            input.setAttribute("type", "hidden");
            input.setAttribute("name", "pageSize");
            input.setAttribute("value", pageSize);
            data_table_car.appendChild(input);
            if (parkId) {
                input = document.createElement("input");
                input.setAttribute("type", "hidden");
                input.setAttribute("name", "parkId");
                input.setAttribute("value", parkId);
                data_table_car.appendChild(input);
            }
            data_table_car_submit.click();
        }
    }
}