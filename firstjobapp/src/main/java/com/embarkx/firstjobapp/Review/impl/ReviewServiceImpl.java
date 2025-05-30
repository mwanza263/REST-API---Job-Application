package com.embarkx.firstjobapp.Review.impl;

import com.embarkx.firstjobapp.Company.Company;
import com.embarkx.firstjobapp.Company.CompanyService;
import com.embarkx.firstjobapp.Review.Review;
import com.embarkx.firstjobapp.Review.ReviewRepository;
import com.embarkx.firstjobapp.Review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService =companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findAllByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return  true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findAllByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }
    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.getCompanyById(companyId) != null){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)){
            List<Review> reviews = reviewRepository.findAllByCompanyId(companyId);
            Review reviewToDelete = reviewRepository.findById(reviewId).orElse(null);
            Company company = reviewToDelete.getCompany();
            reviewToDelete.setCompany(null);
            companyService.updateCompany(company, company.getId());
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }


}
