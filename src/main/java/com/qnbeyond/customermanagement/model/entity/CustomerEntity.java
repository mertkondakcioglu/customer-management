package com.qnbeyond.customermanagement.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_customer")
@Builder
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = -3252345455177095611L;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
}
