package mirana.source.entity;


import mirana.source.enumeration.FacilitatorRecommendationStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class FacilitatorRecommendation {

    /**
     * 服务商推荐Id
     */
    private int facilitatorRecommendationId;

    /**
     * 服务商推荐名称
     */
    private String name;

    /**
     * 图标图片hash
     */
    private String iconHash;

    /**
     * 图标图片url
     */
    private String iconUrl;

    /**
     * 彩页图片hash
     *
     * @type List<String>
     * @remark 备注
     */
    private List<String> imageHash;

    /**
     * 彩页图片url
     */
    private Map<String, String> imageUrl;

    /**
     * 服务商推荐描述
     */
    private String description;

    /**
     * 服务商推荐状态
     */
    private FacilitatorRecommendationStatus status;

    /**
     * 咨询量
     */
    private long consultingCount;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
