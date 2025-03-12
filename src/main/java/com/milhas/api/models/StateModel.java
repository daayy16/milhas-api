package com.milhas.api.models;

import com.milhas.api.dtos.StateRecordDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity()
@Table(name = "TB_State")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StateModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String initials;

    public StateModel(StateRecordDTO data) {
        this.name = data.name();
        this.initials = data.initials();
    }
}
