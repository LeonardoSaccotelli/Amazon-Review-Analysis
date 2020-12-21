package amazon.service;

import amazon.model.ElectronicsReview;
import amazon.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ElectronicsReview> getAllReview(){
        return reviewRepository.findAll();

    }

    public Optional<ElectronicsReview> getReviewByReviewId(String id) {
        return reviewRepository.findById(id);
    }

    public List<ElectronicsReview> getReviewByProductId(String id){
        return reviewRepository.findReviewByProductId(id);
    }

    public List<ElectronicsReview> getReviewByUserId(String id){
        return reviewRepository.findReviewByUserId(id);
    }

    public List<ElectronicsReview> getReviewWithRatingGreaterThan(int minRating){
        return reviewRepository.findReviewWithRatingGreaterThen(minRating);
    }

}
