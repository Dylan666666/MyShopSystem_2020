package com.oym.o2o.service;

import com.oym.o2o.dto.AwardExecution;
import com.oym.o2o.dto.ImageHolder;
import com.oym.o2o.entity.Award;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/8 21:50
 */
public interface AwardService {
    /**
     * 根据传入的条件分页返回奖品列表，并返回该查询条件下的总数
     *
     * @param awardCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    AwardExecution getAwardList(Award awardCondition, int pageIndex, int pageSize);

    /**
     * 根据awardId查询奖品信息
     *
     * @param awardId
     * @return
     */
    Award getAwardById(long awardId);

    /**
     * 添加奖品信息，并添加奖品图片
     *
     * @param award
     * @param thumbnail
     * @return
     */
    AwardExecution addAward(Award award, ImageHolder thumbnail);

    /**
     * 根据传入的奖品实例修改对应的奖品信息， 若传入图片则替换掉原先的图片
     * 
     * @param award
     * @param thumbnail
     * @return
     */
    AwardExecution modifyAward(Award award, ImageHolder thumbnail);
}
