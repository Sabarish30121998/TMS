package com.example.TMS.Repository;

import com.example.TMS.EntityORModel.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    Page<User> searchAllByUserNameLike(String s, Pageable paging);
}
