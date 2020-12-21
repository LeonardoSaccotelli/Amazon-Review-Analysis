//Create index on product_id field
db.ElectronicsReview.ensureIndex({asin:1});

//Create index on reviewer_id and reviewer_name fields
db.ElectronicsReview.ensureIndex({reviewerID:1});
db.ElectronicsReview.ensureIndex({reviewerName:1});

//Create index on overall field
db.ElectronicsReview.ensureIndex({overall:1})

