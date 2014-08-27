package com.foodoon.gooda.gen;

import com.foodoon.gooda.helper.GenHelper;

import java.io.File;

public class DemoGen extends BaseDaoGen {

    private String jdbcPath = "e:\\repo\\mysql\\mysql-connector-java\\5.1.9\\mysql-connector-java-5.1.9.jar";

    private String jdbUrl = "jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=utf8";

    private String jdbcUsername = "root";

    private String jdbcPassword = "";

    public void genDAO(String tableName, String appName, String parentPackageName) {
        if (tableName == null) {
            throw new RuntimeException("table name can not null");
        }
        String domainName = GenHelper.getDomainName(tableName, appName);
        setDomainObjectName(domainName);
        setTableName(tableName);
        setJavaDaoTargetPackage(parentPackageName + "." + appName + ".dao");
        String daoFile =
                GenConstants.appDir + File.separator + GenContext.getDaoDir() + File.separator + GenConstants.javaDir;
        setJavaDaoTargetProject(daoFile);

        setJavaModelTargetPackage(parentPackageName + "." + appName + ".dao.domain");
        setJavaModelTargetProject(daoFile);

        setSqlTargetPackage("mybatis");
        String resourceFile = GenConstants.appDir + File.separator + GenContext.getDaoDir() + File.separator
                + GenConstants.resourceDir;
        setSqlTargetProject(resourceFile);

        try {
            gen();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void genDAO(String tableName, String appName, String parentPackageName, String targetRuntime) {
        if (tableName == null) {
            throw new RuntimeException("table name can not null");
        }
        setMybatisVersion(targetRuntime);
        String domainName = GenHelper.getDomainName(tableName, appName);
        setDomainObjectName(domainName);
        setTableName(tableName);
        setJavaDaoTargetPackage(parentPackageName + "." + appName + ".dao");
        String daoFile =
                GenConstants.appDir + File.separator + GenContext.getDaoDir() + File.separator + GenConstants.javaDir;
        setJavaDaoTargetProject(daoFile);

        setJavaModelTargetPackage(parentPackageName + "." + appName + ".dao.domain");
        setJavaModelTargetProject(daoFile);

        setSqlTargetPackage("mybatis");
        String resourceFile = GenConstants.appDir + File.separator + GenContext.getDaoDir() + File.separator
                + GenConstants.resourceDir;
        setSqlTargetProject(resourceFile);

        try {
            gen();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setMybatisVersion(String targetRuntime1) {
        setTargetRuntime(targetRuntime1);
    }

    public void setJdbcPath(String jdbcPath) {
        setClasspathLocation(jdbcPath);
    }

    public void setDriverClass(String clazz) {
        super.setDriverClass(clazz);
    }

    public void setJdbUrl(String jdbUrl) {
        super.setConnectionURL(jdbUrl);
    }

    public void setJdbcUsername(String jdbcUsername) {
        super.setUserId(jdbcUsername);
    }

    public void setJdbcPassword(String jdbcPassword) {
        super.setPassword(jdbcPassword);
    }

    public static void genAll(String tableName, String appName, String parentPackageName) {
        String domainName = GenHelper.getDomainName(tableName, appName);
        try {
            System.out.println("start gen dao xml===================");
            GenContext genContext = new GenContext(parentPackageName + "." + appName + ".dao.domain." + domainName,
                    appName, parentPackageName);
            GenDAO genDAO = new GenDAO(genContext);
            genDAO.gen(parentPackageName);
            System.out.println("start gen dao xml finish===================");

            System.out.println("start gen biz  start===================");
            GenBiz genBiz = new GenBiz(genContext);
            genBiz.gen(parentPackageName);
            System.out.println("start gen biz  finish===================");

            System.out.println("start gen action  start===================");
            GenAction genAction = new GenAction(genContext);
            genAction.gen();
            System.out.println("start gen action  finish===================");

            System.out.println("start gen vm  start===================");
            GenVm genVM = new GenVm(genContext);
            genVM.gen();
            System.out.println("start gen vm  finish===================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void genDaoXML(String tableName, String appName, String parentPackageName) {
        String domainName = GenHelper.getDomainName(tableName, appName);
        try {

            GenContext genContext = new GenContext(parentPackageName + "." + appName + ".dao.domain." + domainName,
                    appName, parentPackageName);
            GenDAO genDAO = new GenDAO(genContext);
            genDAO.gen(parentPackageName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void genBiz(String tableName, String appName, String parentPackageName) {
        String domainName = GenHelper.getDomainName(tableName, appName);
        try {
            GenContext genContext = new GenContext(parentPackageName + "." + appName + ".dao.domain." + domainName,
                    appName, parentPackageName);

            GenBiz genBiz = new GenBiz(genContext);
            genBiz.gen(parentPackageName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void genAction(String tableName, String appName, String parentPackageName) {
        String domainName = GenHelper.getDomainName(tableName, appName);
        try {
            GenContext genContext = new GenContext(parentPackageName + "." + appName + ".dao.domain." + domainName,
                    appName, parentPackageName);

            GenAction genAction = new GenAction(genContext);
            genAction.gen();

            GenVm genVM = new GenVm(genContext);
            genVM.gen();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
