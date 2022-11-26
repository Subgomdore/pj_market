package pjmarket.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pjmarket.model.LikeList;
import pjmarket.model.Likes;

@Repository
public class LikeDaoImpl implements LikeDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<LikeList> getLikeList(String member_id) {
		List<LikeList> list = sqlSession.selectList("likens.like_list", member_id);
		return list;
	}

	@Override
	public int deleteLikes(int likes_num) {
		int result = 0;
		result = sqlSession.delete("likens.like_delete", likes_num);
		return result;
	}

	@Override
	public int insertLike(int product_num, int options_num, String member_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product_num", product_num);
		map.put("options_num", options_num);
		map.put("member_id", member_id);

		Likes like = new Likes();
		like = sqlSession.selectOne("likens.selectlike", map);
		int result = 0;

		if (like == null) {
			result = sqlSession.insert("likens.insertlike", map);
		} else {
			result = 4;
		}

		return result;

	}

}
