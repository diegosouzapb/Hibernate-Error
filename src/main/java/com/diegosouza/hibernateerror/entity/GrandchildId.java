package com.diegosouza.hibernateerror.entity;

import java.io.Serializable;
import java.util.Objects;

public class GrandchildId implements Serializable {

    private static final long serialVersionUID = -4043697629941064509L;

    private String anyId;
    private ChildEnt child;

    public GrandchildId() {}

    public GrandchildId(String anyId, ChildEnt child) {
	this.anyId = anyId;
	this.child = child;
    }

    @Override public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	GrandchildId grandchildId = (GrandchildId)o;
	return anyId.equals(grandchildId.anyId) && child.equals(grandchildId.child);
    }

    @Override public int hashCode() {
	return Objects.hash(anyId);
    }
}
