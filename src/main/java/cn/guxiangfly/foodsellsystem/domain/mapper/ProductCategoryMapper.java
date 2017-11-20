package cn.guxiangfly.foodsellsystem.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ProductCategoryMapper
 *
 * @author guxiang
 * @date 2017/11/19
 */
public interface ProductCategoryMapper {

        @Insert("insert into product_category(category_name,category_type) values (#{category_name,jdbcType=VARCHAR},#{category_type,jdbcType=INTEGER})")
    public int insertByMap(Map<String,Object> map);
}
