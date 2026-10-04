package com.myLibrary.myLabrary.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(name="uk_user_email", columnNames = "email")
    }
)
@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
public class User {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "first_name", nullable = false, length = 50)
    private String fristName;
    
    @Column (name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column (name = "email", length = 150)
    private String email;

    @Column (nullable = false)
    private String password;

    @Column (nullable = false)
    private String phone;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false, length = 20)
    private UserStatus status;

    @Column (name = "created_at", nullable = false)
    private LocalDateTime createAt;

    @Column (name = "updated_at", nullable = false)
    private LocalDateTime updateAt;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable (
        name = "user_roles",
        joinColumns = @JoinColumn (name = "user_id"),
        inverseJoinColumns = @JoinColumn (name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();


    @PrePersist 
    protected void onCreated(){
        LocalDateTime now = LocalDateTime.now();
        this.createAt = now;
        this.updateAt = now;

        if(status == null){
            this.status = UserStatus.ACTIVE;
        }
    }

    @PreUpdate 
    protected  void onUpdate(){
        this.updateAt = LocalDateTime.now();
    }






}
