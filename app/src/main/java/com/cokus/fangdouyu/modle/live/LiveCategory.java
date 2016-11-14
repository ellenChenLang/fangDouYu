package com.cokus.fangdouyu.modle.live;

import java.io.Serializable;
import java.util.List;

/**
 * Created by coku on 16/11/11.
 */
public class LiveCategory implements Serializable {

    /**
     * error : 0
     * data : [{"cate_id":"1","cate_name":"热门游戏","short_name":"game","push_ios":"1","push_show":"0","push_vertical_screen":"0"},{"cate_id":"9","cate_name":"手游休闲","short_name":"syxx","push_ios":"1","push_show":"0","push_vertical_screen":"0"},{"cate_id":"2","cate_name":"鱼乐星天地","short_name":"ylxtd","push_ios":"1","push_show":"0","push_vertical_screen":"0"},{"cate_id":"10","cate_name":"鱼秀","short_name":"yx","push_ios":"1","push_show":"1","push_vertical_screen":"0"},{"cate_id":"8","cate_name":"颜值","short_name":"yz","push_ios":"1","push_show":"0","push_vertical_screen":"1"},{"cate_id":"3","cate_name":"科技","short_name":"kj","push_ios":"1","push_show":"0","push_vertical_screen":"0"},{"cate_id":"11","cate_name":"文娱课堂","short_name":"wykt","push_ios":"1","push_show":"0","push_vertical_screen":"0"}]
     */

    private int error;
    /**
     * cate_id : 1
     * cate_name : 热门游戏
     * short_name : game
     * push_ios : 1
     * push_show : 0
     * push_vertical_screen : 0
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
        private String cate_id;
        private String cate_name;
        private String short_name;
        private String push_ios;
        private String push_show;
        private String push_vertical_screen;

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public String getShort_name() {
            return short_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public String getPush_ios() {
            return push_ios;
        }

        public void setPush_ios(String push_ios) {
            this.push_ios = push_ios;
        }

        public String getPush_show() {
            return push_show;
        }

        public void setPush_show(String push_show) {
            this.push_show = push_show;
        }

        public String getPush_vertical_screen() {
            return push_vertical_screen;
        }

        public void setPush_vertical_screen(String push_vertical_screen) {
            this.push_vertical_screen = push_vertical_screen;
        }
    }
}
