package com.aleksey.crud_app.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "label", schema = "test")
public class Label {

    @Id
    @Column (name = "id")
//    @ManyToMany(mappedBy = "labels")
//    @JoinTable(name = "postlabel",
//            joinColumns = @JoinColumn(name = "label_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id")
//    )
    private long id;

    @Column(name = "name")
    private String name;
}
