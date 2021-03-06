package com.zk.monitor.generator.mapper;

import com.zk.monitor.generator.domain.SysColumnEntity;
import com.zk.monitor.generator.domain.SysTableEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * com.zk.monitor.generator.mapper
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Mapper
public interface SysCodeMapper {

    /**
     * 根据数据库名称查询所有表属性
     * @param tableSchema
     * @return
     */
    @Select("SELECT TABLE_NAME AS tableName,TABLE_COMMENT AS comments,TABLE_SCHEMA AS tableSchema,CREATE_TIME AS createTime FROM information_schema.TABLES WHERE table_schema=#{tableSchema} ORDER BY createTime DESC")
    List<SysTableEntity> findTableList(String tableSchema);

    /**
     * 根据数据库名和表名查询表的列属性
     * @param tableName
     * @return
     */
    @Select("select COLUMN_NAME AS columnName,DATA_TYPE AS dataType,COLUMN_COMMENT AS columnComment,CHARACTER_SET_NAME AS characterSetName,COLUMN_TYPE AS columnType from information_schema.COLUMNS where table_name = #{tableName} and table_schema = #{tableSchema}")
    List<SysColumnEntity> findColumnList(String tableName, String tableSchema);
}
