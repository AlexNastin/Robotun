var block = false;
//если true, то лотов больше нет
var isEnd = false;
$(window).scroll(function () {
	if($(window).height() + $(window).scrollTop() >= $(document).height() && !block && !isEnd) {
		block = true;
		loader();
	}
});