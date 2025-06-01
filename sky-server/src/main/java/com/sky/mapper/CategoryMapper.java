package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 新增分类
     *
     * @param category
     */
    @Insert("insert into category (type, name, sort, status, create_time, update_time, create_user, update_user) " +
            " values " +
            "(#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Category category);

    /**
     * 根据分类名称查询
     *
     * @param category
     * @return
     */
    @Select("select COUNT(*) from category where name = #{name}")
    Category findByName(Category category);

    /**
     * 分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Select("select * from category where id = #{id}")
    Category findById(Long id);

    /**
     * 修改分类
     *
     * @param category
     */
    void update(Category category);

    /**
     * 根据类型查询分类
     *
     * @param type
     * @return
     */
    @Select("select * from category where type = #{type} order by sort")
    List<Category> list(Integer type);

    /**
     *  删除分类
     * @param id
     */
    @Delete("delete from category where id = #{id}")
    void delete(Long id);
}
