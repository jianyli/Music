package com.li.dao;

import com.li.entity.UserMoodRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMoodRelDao {
    boolean save( UserMoodRel userMoodRel);
}
