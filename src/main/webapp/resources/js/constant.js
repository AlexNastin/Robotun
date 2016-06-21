var ajaxLotMaxSize = 3;
var solrUrl = 'http://localhost:8983/solr/jcg/select';

// constants for autoload lots
// offset is start number lot, which load after scroll window
// offsetStart is start number lot, which is loaded at the first page load
var offset = ajaxLotMaxSize;
var offsetStart = 0;

var timeBlockSendButton = 10000;