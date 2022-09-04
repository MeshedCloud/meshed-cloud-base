package cn.meshed.cloud.code.generate.factory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

/**
 * <h1></h1>
 *
 * @author hougq
 * @version 1.0
 */
@RequiredArgsConstructor
public class TemplateFactory {

    private final Configuration configuration;


    public Template getTemplate(String template) throws IOException {

        return configuration.getTemplate(template);
    }
}
