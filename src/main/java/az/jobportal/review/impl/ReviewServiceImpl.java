package az.jobportal.review.impl;

import az.jobportal.company.Company;
import az.jobportal.company.CompanyService;
import az.jobportal.review.Review;
import az.jobportal.review.ReviewRepository;
import az.jobportal.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    @Autowired
    public ReviewServiceImpl (ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = getAllReviews(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if (companyService.getCompanyById(companyId) != null) {
            Company company = companyService.getCompanyById(companyId);
            updatedReview.setCompany(company);
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if (companyService.getCompanyById(companyId) != null) {
            Review review = reviewRepository.findById(reviewId).orElse(null);
            if (review != null) {
                Company company = review.getCompany();
                company.getReviews().remove(review);
                review.setCompany(null);
                companyService.updateCompany(companyId, company);
                reviewRepository.delete(review);
                return true;
            }
        }
        return false;
    }
}