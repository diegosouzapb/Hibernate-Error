package com.diegosouza.hibernateerror.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "child")
public class ChildEnt implements Serializable {

    @Id
    @GenericGenerator(name = "child_id_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		    parameters = {@Parameter(name = "sequence_name", value = "child_id_seq"),
		                  @Parameter(name = "initial_value", value = "1000000"),
		                  @Parameter(name = "increment_size", value = "1")}
    )
    @GeneratedValue(generator = "child_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(nullable = false, name="parent_id", foreignKey = @ForeignKey(name = "fk_parent_on_child"))
    private ParentEnt parent;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GrandchildEnt> grandchildren = new ArrayList<>();

    public ChildEnt() {
    }

    public ChildEnt(Integer id, ParentEnt parent) {
        this.id = id;
        this.parent = parent;
    }

    public Boolean isIdNull() {
	return (id == null);
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void addGrandchild(GrandchildEnt grandchild) {
	this.grandchildren.add(grandchild);
    }
}
