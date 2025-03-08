package az.jobportal.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId,
                                               @RequestBody Review review) {
        boolean created = reviewService.createReview(companyId, review);
        if (created) {
            return new ResponseEntity<>("Review successfully created!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Review not saved!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,
                                            @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review updatedReview) {
        boolean updated = reviewService.updateReview(companyId, reviewId, updatedReview);
        if (updated) {
            return new ResponseEntity<>("Review successfully updated!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not updated!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId) {
        boolean deleted = reviewService.deleteReview(companyId, reviewId);
        if (deleted) {
            return new ResponseEntity<>("Review successfully deleted!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not deleted!", HttpStatus.NOT_FOUND);
    }
}