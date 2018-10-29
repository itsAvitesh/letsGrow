package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	private static Map<String, Product> productRepo = new HashMap();
	static {
		Product p1 = new Product();
		p1.setId("1");
		p1.setName("Almond");
		productRepo.put(p1.getId(), p1);

		Product p2 = new Product();
		p2.setId("2");
		p2.setName("Cashew");
		productRepo.put(p2.getId(), p2);
	}

	@Override
	public void createProduct(Product product) {
		productRepo.put(product.getId(), product);
	}

	@Override
	public void updateProduct(String id, Product product) {
		if (!productRepo.containsKey(id))
			throw new ProductNotfoundException();
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
	}

	@Override
	public void deleteProduct(String id) {
		productRepo.remove(id);
	}

	@Override
	public Collection<Product> getProducts() {
		return productRepo.values();
	}

}
