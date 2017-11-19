package cn.guxiangfly.foodsellsystem.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * CategoryForm
 *
 * @author guxiang
 * @date 2017/11/18
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    @NotEmpty(message = "类目名字必填")
    private String categoryName;

    /** 类目编号. */
    @NotEmpty(message = "类目编号必填")
    private Integer categoryType;

}
