var map = function (){
	emit({ verified: this.verified}, {count:1});
}

var reduce = function(key,values){
	var count = 0;
	values.forEach(function(v){
		count += v['count'];
	});
	
	return {count:count};
};

var counting_verify_review = db.ElectronicsReview.mapReduce(map, reduce, {out:'counting_verify_review' });

db[counting_verify_review.result].find();