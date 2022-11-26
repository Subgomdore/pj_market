package pjmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pjmarket.dao.LikeDaoImpl;
import pjmarket.model.LikeList;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeDaoImpl likedao;

	@Override
	public List<LikeList> getLikeList(String member_id) throws Exception {
		return likedao.getLikeList(member_id);
	}

	@Override
	public int deleteLikes(int likes_num) throws Exception {
		return likedao.deleteLikes(likes_num);
	}

	@Override
	public int insertLike(int product_num, int options_num, String member_id) {
		return likedao.insertLike(product_num, options_num, member_id);
	}
}
