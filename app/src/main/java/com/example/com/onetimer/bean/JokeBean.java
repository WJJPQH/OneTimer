package com.example.com.onetimer.bean;

import java.util.List;

public class JokeBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"特特特某嘟嘟","createTime":"2018-04-26T11:47:19","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247144394052018-04-26_11-46-36.jpg","jid":2258,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15268998259983d2b7b899e510fb3def87bfedb33c895d3430cd8.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"特特特某嘟嘟","createTime":"2018-04-26T11:47:10","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247144303892018-04-26_11-46-36.jpg","jid":2257,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15268998259983d2b7b899e510fb3def87bfedb33c895d3430cd8.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"nihaoa","createTime":"2018-04-26T11:42:43","imgUrls":null,"jid":2256,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"nihaoa","createTime":"2018-04-26T11:39:25","imgUrls":null,"jid":2255,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"哈哈哈","createTime":"2018-04-26T10:59:14","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524711554574Screenshot_2018-04-23-21-57-17.jpg|https://www.zhaoapi.cn/images/quarter/1524711554574temphead.jpg","jid":2254,"praiseNum":null,"shareNum":null,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":"小栗同学丶","praiseNum":"null"}},{"commentNum":null,"content":"呜哈哈哈哈","createTime":"2018-04-26T10:56:43","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524711403276temphead.jpg|https://www.zhaoapi.cn/images/quarter/1524711403276temphead.jpg|https://www.zhaoapi.cn/images/quarter/1524711403276Screenshot_2018-04-23-21-57-17.jpg","jid":2253,"praiseNum":null,"shareNum":null,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":"小栗同学丶","praiseNum":"null"}},{"commentNum":null,"content":"123455","createTime":"2018-04-26T10:55:05","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524711305353temphead.jpg|https://www.zhaoapi.cn/images/quarter/1524711305353temphead.jpg","jid":2252,"praiseNum":null,"shareNum":null,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":"小栗同学丶","praiseNum":"null"}},{"commentNum":null,"content":"12351515","createTime":"2018-04-26T10:48:59","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524710939023temphead.jpg|https://www.zhaoapi.cn/images/quarter/1524710939023temphead.jpg","jid":2251,"praiseNum":null,"shareNum":null,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":"小栗同学丶","praiseNum":"null"}},{"commentNum":null,"content":"12315681","createTime":"2018-04-26T10:48:27","imgUrls":null,"jid":2250,"praiseNum":null,"shareNum":null,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":"小栗同学丶","praiseNum":"null"}},{"commentNum":null,"content":"快要毕业了，别紧张","createTime":"2018-04-26T09:11:24","imgUrls":null,"jid":2249,"praiseNum":null,"shareNum":null,"uid":10962,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1527166137241200876385.gif","nickname":null,"praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 特特特某嘟嘟
         * createTime : 2018-04-26T11:47:19
         * imgUrls : https://www.zhaoapi.cn/images/quarter/15247144394052018-04-26_11-46-36.jpg
         * jid : 2258
         * praiseNum : null
         * shareNum : null
         * uid : 12882
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15268998259983d2b7b899e510fb3def87bfedb33c895d3430cd8.jpg","nickname":null,"praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private String imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(String imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/15268998259983d2b7b899e510fb3def87bfedb33c895d3430cd8.jpg
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
