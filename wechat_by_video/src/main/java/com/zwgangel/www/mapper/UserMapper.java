package com.zwgangel.www.mapper;

import com.zwgangel.www.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Title: UserMapper
 * @Package: com.zwgangel.www.mapper.UserMapper
 * @Description: User 数据访问层，用户Dao层的数据库表操作(增、删、改、查)
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-19 21:23
 */
public interface UserMapper {

    /**
     * 功能描述 ： 根据用户的id查询用户
     * @param userId
     * @Param("id") String userId 使用id 和userId进行映射
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findUserById(@Param("id") String userId);

    /**
     * 功能描述 ： 根据微信的openid查询用户
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    User findUserByOpenId(@Param("openid") String openid);

    /**
     * 功能描述 ：添加一个用户
     * id 是自增的，所以不需要进行插入
     * @param user
     * @return
     */
    @Insert("INSERT INTO user" +
            "(`openid`, `name`, `head_img`, `phone`, `sign`, `sex`, `city`, `create_time`) " +
            "VALUES (#{openid},#{name},#{headImg},#{phone},#{sign},#{sex},#{city},#{createTime});")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int saveUser(User user);


}
