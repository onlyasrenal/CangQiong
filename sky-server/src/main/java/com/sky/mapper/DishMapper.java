package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {
    /**
     *  根据分类id查询当前分类下关联了多少个菜品
     * @param id
     * @return
     */
    @Select("select count(id) from dish where category_id=#{id}")
    Integer countByCategoryId(Long id);
}
