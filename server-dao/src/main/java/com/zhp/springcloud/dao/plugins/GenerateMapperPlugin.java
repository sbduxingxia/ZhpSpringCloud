package com.zhp.springcloud.dao.plugins;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 插件；完成mapper的自动生成，并将生成的mapper接口文件修改为 *dao
 * @author zhp.dts
 * @date 2018/8/24.
 */
public class GenerateMapperPlugin extends PluginAdapter{
    private static final String DEFAULT_DAO_SUPER_CLASS = "com.zhp.springcloud.dao.SimpleDao";
    private static final String DEAAULT_SEARCH_STRING = "Mapper$";
    private static final String DEAAULT_REPLACE_STRING = "Dao";
    private String  searchString;
    private String  replaceString;
    private Pattern pattern;
    private String daoTargetDir;
    private String daoTargetPackage;

    private String daoSuperClass;

    // 扩展
    private ShellCallback shellCallback = null;

    private HashMap<String,String> shortName2Class = new HashMap<>();
    public GenerateMapperPlugin() {
        shellCallback = new DefaultShellCallback(false);

    }
    @Override
    public boolean validate(List<String> list) {
        daoTargetDir = properties.getProperty("targetProject");
        if(!StringUtility.stringHasValue(daoTargetDir)){
            daoTargetDir =  System.getProperty("user.dir")+"/src/main/java";
        }

        daoTargetPackage = properties.getProperty("targetPackage");
        boolean valid2 = StringUtility.stringHasValue(daoTargetPackage);
        if(!valid2){
            System.out.println("dao package is null");
            return false;
        }
        daoSuperClass = properties.getProperty("daoSuperClass");
        if (!StringUtility.stringHasValue(daoSuperClass)) {
            daoSuperClass = DEFAULT_DAO_SUPER_CLASS;
        }
        searchString = properties.getProperty("searchString");
        replaceString = properties.getProperty("replaceString");
        if(StringUtility.stringHasValue(searchString)){
            pattern = Pattern.compile(searchString);
        }else{
            pattern = Pattern.compile(DEAAULT_SEARCH_STRING);
        }
        if(!StringUtility.stringHasValue(replaceString)){
            replaceString = DEAAULT_REPLACE_STRING;
        }
        return valid2;
    }

    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        //将*Mapper --> *Dao
        String oldType = introspectedTable.getMyBatis3JavaMapperType();
        Matcher matcher = pattern.matcher(oldType);
        oldType = matcher.replaceAll(replaceString);
        introspectedTable.setMyBatis3JavaMapperType(oldType);
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles() {
        return super.contextGenerateAdditionalJavaFiles();
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        JavaFormatter javaFormatter = context.getJavaFormatter();
        List<GeneratedJavaFile> mapperJavaFiles = new ArrayList<GeneratedJavaFile>();
        for (GeneratedJavaFile javaFile : introspectedTable.getGeneratedJavaFiles()) {
            CompilationUnit unit = javaFile.getCompilationUnit();
            FullyQualifiedJavaType baseModelJavaType = unit.getType();

            String shortName = baseModelJavaType.getShortName();
            shortName2Class.putIfAbsent(shortName,baseModelJavaType.getFullyQualifiedName());
            GeneratedJavaFile mapperJavafile = null;

            if (shortName.endsWith("Dao")) { // 扩展Mapper
                Interface daoInterface = new Interface(daoTargetPackage + "." + shortName);

                daoInterface.addAnnotation("@Mapper");
                daoInterface.setVisibility(JavaVisibility.PUBLIC);
                daoInterface.addJavaDocLine("/**");
                daoInterface.addJavaDocLine(" *create by zhp used generate");
                daoInterface.addJavaDocLine(" */");

                FullyQualifiedJavaType daoSuperType = new FullyQualifiedJavaType(daoSuperClass);
                // 添加泛型支持
                FullyQualifiedJavaType daoEntityType = new FullyQualifiedJavaType(shortName2Class.get(shortName.substring(0,shortName.length()-3)));
                daoSuperType.addTypeArgument(daoEntityType);
                daoInterface.addSuperInterface(daoSuperType);
                daoInterface.addImportedType(daoEntityType);
                daoInterface.addImportedType( new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));
                mapperJavafile = new GeneratedJavaFile(daoInterface, daoTargetDir, javaFormatter);
                mapperJavaFiles.add(mapperJavafile);

            }else{

            }
        }
        return mapperJavaFiles;
    }
}
