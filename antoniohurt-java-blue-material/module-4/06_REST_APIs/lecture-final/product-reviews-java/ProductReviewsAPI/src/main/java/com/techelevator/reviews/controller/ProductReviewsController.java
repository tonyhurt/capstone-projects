package com.techelevator.reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.reviews.dao.IProductReviewDao;
import com.techelevator.reviews.exception.ProductReviewNotFoundException;
import com.techelevator.reviews.model.ProductReview;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin
public class ProductReviewsController {

	@Autowired
	private IProductReviewDao dao;
	
	//@RequestMapping(path="/", method=RequestMethod.GET)
	@GetMapping
	public List<ProductReview> list() {
		return dao.list();
	}
	
	@GetMapping("/{id}")
	public ProductReview read(@PathVariable int id) throws ProductReviewNotFoundException {
		ProductReview productReview = dao.read(id);
		if (productReview != null) {
			return productReview;
		} else {
			// Return a 404 Status
			throw new ProductReviewNotFoundException(id, "Product Review Not Found");
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductReview create(@RequestBody ProductReview productReview) {
		return dao.create(productReview);
	}
	
	@PutMapping("/{id}")
	public ProductReview update(@RequestBody ProductReview productReview, @PathVariable int id) throws ProductReviewNotFoundException {
		ProductReview requestedReview = dao.read(id);
		if ( requestedReview != null) {
			return dao.update(productReview);
		} else {
			// Return a 404 Status
			throw new ProductReviewNotFoundException(id, "Product Review Not Found");
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws ProductReviewNotFoundException {
		if (dao.read(id) != null) {
			// delete the review
			dao.delete(id);
		} else {
			// return a 404 Status
			throw new ProductReviewNotFoundException(id, "Product Review Not Found");
		}
		
	}
	
	
}
