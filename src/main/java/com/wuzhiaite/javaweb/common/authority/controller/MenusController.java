package com.wuzhiaite.javaweb.common.authority.controller;


import com.wuzhiaite.javaweb.common.authority.entity.UserPermission;
import com.wuzhiaite.javaweb.common.authority.service.IUserPermissionService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuzhiaite.javaweb.base.entity.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import com.wuzhiaite.javaweb.common.authority.service.IMenusService;
import com.wuzhiaite.javaweb.common.authority.entity.Menus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* <p>
* 
* </p>
* @author lpf
* @since 2020-04-28
*/
@RestController
@RequestMapping("/api/sys/menus")
@Slf4j
public class MenusController {

    /**
    * 业务处理类
    */
    @Autowired
    private IMenusService service;
    @Autowired
    private IUserPermissionService permissionService;

    /**
    * 查找列表数据
    * @param page entity
    * @return
    */
    @PostMapping("/getPageList")
    public ResultObj getPageList(Page page, Menus entity){
        Page<Menus> pageList = null;
        try {
            pageList = service.page(page,new QueryWrapper<Menus>(entity));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultObj.failObj(e.getMessage());
        }
        return ResultObj.successObj(pageList);
    }

    /**
     * 查找列表
     * @param entity
     * @return
     */
    @PostMapping("/getList")
    public ResultObj getList(@RequestBody(required = false) Menus entity){
        List<Menus> list = null;
        try {
            list = service.menuslist(entity);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultObj.failObj(e.getMessage());
        }
        return ResultObj.successObj(list);
    }

    /**
     * 查找列表
     * @param entity
     * @return
     */
    @PostMapping("/getPermissionList")
    public ResultObj getPermissionList(@RequestBody(required = false) UserPermission entity){
        List<UserPermission> list = null ;
        try {
            list = permissionService.menusPermisison(entity);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultObj.failObj(e.getMessage());
        }
        return ResultObj.successObj(list);
    }


        /**
        * 通过ID获取
        * @param id
        * @return
        */
        @PostMapping("/getPageById/{id}")
        public ResultObj getPageById(@PathVariable String id){
            Menus result = null;
            try {
                result = service.getById(id);
            } catch (Exception e) {
                log.error(e.getMessage());
                return ResultObj.failObj(e.getMessage());
            }
            return ResultObj.successObj(result);
        }

        /**
        * 保存或修改数据
        * @param entity
        * @return
        */
        @PostMapping("/addOrUpdatePage")
        public ResultObj addOrUpdatePage(@RequestBody Menus entity){
            boolean flag = false;
            try {
                flag = service.saveOrUpdate(entity);
            } catch (Exception e) {
                log.error(e.getMessage());
                return ResultObj.failObj(e.getMessage());
            }
            return ResultObj.successObj(flag);
        }
        /**
         * 批量保存或修改数据
         * @param list
         * @return
         */
        @PostMapping("/batchAddOrUpdate")
        public ResultObj batchAddOrUpdate(@RequestBody List<Menus> list){
            boolean flag = false;
            try {
                flag = service.saveOrUpdateBatch(list);
            } catch (Exception e) {
                log.error(e.getMessage());
                return ResultObj.failObj(e.getMessage());
            }
            return ResultObj.successObj(flag);
        }

        /**
        * 通过ID移除
        * @param id
        * @return
        */
        @PostMapping("/removeById/{id}")
        public ResultObj removeById(@PathVariable String id){
            boolean flag = false ;
            try {
                flag = service.removeById(id);
            } catch (Exception e) {
                log.error(e.getMessage());
                return ResultObj.failObj(e.getMessage());
            }
            return ResultObj.successObj(flag);
        }

 }
