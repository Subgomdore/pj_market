package pjmarket.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pjmarket.model.Cart;
import pjmarket.model.CartList;
import pjmarket.model.Likes;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<CartList> getListCart(String member_id) throws Exception {
		List<CartList> list = sqlSession.selectList("cartns.cart_list", member_id);
		return list;
	}

	@Override
	public int insertCart(int likes_num) throws Exception {
		Likes likes = new Likes();
		likes = sqlSession.selectOne("cartns.selectlikecheck", likes_num);
		Cart cart = new Cart();
		cart = sqlSession.selectOne("cartns.selectcartcheck", likes);
		int result = 0;
		if (cart == null) {
			result = sqlSession.insert("cartns.cart_insert", likes);
		} else {
			result = sqlSession.update("cartns.cart_update", cart);
		}
		return result;
	}

	@Override
	public int insertCart(Cart cart) throws Exception {
		int result = sqlSession.insert("cartns.insertcart", cart);
		return result;
	}

	@Override
	public int deleteCart(int cart_num) throws Exception {
		int result = sqlSession.delete("cartns.cart_delete", cart_num);
		return result;
	}
}
