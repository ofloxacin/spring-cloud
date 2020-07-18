package com.ofloxacin.dao;

import com.ofloxacin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chenshuai
 * @date 2020/07/18
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
