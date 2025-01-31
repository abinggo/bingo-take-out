package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 根据类型查询分类用映射写的
     * @param type
     * @return
     */
    List<Category> list(Integer type);
    @AutoFill(value = OperationType.UPDATE)
    void update(Category category);

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 插入新的分类
     * @param category
     */
    @AutoFill(value = OperationType.INSERT)
    @Insert(
            "insert into category (type, name, sort, status, create_time, update_time, create_user, update_user) " +
                    "values " +
                    "(#{type},#{name},#{sort},#{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})"
    )
    void save(Category category);

    void delete(Long id);
}
