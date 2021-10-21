package com.example.quesapptwo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)//PĞostları geçtigimde user gelmesin demek lazy
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//bir user silindiginde bütün postlar silinicek
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    User user;


    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;

}
