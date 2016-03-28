var block = false;
//если true, то лотов больше нет
var isEnd = false;
$(window).scroll(function () {
	console.log($(window).height() + $(window).scrollTop());
	console.log($(document).height());
	if($(window).height() + $(window).scrollTop() >= $(document).height() && !block && !isEnd) {
		block = true;
		loader();
	}
});
//начиная с
var offset = 1;

function print(idLot, name, description, budget, endDate) {
	var content = document.getElementById("list-group").innerHTML;
	var newContent ="";
	newContent += "<div class=\"col-md-12 users-legal-boards\"><div class=\"col-md-3\"><img src=\"/webapp/resources/images/fabian-perez.jpg\" class=\"img-responsive img-thumbnail users-legal-img\" alt=\"Image\"></div><div class=\"col-md-9 moderator-descripton\"><div class=\"col-md-12 text-moderator-description\"><a href='/webapp/lot?id=" + idLot + "' style=\"font-size: 18pt;\">" + name + "</a></div><div class=\"col-md-12 text-moderator-description\">" + description + "</div><div class=\"col-md-12 text-moderator-description legal-users-board-margin\">Бюджет: " + budget + "</div><div class=\"col-md-12 text-moderator-description legal-users-board-margin\">Активен до: " + endDate + "</div><div class=\"col-md-12\" style=\"text-align:right;\"><a class=\"btn btn-primary button-legal-style-main\" href='/webapp/lot?id=" + idLot + "'>Подробнее</a></div></div></div>";
	document.getElementById("list-group").innerHTML = content + newContent  ;
}