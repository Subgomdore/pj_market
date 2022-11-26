package pjmarket.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pjmarket.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertProduct(Product product) throws Exception {
		int product_num = sqlSession.insert("productns.product_insert", product);

		return product_num;
	}

	@Override
	public int getProductCount(String product_l) throws Exception {
		int count = 0;
		count = ((Integer) sqlSession.selectOne("productns.product_count", product_l)).intValue();
		return count;

	}

	@Override
	public List<Product> getProductlist(int page, String product_l) throws Exception {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("page", page);
		map.put("product_l", product_l);

		List<Product> list = sqlSession.selectList("productns.product_list", map);

		return list;
	}

	@Override
	public Product getProductDetail(int product_num) throws Exception {
		return (Product) sqlSession.selectOne("productns.product_detail", product_num);
	}

	@Override
	public List<Product> searchProduct(String product_name) throws Exception {
		List<Product> searchlist = sqlSession.selectList("productns.product_search", product_name);
		return searchlist;
	}

	@Override
	public int searchCount(String product_name) throws Exception {
		int count = sqlSession.selectOne("productns.search_count", product_name);
		return count;
	}

	@Override
	public Integer selectProductStar(int product_num) throws Exception {
		Integer product_star = sqlSession.selectOne("productns.select_product_star", product_num);
		return product_star;
	}

	@Override
	public Integer selectProductStarCount(int product_num) throws Exception {
		Integer product_starcount = sqlSession.selectOne("productns.select_product_star_count", product_num);
		return product_starcount;
	}

	@Override
	public int updateProduct(Product product) throws Exception {
		int result = sqlSession.update("productns.update_product", product);
		return result;
	}

	@Override
	public List<Product> getProductlist() throws Exception {
		List<Product> mainlist = sqlSession.selectList("productns.main_list");
		return mainlist;
	}
}
