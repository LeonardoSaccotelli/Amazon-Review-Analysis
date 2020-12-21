db.ElectronicsReview.update({}, {$unset: {style:1}} , {multi: true});
