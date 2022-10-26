
package pjmarket.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pjmarket.model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private SqlSessionTemplate session;

	// 게시판에저장 //
	@Override
	public int ReviewInsert(Review review) throws Exception {
		System.out.println("review_insert.jsp------------");

		return session.insert("reviewns.review_insertresult", review);
	}

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return session.selectOne("reviewns.review_count");
	}

	public List getBoardList(int page) {
		List<Review> list = session.selectList("reviewns.review_boardlist", page);
		return list;
	}

}
