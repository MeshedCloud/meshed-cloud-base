package cn.meshed.cloud.dto;

import java.io.Serializable;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class Operator implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public Operator() {
    }

    public Operator(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id+"_"+name;
    }

    public String toString(String type) {
        return type+"_"+id+"_"+name;
    }
}
