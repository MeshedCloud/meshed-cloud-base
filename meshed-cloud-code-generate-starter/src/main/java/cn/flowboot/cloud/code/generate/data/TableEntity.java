package cn.meshed.cloud.code.generate.data;

import lombok.Data;

/**
 * <h1></h1>
 *
 * @author hougq
 * @version 1.0
 */
@Data
public class TableEntity {

    private String javaType;

    private String javaField;

    private String sqlField;

    private String tip;
}
