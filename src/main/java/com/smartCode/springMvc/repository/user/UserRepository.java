package com.smartCode.springMvc.repository.user;

import com.smartCode.springMvc.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository()
@Scope("singleton")
public interface UserRepository extends JpaRepository<User,Long> {

    User getByEmail (String email);






}
