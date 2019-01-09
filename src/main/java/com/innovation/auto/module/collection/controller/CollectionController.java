package com.innovation.auto.module.collection.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.innovation.auto.entity.CollectionEntity;
import com.innovation.auto.model.APIResult;
import com.innovation.auto.module.collection.service.CollectionService;
import com.innovation.auto.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/1/6 23:24
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@RestController
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    /**
     * 查询我的收藏
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     * @throws ParseException
     */
    @GetMapping("/collection/queryMyCollection")
    public APIResult info(@RequestParam(value = "userId",required = false) Integer userId,
                          @RequestParam(value = "pageNum", required = false, defaultValue="1") Integer pageNum,
                          @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize) throws ParseException {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("query successfully...");
        apiResult.setStatus(Constants.SUCCESS);
        //根据资讯标题查询
        CollectionEntity collection = new CollectionEntity();
        if (null != userId){
            collection.setUserId(userId);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<CollectionEntity> collections = collectionService.selectMyCollection(collection);
        PageInfo<CollectionEntity> pageInfo = new PageInfo<CollectionEntity>(collections);

        if (null != pageInfo){
            apiResult.setStatus(Constants.SUCCESS);
            apiResult.setRes(pageInfo);
            return apiResult;
        }else {
            apiResult.setMsg("query failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }


    /**
     * 删除收藏
     * @param id
     * @return
     */
    @PostMapping("/collection/deleteCollection")
    public APIResult info(@RequestParam(value = "id",required = false) Integer id) {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("delete successfully...");
        apiResult.setStatus(Constants.SUCCESS);
        //根据资讯标题查询
        int result = collectionService.deleteByPrimaryKey(id);

        if (result == 1) {
            apiResult.setStatus(Constants.SUCCESS);
            return apiResult;
        }else {
            apiResult.setMsg("delete failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }


    @PostMapping("/collection/insertCollection")
    public APIResult insertCollection(@RequestParam(value = "infoId",required = false) Integer infoId,
                                      @RequestParam(value = "userId",required = true) Integer userId) {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("insert successfully...");
        apiResult.setStatus(Constants.SUCCESS);

        if (null == userId) {
            apiResult.setMsg("userId is null");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }

        //根据资讯标题查询
        CollectionEntity collectionEntity = new CollectionEntity();
        collectionEntity.setUserId(userId);
        collectionEntity.setArticleId(infoId);
        collectionEntity.setCreatedTime(new Date());

        int result = collectionService.insertSelective(collectionEntity);

        if (result == 1) {
            apiResult.setStatus(Constants.SUCCESS);
            return apiResult;
        }else {
            apiResult.setMsg("insert failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }

    /**
     * 取消收藏
     * @param infoId
     * @param userId
     * @return
     */
    @PostMapping("/collection/cancelCollection")
    public APIResult cancelCollection(@RequestParam(value = "infoId",required = false) Integer infoId,
                                      @RequestParam(value = "userId",required = false) Integer userId){
        APIResult apiResult = new APIResult();
        apiResult.setMsg("insert successfully...");
        apiResult.setStatus(Constants.SUCCESS);

        Integer id = new Integer(0);
        
        CollectionEntity collectionEntity = new CollectionEntity();
        collectionEntity.setUserId(userId);
        collectionEntity.setArticleId(infoId);

        CollectionEntity collectionCancel = collectionService.selectCancelCollection(collectionEntity);
        if (null != collectionCancel) {
            id = collectionCancel.getId();
        }
        int result = collectionService.deleteByPrimaryKey(id);

        if (result == 1) {
            apiResult.setStatus(Constants.SUCCESS);
            return apiResult;
        }else {
            apiResult.setMsg("insert failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }

    @GetMapping("/collection/queryIsCollection")
    public APIResult queryIsCollection(@RequestParam(value = "infoId",required = false) Integer infoId,
                                      @RequestParam(value = "userId",required = false) Integer userId){
        APIResult apiResult = new APIResult();
        apiResult.setMsg("insert successfully...");
        apiResult.setStatus(Constants.SUCCESS);

        Integer id = new Integer(0);

        if (null == userId) {
            apiResult.setMsg("userId null");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }

        CollectionEntity collectionEntity = new CollectionEntity();
        collectionEntity.setUserId(userId);
        collectionEntity.setArticleId(infoId);

        CollectionEntity collectionCancel = collectionService.selectCancelCollection(collectionEntity);
        if (null != collectionCancel && collectionCancel.getId() != null) {
            apiResult.setStatus(Constants.SUCCESS);
            return apiResult;
        }else {
            apiResult.setMsg("insert failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }
}
