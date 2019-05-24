package io.huongnq.springboot.Topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface TopicService {


    Topic addTopic(Topic topic);
    String updateTopic(Topic topic);
    Optional<Topic> findById(Integer id);
    void deleteById(Integer id);
    Page<Topic> listAllTopic(Pageable pageable);
}
