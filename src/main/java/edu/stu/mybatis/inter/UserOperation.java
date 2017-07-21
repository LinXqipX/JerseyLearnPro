package edu.stu.mybatis.inter;

import edu.stu.bean.User;

public interface UserOperation {
    public User seletctUserById(int id);
    public void addOneUser(User user);
    public void deleteOneUserById(int id);
}
