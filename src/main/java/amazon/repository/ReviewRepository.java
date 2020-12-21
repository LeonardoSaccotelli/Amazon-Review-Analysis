package amazon.repository;

import amazon.model.ElectronicsReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ReviewRepository extends MongoRepository<ElectronicsReview, String > {

    @Query("{'asin': ?0  }")
    List<ElectronicsReview> findReviewByProductId(String id);

    @Query("{'reviewerId': ?0  }")
    List<ElectronicsReview> findReviewByUserId(String id);

    @Query("{'allover': {$gt: ?0}}")
    List<ElectronicsReview> findReviewWithRatingGreaterThen(int minScore);
}
