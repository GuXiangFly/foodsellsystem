package cn.guxiangfly.foodsellsystem.repository;

import cn.guxiangfly.foodsellsystem.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ProductCategoryRepository
 *
 * @author guxiang
 * @date 2017/11/4
 */
public interface ProductCategoryRepository  extends JpaRepository<ProductCategory,Integer>{

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
