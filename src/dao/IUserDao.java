package dao;

import java.util.List;

import model.User;

/**
 * @author 胖大星
 * 用于用户数据的增删改查  未完成
 */
public interface IUserDao {

    // 增加

    public abstract boolean insertUser(User model) throws Exception;

    // 删除

    public abstract boolean deleteUser(String userName) throws Exception;

    // 修改

    public abstract boolean updateUser(User model) throws Exception;

    // 查询（所有）

    public abstract List<User> findAll() throws Exception;

    // 查询（条件）

    public abstract boolean findByTerm(User model) throws Exception;

}
