package com.diegosouza.hibernateerror;

import com.diegosouza.hibernateerror.entity.GrandchildEnt;
import com.diegosouza.hibernateerror.entity.ParentEnt;
import com.diegosouza.hibernateerror.entity.ChildEnt;
import com.diegosouza.hibernateerror.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TestsApplication {

    @Autowired
    private ParentRepository parentRepository;

    public static void main(String[] args) {
        SpringApplication.run(TestsApplication.class, args);
    }

    @PostConstruct
    public void init() {
        ParentEnt parent = new ParentEnt(123);

        ChildEnt childOne = new ChildEnt(1, parent);
        childOne.addGrandchild(new GrandchildEnt("One", childOne));

        /* It is important to set null to the childTwo's id */
        ChildEnt childTwo = new ChildEnt(null, parent);
        childTwo.addGrandchild(new GrandchildEnt("Two", childTwo));

        parent.addChild(childOne);
        parent.addChild(childTwo);

        //parent.onlyChildrenWithouId().forEach(child -> child.setId(Integer.MIN_VALUE));

        parentRepository.save(parent);
    }
}
