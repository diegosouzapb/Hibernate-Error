# Hibernate Error

If we try to insert a child with a null primary key, which makes up the compound key of a grandchild, Hibernate will make a mess trying to insert the grandchild before the child, throwing NullPointerException by trying to access a null identifier method.
