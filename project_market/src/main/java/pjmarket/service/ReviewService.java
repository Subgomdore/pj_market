package pjmarket.service;

import java.util.List;

import pjmarket.model.Review;

public interface ReviewService {

	public int ReviewInsert(Review review) throws Exception;

	public int getListCount() throws Exception;

	public List<Review> getBoardList(int page) throws Exception;

}