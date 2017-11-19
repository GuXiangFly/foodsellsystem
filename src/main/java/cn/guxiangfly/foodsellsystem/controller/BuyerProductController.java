package cn.guxiangfly.foodsellsystem.controller;

import cn.guxiangfly.foodsellsystem.VO.ProductInfoVO;
import cn.guxiangfly.foodsellsystem.VO.ProductVO;
import cn.guxiangfly.foodsellsystem.VO.ResultVO;
import cn.guxiangfly.foodsellsystem.domain.ProductCategory;
import cn.guxiangfly.foodsellsystem.domain.ProductInfo;
import cn.guxiangfly.foodsellsystem.service.CategoryService;
import cn.guxiangfly.foodsellsystem.service.ProductService;
import cn.guxiangfly.foodsellsystem.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        //1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 查询类目(一次性查询)
        List<Integer> categoryTypeList = new ArrayList<>();

        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }


        //数据开始拼装

        //现将第二层的 类别查出来
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            ArrayList<ProductInfoVO> productInfoVOArrayList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){

                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //将前面的属性都添加到后面
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOArrayList.add(productInfoVO);
                }
            }


            productVO.setProductInfoVOList(productInfoVOArrayList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}