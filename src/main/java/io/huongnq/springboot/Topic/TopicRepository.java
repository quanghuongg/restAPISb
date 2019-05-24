package io.huongnq.springboot.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TopicRepository  extends JpaRepository<Topic, Integer> {

    @Query(value = "select * from topic u where u.id = :id limit 1", nativeQuery = true)
    Optional<Topic> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "delete from topic where id = :id", nativeQuery = true)
    void deleteByTopicId(@Param("id") Integer id);

}
