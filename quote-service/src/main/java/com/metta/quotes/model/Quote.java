package com.metta.quotes.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "quote_tbl")
public class Quote {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quote_id")
    private long quoteId;

    @Getter
    @Setter
    @Column(name = "message", length = 600)
    private String message;

    @Getter
    @Setter
    @Column(name = "language", length = 2)
    private String language;

    @Getter
    @Setter
    @Column(name = "enabled")
    private boolean enabled;

    @Getter
    @Setter
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Getter
    @Setter
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
