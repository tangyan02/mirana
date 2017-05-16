package mirana.source.interfaces;


import mirana.source.entity.FacilitatorRecommendationConsulting;
import mirana.source.entity.FacilitatorRecommendationConsultingCreateProperty;
import mirana.source.entity.FacilitatorRecommendationQueryResult;

import java.util.List;

public interface FacilitatorRecommendationApiService {

    /**
     * 查询服务商推荐
     *
     * @param limit  数量
     * @param offset 偏移量
     * @return
     */
    FacilitatorRecommendationQueryResult queryFacilitatorRecommendation(int limit, int offset);


    /**
     * 保存服务商推荐咨询
     *
     * @param facilitatorRecommendationConsultingCreateProperty 服务商推荐咨询创建属性
     * @return
     * @paramType facilitatorRecommendationConsultingCreateProperty:List<FacilitatorRecommendationConsulting>
     * @returnType List<FacilitatorRecommendationConsulting>
     */
    List<FacilitatorRecommendationConsulting> saveFacilitatorRecommendationConsulting(List<FacilitatorRecommendationConsultingCreateProperty> facilitatorRecommendationConsultingCreateProperty);

}
