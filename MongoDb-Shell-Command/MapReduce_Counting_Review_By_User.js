//Mapping and count each pair user_id, review_rating
var map = function(){
	emit({ user_id: this.reviewerID, review_rating:this.overall}, {count:1});
};

//Reduce the result of map() function
//Counting the number of ratings, for each user
var reduce = function(key, values){
	var count = 0;
	values.forEach(function(v){
		count += v['count'];
	});
	
	return {count:count};
};

var group_by_user_by_rating = db.ElectronicsReview.mapReduce(map, reduce, {out:'group_by_user_by_rating' });

//Now we can use this filtering the result in different way

//All product grouped by ratings
db[group_by_user_by_rating.result].find()

//For one product, counting of each ratings range
db[group_by_user_by_rating.result].find({"_id.user_id": "A33CQQQ6H25GGD"});