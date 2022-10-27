package pjmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pjmarket.dao.ProductDaoImpl;
import pjmarket.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDaoImpl productdao;
	
	@Override
	public void insertProduct(Product product) throws Exception{
		System.out.println("insertProduct Service 진입");
		productdao.insertProduct(product);
	}
	
	
}