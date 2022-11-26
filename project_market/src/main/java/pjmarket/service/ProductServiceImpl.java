package pjmarket.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pjmarket.dao.ProductDaoImpl;
import pjmarket.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDaoImpl productdao;

	@Override
	public int insertProduct(Product product) throws Exception {
		int result = productdao.insertProduct(product);
		return result;
	}

	@Override
	public int getListCount(String product_l) throws Exception {
		return productdao.getProductCount(product_l);

	}

	@Override
	public List<Product> getProductlist(int page, String product_l) throws Exception {
		return productdao.getProductlist(page, product_l);
	}

	@Override
	public Product getProductDetail(int product_num) throws Exception {
		return productdao.getProductDetail(product_num);
	}

	@Override
	public List<Product> searchProduct(String product_name) throws Exception {
		return productdao.searchProduct(product_name);
	}

	@Override
	public int searchCount(String product_name) throws Exception {
		return productdao.searchCount(product_name);
	}

	@Override
	public Integer selectProductStar(int product_num) throws Exception {
		return productdao.selectProductStar(product_num);
	}

	@Override
	public Integer selectProductStarCount(int product_num) throws Exception {
		return productdao.selectProductStarCount(product_num);
	}

	@Override
	public int updateProduct(Product product) throws Exception {
		return productdao.updateProduct(product);
	}

	@Override
	public List<Product> getProductlist() throws Exception {
		return productdao.getProductlist();
	}
}
