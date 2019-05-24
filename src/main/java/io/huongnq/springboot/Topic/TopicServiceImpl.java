package io.huongnq.springboot.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service(value = "TopicService")
public class TopicServiceImpl implements TopicService, UserDetailsService {
    @Autowired
    private TopicRepository topicRepository;


    @Override
    public Optional<Topic> findById(Integer id) {
        return topicRepository.findById(id);
    }


    @Override
    public Topic addTopic(Topic topic) {
        long createdTime = System.currentTimeMillis();

        // add Topic

        topic.setId(topic.getId());
        topic.setDetail(topic.getDetail());
        topic.setType(topic.getType());
        topic.setCreated(createdTime);
        topicRepository.save(topic);
        return topic;
    }



    @Override
    @Transactional
    public String updateTopic(Topic topic) {
        Optional<Topic> t = topicRepository.findById(topic.getId());
        if(!t.isPresent())
        {
            return "Update Fail";
        }

        long updatedTime = System.currentTimeMillis();

        topic.setUpdated(updatedTime);

        topicRepository.save(topic);

        return "Update Success";
    }

    @Override
    @Transactional
    public void deleteById(Integer id)  throws UsernameNotFoundException {
        Optional<Topic> topic = topicRepository.findById(id);


        if (!topic.isPresent()) {
            return;
        }

        topicRepository.deleteByTopicId(id);

    }


    @Override
    @Transactional
    public Page<Topic> listAllTopic(Pageable pageable) {
        Page<Topic> users = topicRepository.findAll(pageable);
        return users;
    }




    //Có sẵn trong Security
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
