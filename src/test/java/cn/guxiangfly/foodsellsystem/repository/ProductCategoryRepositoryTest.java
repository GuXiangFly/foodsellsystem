package cn.guxiangfly.foodsellsystem.repository;

import cn.guxiangfly.foodsellsystem.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * ProductCategoryRepositoryTest
 *
 * @author guxiang
 * @date 2017/11/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
   // @Transactional  在测试中 这个是完全回滚 无论是否成功都回滚
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
        ProductCategory result = repository.save(productCategory);

       // Assert.assertNotNull(result);
//        Assert.assertNotEquals(null, result);
    }
}