package com.diegosouza.hibernateerror.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "grandchild")
@IdClass(GrandchildId.class)
public class GrandchildEnt implements Serializable {

    private static final long serialVersionUID = -1314165335944279231L;

    @Id
    @Column(name = "any_id")
    private String anyId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id", foreignKey = @ForeignKey(name = "fk_child_on_grandchild"))
    private ChildEnt child;

    public GrandchildEnt() {
    }

    public GrandchildEnt(String anyId, ChildEnt child) {
        this.anyId = anyId;
        this.child = child;
    }
}
