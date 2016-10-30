var ajaxLotMaxSize = 3;
var solrUrl = 'http://localhost:8983/solr/jcg/select';

// constants for autoload lots
// offset is start number lot, which load after scroll window
// offsetStart is start number lot, which is loaded at the first page load
var offset = ajaxLotMaxSize;
var offsetStart = 0;

var timeBlockSendButton = 600000;

//URL images for lot`s logo
var globalPath = '/jobster.by/resources/images/avatar_lot/';
var lotsImages = [];
lotsImages[0] = globalPath + '0.jpg';
lotsImages[1] = globalPath + '1.jpg';
lotsImages[2] = globalPath + '2.jpg';
lotsImages[3] = globalPath + '3.jpg';
lotsImages[4] = globalPath + '4.jpg';
lotsImages[5] = globalPath + '5.jpg';
lotsImages[6] = globalPath + '6.jpg';
lotsImages[7] = globalPath + '7.jpg';
lotsImages[8] = globalPath + '8.jpg';

//return random integer value from min to max
function getRandomInt(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

var cities = [ {
	id_city : 1,
	title : "Минск"
}, {
	id_city : 2,
	title : "Минская обл."
}, {
	id_city : 3,
	title : "Витебск"
}, {
	id_city : 4,
	title : "Витебская обл."
}, {
	id_city : 5,
	title : "Могилев"
}, {
	id_city : 6,
	title : "Могилевская обл."
}, {
	id_city : 7,
	title : "Брест"
}, {
	id_city : 8,
	title : "Брестская обл."
}, {
	id_city : 9,
	title : "Гомель"
}, {
	id_city : 10,
	title : "Гомельская обл."
}, {
	id_city : 11,
	title : "Гродно"
}, {
	id_city : 12,
	title : "Гродненская обл."
} ];
