package com.example.TransportManagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "loads")
@Data
@NoArgsConstructor
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "load_id")
    private Integer load_id;

    @Column(name = "load_name")
    private String loadName;

    @Column(name = "destination")
    private String destination;

    @Column(name = "is_active",columnDefinition = "integer default 0")
    private int isActive;

    @Column(name = "is_delete",columnDefinition = "integer default 0")
    private int isDelete;

    @Column(name = "created_at")
    @CreationTimestamp
    private Time createDateTime;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private Time updateDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_vehicle_id")
    private Vehicle vehicle;
}
