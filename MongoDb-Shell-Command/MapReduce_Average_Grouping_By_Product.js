var map = function(){
	emit(this.asin, this.overall);
};

var reduce = function(key,values){
	return Array.avg(values);
};
		
var average_rating_per_product = db.ElectronicsReview.mapReduce(map,reduce ,{out:'average_rating_per_product' });

db[average_rating_per_product.result].find();

db[average_rating_per_product.result].find({"_id":"0060009810"});

db[average_rating_per_product.result].find({"value":{$gt:4}});

db[average_rating_per_product.result].find({"value":{$gt:4}}).count();

db[average_rating_per_product.result].find({"value":{$gte:2, $lte:4 }});

db[average_rating_per_product.result].find({"value":{$gte:2, $lte:4 }}).count();

	