package io.huongnq.springboot.Topic;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "topic")

public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "detail")
    private String detail;

    @Column(name = "created")
    private Long created;

    @Column(name = "updatetime")
    private Long updatetime;


    public void setUpdated(long updated) {
        this.updatetime = updated;
    }


}
