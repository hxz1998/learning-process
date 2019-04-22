"""
  Created by Xiaozhong on 2018/11/4.
  Copyright (c) 2018/11/4 Xiaozhong. All rights reserved.
"""

from pathlib import Path


# 扫描指定目录下的*.java文件，并在当前目录下生成*_temp.java"""
def generator(dir_input):
    if dir_input.match("*/service"):
        return
    current_dir = dir_input
    count = 0
    for pro_dir in current_dir.iterdir():
        if pro_dir.match("template.java"):
            return
        if pro_dir.is_file() and pro_dir.match("*.java") and not pro_dir.match("*_temp.java"):
            s = str(dir_input) + "\\" + str(pro_dir.stem) + "_temp.java"
            wr_file = open(s, mode="w", encoding="utf-8")
            if wr_file.writable():
                wr_file.write("/**\n * 自动生成的代码\n */")
            count = count + 1
        elif pro_dir.is_dir():
            generator(pro_dir)
    if dir_input.is_dir():
        if count == 0:
            print(str(dir_input) + "没有生成任何代码")
        else:
            print(str(dir_input) + "生成了" + str(count) + "个代码文件")


# 当前目录下操作
c_dir = Path()

# Dao层模板字符串
str_template_out = """
/**
 * 该代码为自动生成
 *
 */
package {package_name}.{level}.impl;\n

import {package_name}.dao.{dao_name};\n
import {package_name}.model.{model_name};\n

import org.springframework.orm.hibernate5.HibernateTemplate;\n
import org.springframework.stereotype.Component;\n
import javax.annotation.Resource;\n
import java.util.List;\n

@Component("{component_name}")\n
public class {dao_name}Impl implements {dao_name} {\n

    private HibernateTemplate hibernateTemplate;\n

    public void save({model_name} {lower_case_model_name}) {\n
        hibernateTemplate.save({lower_case_model_name});\n
    }\n

    public void delete({model_name} {lower_case_model_name}) {\n

    }\n

    public {model_name} get({model_name} {lower_case_model_name}) {\n
        return null;\n
    }\n

    public List<{model_name}> get{model_name}s() {\n
        return null;\n
    }\n

    public HibernateTemplate getHibernateTemplate() {\n
        return hibernateTemplate;\n
    }\n

    @Resource\n
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {\n
        this.hibernateTemplate = hibernateTemplate;\n
    }\n
}\n
"""

# Dao层模板字符串
str_template_dao = """/**\n
 * 该代码为自动生成\n
 *\n
 */\n
package {package_name}.{level};\n

import {package_name}.model.{model_name};\n

import java.util.List;\n

public interface {model_name}Dao {\n

    /**\n
     * 持久化{model_name}对象\n
     * @param {lower_case_model_name} 要持续化的{lower_case_model_name}对象\n
     */\n
    void save({model_name} {lower_case_model_name});\n

    /**\n
     * 从数据库中删除指定的{model_name}对象\n
     * @param {lower_case_model_name} 指定{model_name}对象的模仿对象\n
     */\n
    void delete({model_name} {lower_case_model_name});\n

    /**\n
     * 获取符合指定查询条件的{model_name}对象\n
     * @return 从数据库中获取到的{model_name}对象\n
     */\n
    {model_name} get({model_name} {lower_case_model_name});\n

    /**\n
     * 获取指定查询范围内的{model_name}对象\n
     * @return 由指定范围所查询到的{model_name}对象\n
     */\n
    List<{model_name}> get{model_name}s();\n
}\n
"""
# Service层模板字符串
str_template_service = """package {package_name}.service;\n

import {package_name}.model.{model_name};\n

public interface {model_name}Service {\n

    /**\n
     * 持久化{model_name}对象\n
     * @param {lower_case_model_name} 要持久化的{model_name}对象\n
     */\n
    void save({model_name} {lower_case_model_name});\n

    /**\n
     * 从数据库中删除掉{model_name}对象\n
     * @param {lower_case_model_name} 要删除的{model_name}对象副本\n
     */\n
    void delete({model_name} user);\n

    /**\n
     * 从数据库中获取类似的{model_name}对象\n
     * @param {lower_case_model_name} 要获取的{model_name}对象的副本\n
     * @return 从数据库中获取到的{model_name}对象\n
     */\n
    {model_name} get({model_name} {lower_case_model_name});\n

    /**\n
     * 根据提供的信息更新指定{model_name}\n
     * @param user 要查询的{model_name}\n
     * @return 返回跟新前的对象\n
     */\n
    {model_name} update({model_name} {lower_case_model_name});\n
}\n

"""
# 读取模板文件方式
# template_file_out = open("template.java")

# 填充字段字典
fill_obj_out = {
    'package_name': 'com.tccloud.webserver',
    'model_name': 'User',
    'dao_name': 'UserDao',
    'component_name': 'userDao',
    'lower_case_model_name': 'user',
    'level': 'dao'
}


# 使用字符串模式生成代码
def generate_by_string_template(str_template=str_template_dao, fill_obj=None, generate_file_object="temp"):
    # 读字符串方式初始化模板代码
    if fill_obj is None:
        fill_obj = fill_obj_out
    read_contents = str_template.split("\n")
    result_content = ""
    for read_content in read_contents:
        if read_content == "":
            result_content += "\n"
        if read_content.endswith("{"):
            result_content += read_content[0:-2].format(**fill_obj)
            result_content += "{"
            continue
        if read_content.endswith("}"):
            result_content += read_content
            continue
        else:
            result_content += read_content.format(**fill_obj)

    wr_code = open(generate_file_object, mode="w", encoding="utf-8")
    wr_code.write(result_content)


# 使用模板文件生成代码
def generate_by_template_file(file_name, fill_obj, generate_file_object):
    # 读取模板文件
    template_file = open(file_name)
    result_content = ""
    while True:
        read_content = template_file.readline()
        if not read_content:
            break
        if read_content.endswith("{\n"):
            result_content += read_content[0:-2].format(**fill_obj)
            result_content += "{\n"
            continue
        if read_content.endswith("}\n"):
            result_content += read_content
            continue
        else:
            result_content += read_content.format(**fill_obj)

    wr_code = open(generate_file_object, mode="w", encoding="utf-8")
    wr_code.write(result_content)


# generate_by_string_template(str_template_service, fill_obj_out, "template_generate.java")
# generate_by_template_file("template.java", fill_obj_out, "template_2.java")
