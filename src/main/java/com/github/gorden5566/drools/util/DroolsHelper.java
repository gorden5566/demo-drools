package com.github.gorden5566.drools.util;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

public class DroolsHelper {
    /**
     * 读取drools规则文件, 生成ksession
     *
     * @param ruleFileName drools规则文件名
     * @return
     */
    public static StatelessKnowledgeSession buildKsession(String ruleFileName) {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        Resource resource = ResourceFactory.newClassPathResource(ruleFileName);
        kbuilder.add(resource, ResourceType.DRL);
        if (kbuilder.hasErrors()) {
            System.out.println("rules has errors");

            KnowledgeBuilderErrors errors = kbuilder.getErrors();
            throw new RuntimeException(errors.toString());
        }

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();

        return ksession;
    }
}
