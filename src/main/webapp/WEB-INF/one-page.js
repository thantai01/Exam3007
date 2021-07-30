function load() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/categories",
        success: function (categories) {
            let content = "";
            for (let i = 0; i < categories.length; i++) {
                str += "<h3>" + categories[i].id + " : " + categories[i].cname + "</h2>"
            }
            document.getElementById("categories").innerHTML = str;

        }
    })
}