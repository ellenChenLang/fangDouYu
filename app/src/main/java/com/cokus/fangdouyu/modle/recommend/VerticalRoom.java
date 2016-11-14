package com.cokus.fangdouyu.modle.recommend;

import java.io.Serializable;
import java.util.List;

/**
 * Created by coku on 16/11/2.
 */
public class VerticalRoom implements Serializable {

    /**
     * error : 0
     * data : [{"room_id":"666744","room_src":"https://rpic.douyucdn.cn/appCovers/666744/20160930/172fdf9eff9391d923ff2f8596a0a677_small.jpg","vertical_src":"https://rpic.douyucdn.cn/appCovers/666744/20160930/172fdf9eff9391d923ff2f8596a0a677_big.jpg","isVertical":1,"cate_id":"201","room_name":"哈喽，早上好","show_status":"1","subject":"","show_time":"1478052997","owner_uid":"51982463","specific_catalog":"","specific_status":"0","vod_quality":"0","nickname":"洋妞Via","online":12455,"game_name":"颜值","child_id":"0","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/face/201607/11/aefa797e319293827b7b1b134d563283_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avatar/face/201607/11/aefa797e319293827b7b1b134d563283_small.jpg","jumpUrl":"","ranktype":0,"show_type":1,"anchor_city":"福州市"},{"room_id":"537428","room_src":"https://rpic.douyucdn.cn/appCovers/2016/11/02/537428_201611021115_small.jpg","vertical_src":"https://rpic.douyucdn.cn/appCovers/2016/11/02/537428_201611021115_big.jpg","isVertical":1,"cate_id":"201","room_name":"一起摇摆吧皮卡丘","show_status":"1","subject":"","show_time":"1478056618","owner_uid":"36533415","specific_catalog":"","specific_status":"0","vod_quality":"0","nickname":"尛小钰","online":3880,"game_name":"颜值","child_id":"0","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/face/201609/05/45a0b5790a05647cdde70357fb29d42b_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avatar/face/201609/05/45a0b5790a05647cdde70357fb29d42b_small.jpg","jumpUrl":"","ranktype":0,"show_type":1,"anchor_city":"鱼塘"},{"room_id":"1256979","room_src":"https://rpic.douyucdn.cn/appCovers/2016/10/27/1256979_201610271330_small.jpg","vertical_src":"https://rpic.douyucdn.cn/appCovers/2016/10/27/1256979_201610271330_big.jpg","isVertical":1,"cate_id":"201","room_name":"你的音乐老师","show_status":"1","subject":"","show_time":"1478051869","owner_uid":"74314339","specific_catalog":"","specific_status":"0","vod_quality":"0","nickname":"viki345","online":1463,"game_name":"颜值","child_id":"0","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201610/26/19/37028bcb8185fdcfecc966900e5ca2ea_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201610/26/19/37028bcb8185fdcfecc966900e5ca2ea_small.jpg","jumpUrl":"","ranktype":0,"show_type":1,"anchor_city":"鱼塘"},{"room_id":"759566","room_src":"https://rpic.douyucdn.cn/appCovers/2016/11/01/759566_201611011316_small.jpg","vertical_src":"https://rpic.douyucdn.cn/appCovers/2016/11/01/759566_201611011316_big.jpg","isVertical":1,"cate_id":"201","room_name":"天气变凉，陪你的是爱人还是热水袋？","show_status":"1","subject":"","show_time":"1478051711","owner_uid":"56571409","specific_catalog":"","specific_status":"0","vod_quality":"0","nickname":"倩二爷","online":2563,"game_name":"颜值","child_id":"0","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201610/09/15/e9d336efafa6307c87ad46ee97625ec4_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201610/09/15/e9d336efafa6307c87ad46ee97625ec4_small.jpg","jumpUrl":"","ranktype":0,"show_type":1,"anchor_city":"福州市"}]
     */

    private int error;
    /**
     * room_id : 666744
     * room_src : https://rpic.douyucdn.cn/appCovers/666744/20160930/172fdf9eff9391d923ff2f8596a0a677_small.jpg
     * vertical_src : https://rpic.douyucdn.cn/appCovers/666744/20160930/172fdf9eff9391d923ff2f8596a0a677_big.jpg
     * isVertical : 1
     * cate_id : 201
     * room_name : 哈喽，早上好
     * show_status : 1
     * subject :
     * show_time : 1478052997
     * owner_uid : 51982463
     * specific_catalog :
     * specific_status : 0
     * vod_quality : 0
     * nickname : 洋妞Via
     * online : 12455
     * game_name : 颜值
     * child_id : 0
     * avatar_mid : https://apic.douyucdn.cn/upload/avatar/face/201607/11/aefa797e319293827b7b1b134d563283_middle.jpg
     * avatar_small : https://apic.douyucdn.cn/upload/avatar/face/201607/11/aefa797e319293827b7b1b134d563283_small.jpg
     * jumpUrl :
     * ranktype : 0
     * show_type : 1
     * anchor_city : 福州市
     */

    private List<DataBean> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String room_id;
        private String room_src;
        private String vertical_src;
        private int isVertical;
        private String cate_id;
        private String room_name;
        private String show_status;
        private String subject;
        private String show_time;
        private String owner_uid;
        private String specific_catalog;
        private String specific_status;
        private String vod_quality;
        private String nickname;
        private int online;
        private String game_name;
        private String child_id;
        private String avatar_mid;
        private String avatar_small;
        private String jumpUrl;
        private int ranktype;
        private int show_type;
        private String anchor_city;

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }

        public String getRoom_src() {
            return room_src;
        }

        public void setRoom_src(String room_src) {
            this.room_src = room_src;
        }

        public String getVertical_src() {
            return vertical_src;
        }

        public void setVertical_src(String vertical_src) {
            this.vertical_src = vertical_src;
        }

        public int getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(int isVertical) {
            this.isVertical = isVertical;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getShow_status() {
            return show_status;
        }

        public void setShow_status(String show_status) {
            this.show_status = show_status;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getShow_time() {
            return show_time;
        }

        public void setShow_time(String show_time) {
            this.show_time = show_time;
        }

        public String getOwner_uid() {
            return owner_uid;
        }

        public void setOwner_uid(String owner_uid) {
            this.owner_uid = owner_uid;
        }

        public String getSpecific_catalog() {
            return specific_catalog;
        }

        public void setSpecific_catalog(String specific_catalog) {
            this.specific_catalog = specific_catalog;
        }

        public String getSpecific_status() {
            return specific_status;
        }

        public void setSpecific_status(String specific_status) {
            this.specific_status = specific_status;
        }

        public String getVod_quality() {
            return vod_quality;
        }

        public void setVod_quality(String vod_quality) {
            this.vod_quality = vod_quality;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public String getGame_name() {
            return game_name;
        }

        public void setGame_name(String game_name) {
            this.game_name = game_name;
        }

        public String getChild_id() {
            return child_id;
        }

        public void setChild_id(String child_id) {
            this.child_id = child_id;
        }

        public String getAvatar_mid() {
            return avatar_mid;
        }

        public void setAvatar_mid(String avatar_mid) {
            this.avatar_mid = avatar_mid;
        }

        public String getAvatar_small() {
            return avatar_small;
        }

        public void setAvatar_small(String avatar_small) {
            this.avatar_small = avatar_small;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public int getRanktype() {
            return ranktype;
        }

        public void setRanktype(int ranktype) {
            this.ranktype = ranktype;
        }

        public int getShow_type() {
            return show_type;
        }

        public void setShow_type(int show_type) {
            this.show_type = show_type;
        }

        public String getAnchor_city() {
            return anchor_city;
        }

        public void setAnchor_city(String anchor_city) {
            this.anchor_city = anchor_city;
        }
    }
}
