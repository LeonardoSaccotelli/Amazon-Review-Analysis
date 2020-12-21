package amazon.controller;

import amazon.model.ElectronicsReview;
import amazon.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/findAllReview")
    public List<ElectronicsReview> getAllReview(){
        return reviewService.getAllReview();
    }

    @GetMapping("/findAllReviewByReviewId/{id}")
    public Optional<ElectronicsReview> getReviewById(@PathVariable String id){
        return reviewService.getReviewByReviewId(id);
    }

    @GetMapping("/findAllReviewByProductId/{id}")
    public List<ElectronicsReview> getReviewByProductId(@PathVariable String id){
        return reviewService.getReviewByProductId(id);
    }

    @GetMapping("/findAllReviewByUserId/{id}")
    public List<ElectronicsReview> getReviewByUserId(@PathVariable String id){
        return reviewService.getReviewByUserId(id);
    }

    @GetMapping("/findAllReviewWithRatingGreaterThan/{minRating}")
    public List<ElectronicsReview> getReviewWithRatingGreaterThan(@PathVariable String minRating){
        return reviewService.getReviewWithRatingGreaterThan(Integer.parseInt(minRating));
    }
}