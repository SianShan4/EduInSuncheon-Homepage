package com.eduinsuncheon.blog.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // User가 mysql에 테이블로 추가가됨

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100) //암호화 할 것이기 때문에 널널하게 잡아줌.
    private String password;

    private String email;

    @Column(nullable = false)
    private String phone;

    @ColumnDefault("'USER'")
    private Role role;

    @CreationTimestamp // 시간이 자동으로 주입됨.
    private Timestamp createDate;
}
