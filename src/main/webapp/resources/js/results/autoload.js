var block = false;
//если true, то лотов больше нет
var isEnd = false;
$(window).scroll(function () {
	if($(window).height() + $(window).scrollTop() >= $(document).height() && !block && !isEnd) {
		block = true;
		loader();
	}
});
//начиная с
var offset = 1;

function print(idLot, name, description, budget) {
	var content = document.getElementById("list-group").innerHTML;
	var newContent ="";
		newContent += "<a href='/webapp/lot?id=" + idLot + "' class=\"list-group-item\"><div class=\"media col-md-3\"><figure class=\"pull-left\"><img class=\"media-object img-rounded img-responsive\"  src=\"/webapp/resources/images/logoJob.png\"></figure></div><div class=\"col-md-6\"><h4 class=\"list-group-item-heading\">" + name + "</h4><p class=\"list-group-item-text\">" + description + "</p></div><div class=\"col-md-3 text-center\"><h2>" + budget + "<small> бел. руб. </small></h2><button type=\"button\" class=\"btn btn-default btn-lg btn-block\"> Помочь! </button></div></a>";
    document.getElementById("list-group").innerHTML = content + newContent  ;
}