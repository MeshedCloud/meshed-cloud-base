package cn.meshed.cloud.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class Operator implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private Set<String> accessSet;
    private Set<String> roleSet;

    public Operator() {
    }

    public Operator(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Operator(String id, String name, Set<String> access, Set<String> roles) {
        this.id = id;
        this.name = name;
        this.accessSet = access;
        this.roleSet = roles;
    }

    public Operator(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getAccess() {
        return accessSet;
    }

    public void setAccess(Set<String> access) {
        this.accessSet = access;
    }

    public Set<String> getRoles() {
        return roleSet;
    }

    public void setRoles(Set<String> role) {
        this.roleSet = role;
    }

    @Override
    public String toString() {
        if (id != null && name != null) {
            return id + "_" + name;
        }
        return id;
    }

    public String toString(String type) {

        if (id != null && name != null) {
            return type + "_" + id + "_" + name;
        }
        return type + "_" + id;
    }
}
