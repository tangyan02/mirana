package mirana.source.interfaces;


import mirana.source.entity.*;
import mirana.source.enumeration.FacilitatorRecommendationStatus;

public interface OperatingFacilitatorRecommendationService {

    /**
     * 保存服务商推荐
     *
     * @param facilitatorRecommendationCreateProperty 服务商推荐创建属性
     * @return
     */
    FacilitatorRecommendation saveFacilitatorRecommendation(FacilitatorRecommendationCreateProperty facilitatorRecommendationCreateProperty);

    /**
     * 更新服务商推荐
     *
     * @param facilitatorRecommendationId             服务商推荐Id
     * @param facilitatorRecommendationUpdateProperty 服务商推荐更新属性
     * @return
     */
    FacilitatorRecommendation updateFacilitatorRecommendation(int facilitatorRecommendationId, FacilitatorRecommendationUpdateProperty facilitatorRecommendationUpdateProperty);

    /**
     * 获取服务商推荐
     *
     * @param facilitatorRecommendationId
     * @return
     */
    FacilitatorRecommendation getFacilitatorRecommendation(int facilitatorRecommendationId);

    /**
     * 查询服务商推荐
     *
     * @param limit  数量
     * @param offset 偏移量
     * @return
     */
    FacilitatorRecommendationQueryResult queryFacilitatorRecommendation(int limit, int offset);

    /**
     * 更新状态
     *
     * @param facilitatorRecommendationId     服务商推荐Id
     * @param facilitatorRecommendationStatus 需要改变的状态
     * @return
     */
    FacilitatorRecommendation updateStatus(int facilitatorRecommendationId, FacilitatorRecommendationStatus facilitatorRecommendationStatus);

    /**
     * 查询服务商推荐咨询
     *
     * @param facilitatorRecommendationConsultingQueryCondition 服务商推荐咨询查询条件
     * @return
     */
    FacilitatorRecommendationConsultingQueryResult queryFacilitatorRecommendationConsulting(FacilitatorRecommendationConsultingQueryCondition facilitatorRecommendationConsultingQueryCondition);

    /**
     * 上传图片
     *
     * @param file 图片文件流
     * @return
     */
    String uploadImage(String file);

}
