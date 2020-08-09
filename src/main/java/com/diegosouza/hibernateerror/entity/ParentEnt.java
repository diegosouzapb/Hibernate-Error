package com.diegosouza.hibernateerror.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Entity
@Table(name = "parent")
public class ParentEnt {

    @Id
    @GenericGenerator(name = "parent_id_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		    parameters = { @Parameter(name = "sequence_name", value = "parent_id_seq"),
		                   @Parameter(name = "initial_value", value = "1000000"),
		                   @Parameter(name = "increment_size", value = "1")}
    )
    @GeneratedValue(generator = "parent_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<ChildEnt> children = new ArrayList<>();

    public ParentEnt() {}

    public ParentEnt(Integer id) {
        this.id = id;
    }

    public void addChild(ChildEnt child) {
	this.children.add(child);
    }

    public List<ChildEnt> onlyChildrenWithouId() {
        Predicate<ChildEnt> onlyChildWithoutId = child -> child.isIdNull();

        return children.stream()
		        .filter(onlyChildWithoutId)
		        .collect(Collectors.toList());
    }
}
