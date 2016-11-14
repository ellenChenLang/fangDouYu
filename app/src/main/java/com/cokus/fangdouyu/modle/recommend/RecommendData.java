package com.cokus.fangdouyu.modle.recommend;

/**
 * Created by coku on 16/11/2.
 */
public class RecommendData {
    private RecomendChannel recomendChannel;
    private HotCategory hotCategory;
    private VerticalRoom verticalRoom;

    public RecomendChannel getRecomendChannel() {
        return recomendChannel;
    }

    public void setRecomendChannel(RecomendChannel recomendChannel) {
        this.recomendChannel = recomendChannel;
    }

    public HotCategory getHotCategory() {
        return hotCategory;
    }

    public void setHotCategory(HotCategory hotCategory) {
        this.hotCategory = hotCategory;
    }

    public VerticalRoom getVerticalRoom() {
        return verticalRoom;
    }

    public void setVerticalRoom(VerticalRoom verticalRoom) {
        this.verticalRoom = verticalRoom;
    }
}
