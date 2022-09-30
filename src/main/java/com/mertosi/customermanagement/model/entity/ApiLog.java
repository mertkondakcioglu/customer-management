package com.mertosi.customermanagement.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tbl_api_log")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiLog implements Serializable {

    @Serial
    private static final long serialVersionUID = 8719972017289235861L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "user_agent", nullable = false)
    private String userAgent;

    @Column(name = "uri", nullable = false)
    private String uri;

    @Column(name = "ip", nullable = false)
    private String ip;

    @Column(name = "request", columnDefinition = "longtext")
    private String request;

    @Column(name = "response", columnDefinition = "longtext", nullable = false)
    private String response;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiLog that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
