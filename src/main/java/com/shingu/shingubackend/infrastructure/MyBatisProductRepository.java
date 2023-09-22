package com.shingu.shingubackend.infrastructure;

import com.shingu.shingubackend.domain.model.Product;
import com.shingu.shingubackend.domain.service.ProductRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Repository
public class MyBatisProductRepository implements ProductRepository {

  private final SqlSession sqlSession;

  public MyBatisProductRepository(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public List<Product> findAll() {
    return sqlSession.selectList("com.shingu.shingubackend.domain.service.ProductRepository.findAll");
  }

  @Override
  public List<String> findDistinctCategories() {
    return sqlSession.selectList("findDistinctCategories");
  }

  @Override
  public List<Product> findByCategory(String category) {
    return sqlSession.selectList("findByCategory", category);
  }

  @Override
  public Product findById(Long id) {
    return sqlSession.selectOne("findById", id);
  }

  @Override
  public void save(Product product) {
    sqlSession.insert("save", product);
  }
}
