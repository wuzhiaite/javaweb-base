package com.wuzhiaite.javaweb.common.codegenerator.service;

import com.github.pagehelper.PageInfo;
import com.wuzhiaite.javaweb.base.multidatabase.DataSourceConfigure;
import com.wuzhiaite.javaweb.base.multidatabase.DynamciDb;
import com.wuzhiaite.javaweb.base.multidatabase.DynamicDataSource;
import com.wuzhiaite.javaweb.base.multidatabase.DynamicDataSourceContextHolder;
import com.wuzhiaite.javaweb.base.utils.CodeGeneratorUtil;
import com.wuzhiaite.javaweb.base.utils.MapUtil;
import com.wuzhiaite.javaweb.common.codegenerator.mapper.CodeGeneratorMapper;
import com.wuzhiaite.javaweb.common.common.ComCrudServiceImpl;
import com.zaxxer.hikari.pool.HikariProxyConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author lpf
 * @description 代码生成器处理类
 */
@Service
public class CodeGeneratorService extends ComCrudServiceImpl<CodeGeneratorMapper, Map<String,Object>> {


    /**
     * 表中所有信息
     * @param param
     * @return
     */
    public List<Map<String, Object>> getColumnInfo(Map<String, Object> param) throws SQLException {
        Map<String, Object> database = mapper.findOneBySQL("select database()");
        param.put("database",MapUtil.getString(database,"database()"));
        return mapper.getColumnInfo( param );
    }

    /**
     * 所有table
     * @return
     * @param params
     */
    @DynamciDb(name = DataSourceConfigure.DEFAULT_DATASOURCE)
    public PageInfo<Map<String,Object>> getTableList(Map<String, Object> params) throws SQLException {
        Map<String, Object> database = mapper.findOneBySQL("select database()");
        params.put("database",MapUtil.getString(database,"database()"));
        return new PageInfo<Map<String,Object>>(mapper.getTableList(params));
    }

    /**
     * 生成代码
     * @param params
     * @throws RuntimeException
     */
    public void generatorCode(Map<String, Object> params) throws RuntimeException {
        CodeGeneratorUtil.generatorCode(params);
    }




}