
var bulkOps = [],
    cursor = db.ElectronicsReview.find({"unixReviewTime": {"$exists": true}});

cursor.forEach(function (doc) { 
    var newDate = new Date(doc.unixReviewTime*1000);
    bulkOps.push(         
        { 
            "updateOne": { 
                "filter": { "_id": doc._id } ,              
                "update": { "$set": { "reviewTime": newDate } } 
            }         
        }           
    );
    if (bulkOps.length === 500) {
        db.ElectronicsReview.bulkWrite(bulkOps);
        bulkOps = [];
    }     
});
if (bulkOps.length > 0) db.ElectronicsReview.bulkWrite(bulkOps);



