package com.cokus.fangdouyu.modle.concern;

import java.io.Serializable;
import java.util.List;

/**
 * Created by coku on 16/11/13.
 */
public class RecommendLiveRoom implements Serializable{

    /**
     * error : 0
     * data : {"slide_room":[{"room_name":"暗杠听大牌：张远","room_id":268932,"online":14713,"nickname":"暗杠小发","room_src":"https://staticlive.douyucdn.cn/upload/signs/201611132150492609.JPG"},{"room_name":"张大大带你玩转明珠号","room_id":1139648,"online":570671,"nickname":"2049明珠号","room_src":"https://staticlive.douyucdn.cn/upload/signs/201611131623425301.jpg"},{"room_name":"2016德玛西亚杯总决赛","room_id":288016,"online":275326,"nickname":"Riot拳头","room_src":"https://staticlive.douyucdn.cn/upload/signs/201611131255102120.jpg"},{"room_name":"口袋妖怪-疯狂PVP！","room_id":971653,"online":9405,"nickname":"今何在大大","room_src":"https://staticlive.douyucdn.cn/upload/signs/201611132125311126.jpg"},{"room_name":"U联赛3-王者赛","room_id":55468,"online":8949,"nickname":"天天玩游戏","room_src":"https://staticlive.douyucdn.cn/upload/signs/201611132005401200.jpg"},{"room_name":"NSL国际炉石大师邀请赛","room_id":225595,"online":260540,"nickname":"NEOTV炉石传说频道","room_src":"https://staticlive.douyucdn.cn/upload/signs/201611131958183698.jpg"}],"new_bie":[{"room_id":"1097999","room_src":"https://rpic.douyucdn.cn/a1611/13/21/1097999_161113215321.jpg","room_name":"小浩哥  跪求火箭 求女友","nickname":"Q1bea6c0186fde097b","online":5},{"room_id":"1055625","room_src":"https://rpic.douyucdn.cn/appCovers/2016/11/10/1055625_201611102219_small.jpg","room_name":"【肉包】百变小樱画一画，明天变回欧洲人","nickname":"三层肉包","online":603},{"room_id":"1340086","room_src":"https://rpic.douyucdn.cn/a1611/13/21/1340086_161113215740.jpg","room_name":"韩国俊大肩霸的直播间","nickname":"韩国俊大肩霸","online":305},{"room_id":"1012616","room_src":"https://rpic.douyucdn.cn/a1611/13/21/1012616_161113215831.jpg","room_name":"小冰冰传奇各攻略讲解","nickname":"kezhu125","online":73},{"room_id":"623194","room_src":"https://rpic.douyucdn.cn/a1611/13/22/623194_161113220001.jpg","room_name":"【苏小凡】史上最冷杀手","nickname":"毁灭地球苏小凡","online":2765},{"room_id":"1345245","room_src":"https://rpic.douyucdn.cn/a1611/13/22/1345245_161113220529.jpg","room_name":"口袋妖怪复刻中低V日常，PK","nickname":"McGrady丶K","online":20},{"room_id":"447646","room_src":"https://rpic.douyucdn.cn/a1611/13/22/447646_161113220711.jpg","room_name":"剑灵-武灵天下赛首尔初赛","nickname":"腾讯活动专用直播间","online":2639},{"room_id":"283853","room_src":"https://rpic.douyucdn.cn/a1611/13/22/283853_161113220630.jpg","room_name":"阿亜西：有梦想的力士玩家","nickname":"阿亜西","online":1682},{"room_id":"1083891","room_src":"https://rpic.douyucdn.cn/a1611/13/21/1083891_161113215730.jpg","room_name":"【韩国釜山】晚安","nickname":"花木木啊啊啊啊","online":1902},{"room_id":"759845","room_src":"https://rpic.douyucdn.cn/a1611/13/22/759845_161113221429.jpg","room_name":"【台湾】露露 聽說愛你的人會請你吃火鍋","nickname":"微笑露露","online":3405},{"room_id":"1013061","room_src":"https://rpic.douyucdn.cn/a1611/12/21/1013061_161112213157.jpg","room_name":"|德国|妹子的深夜档","nickname":"德国的凯特琳娜","online":0},{"room_id":"959760","room_src":"https://rpic.douyucdn.cn/a1611/13/09/959760_161113093518.jpg","room_name":"美国-今天洗剪吹","nickname":"Gloriababy","online":647},{"room_id":"1040477","room_src":"https://rpic.douyucdn.cn/a1611/13/21/1040477_161113215845.jpg","room_name":"乌克兰皇帝:乌克兰张柏芝与低配李宇春","nickname":"乌克兰皇帝","online":3822},{"room_id":"848337","room_src":"https://rpic.douyucdn.cn/a1611/13/21/848337_161113215328.jpg","room_name":"新妹子来不来","nickname":"俄罗斯教父","online":14382},{"room_id":"1044376","room_src":"https://rpic.douyucdn.cn/a1611/13/21/1044376_161113215759.jpg","room_name":"韩国-胖友们晚上好","nickname":"可妹妹妹","online":1258},{"room_id":"477969","room_src":"https://rpic.douyucdn.cn/a1611/13/22/477969_161113220524.jpg","room_name":"今晚10点直播","nickname":"小泰一泰国户外一","online":13328},{"room_id":"543535","room_src":"https://rpic.douyucdn.cn/a1611/13/22/543535_161113220509.jpg","room_name":"参加完比赛，感触颇多！","nickname":"大鹏专玩蛇","online":110},{"room_id":"2129","room_src":"https://rpic.douyucdn.cn/a1611/13/22/2129_161113220638.jpg","room_name":"【刀锋铁骑】斗鱼杯娱乐赛皮蛋场","nickname":"皮蛋","online":1702},{"room_id":"712052","room_src":"https://rpic.douyucdn.cn/a1611/13/21/712052_161113215854.jpg","room_name":"【超人8点30，斗鱼杯娱乐赛","nickname":"超人ManX","online":1409},{"room_id":"441582","room_src":"https://rpic.douyucdn.cn/a1611/13/22/441582_161113220526.jpg","room_name":"【李晗风】是时候展现真正的技术了。","nickname":"李晗风","online":1703}]}
     */

    private int error;
    private DataBean data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * room_name : 暗杠听大牌：张远
         * room_id : 268932
         * online : 14713
         * nickname : 暗杠小发
         * room_src : https://staticlive.douyucdn.cn/upload/signs/201611132150492609.JPG
         */

        private List<SlideRoomBean> slide_room;
        /**
         * room_id : 1097999
         * room_src : https://rpic.douyucdn.cn/a1611/13/21/1097999_161113215321.jpg
         * room_name : 小浩哥  跪求火箭 求女友
         * nickname : Q1bea6c0186fde097b
         * online : 5
         */

        private List<NewBieBean> new_bie;

        public List<SlideRoomBean> getSlide_room() {
            return slide_room;
        }

        public void setSlide_room(List<SlideRoomBean> slide_room) {
            this.slide_room = slide_room;
        }

        public List<NewBieBean> getNew_bie() {
            return new_bie;
        }

        public void setNew_bie(List<NewBieBean> new_bie) {
            this.new_bie = new_bie;
        }

        public static class SlideRoomBean {
            private String room_name;
            private int room_id;
            private int online;
            private String nickname;
            private String room_src;

            public String getRoom_name() {
                return room_name;
            }

            public void setRoom_name(String room_name) {
                this.room_name = room_name;
            }

            public int getRoom_id() {
                return room_id;
            }

            public void setRoom_id(int room_id) {
                this.room_id = room_id;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRoom_src() {
                return room_src;
            }

            public void setRoom_src(String room_src) {
                this.room_src = room_src;
            }
        }

        public static class NewBieBean {
            private String room_id;
            private String room_src;
            private String room_name;
            private String nickname;
            private int online;

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

            public String getRoom_name() {
                return room_name;
            }

            public void setRoom_name(String room_name) {
                this.room_name = room_name;
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
        }
    }
}
