package com.example.quesapptwo.entities;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Table(name = "likes")
@Entity
@Data
public class Like {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)//PĞostları geçtigimde user gelmesin demek lazy
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//bir user silindiginde bütün postlar silinicek
    @JsonIgnore
    Post post;

    @ManyToOne(fetch = FetchType.LAZY)//PĞostları geçtigimde user gelmesin demek lazy
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//bir user silindiginde bütün postlar silinicek
    @JsonIgnore
    User user;


}