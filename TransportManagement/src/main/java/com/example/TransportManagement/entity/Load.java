package com.example.TransportManagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity

@Getter
@Setter
@Table(name = "loads")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "load_id")
    private int load_id;

    @Column(name = "load_name")
    private String loadName;

    @Column(name = "destination")
    private String destination;

    @Column(name = "is_active",columnDefinition = "integer default 0")
    private int isActive;

    @Column(name = "is_delete",columnDefinition = "integer default 0")
    private int isDelete;

    @Column(name = "created_at")
    private Timestamp createDateTime;

    @Column(name = "modified_at")
    private Timestamp updateDateTime;

    @ManyToOne
    @JoinColumn(name = "fk_vehicle_id")
    private Vehicle vehicle;
}
