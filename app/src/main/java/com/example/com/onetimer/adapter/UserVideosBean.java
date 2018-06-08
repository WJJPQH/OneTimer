package com.example.com.onetimer.adapter;

import java.util.List;

public class UserVideosBean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524460515101head.jpg","createTime":"2018-04-23T13:15:15","favoriteNum":null,"latitude":"39.1","localUri":null,"longitude":"32.1","playNum":0,"praiseNum":null,"uid":11555,"videoUrl":"https://www.zhaoapi.cn/images/quarter/152446051510181ef85a6-ce99-479b-a815-538d93bfbe1d.mp4","wid":378,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524471315601head.jpg","createTime":"2018-04-23T16:15:15","favoriteNum":null,"latitude":"39.1","localUri":null,"longitude":"32.1","playNum":0,"praiseNum":null,"uid":11555,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524471315601422ef9da-cc73-4526-a8e8-ada2d9fb501b.mp4","wid":380,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524472022048head.jpg","createTime":"2018-04-23T16:27:02","favoriteNum":null,"latitude":"39.1","localUri":null,"longitude":"32.1","playNum":0,"praiseNum":null,"uid":11555,"videoUrl":"https://www.zhaoapi.cn/images/quarter/15244720220488c5eb244-b62e-4628-aaeb-1125e199b431.mp4","wid":381,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524478348687head.jpg","createTime":"2018-04-23T18:12:28","favoriteNum":null,"latitude":"39.1","localUri":null,"longitude":"32.1","playNum":0,"praiseNum":null,"uid":11555,"videoUrl":"https://www.zhaoapi.cn/images/quarter/15244783486876630fc4a-b993-4221-92ba-0345170f599c.mp4","wid":382,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524478508531head.jpg","createTime":"2018-04-23T18:15:08","favoriteNum":null,"latitude":"39.1","localUri":null,"longitude":"32.1","playNum":0,"praiseNum":null,"uid":11555,"videoUrl":"https://www.zhaoapi.cn/images/quarter/15244785085310830560c-b55d-48ad-9937-3aea86d19442.mp4","wid":383,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524478854693head.jpg","createTime":"2018-04-23T18:20:54","favoriteNum":null,"latitude":"39.1","localUri":null,"longitude":"32.1","playNum":0,"praiseNum":null,"uid":11555,"videoUrl":"https://www.zhaoapi.cn/images/quarter/15244788546936780da43-d2a5-4d9a-a46a-6e87738520a3.mp4","wid":384,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524480824881head.jpg","createTime":"2018-04-23T18:53:44","favoriteNum":null,"latitude":"39.1","localUri":null,"longitude":"32.1","playNum":0,"praiseNum":null,"uid":11555,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524480824881a9140c6e-f317-41be-be42-fabeb38ecb5d.mp4","wid":385,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524481734471head.jpg","createTime":"2018-04-23T19:08:54","favoriteNum":null,"latitude":"39.1","localUri":null,"longitude":"32.1","playNum":0,"praiseNum":null,"uid":11555,"videoUrl":"https://www.zhaoapi.cn/images/quarter/15244817344718e618328-92cd-4439-a4c4-a13ccf9f0362.mp4","wid":386,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524481762766head.jpg","createTime":"2018-04-23T19:09:22","favoriteNum":null,"latitude":"39.1","localUri":null,"longitude":"32.1","playNum":0,"praiseNum":null,"uid":11555,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524481762766731c308e-062a-4fab-a410-26908a26bd91.mp4","wid":387,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1524481847399head.jpg","createTime":"2018-04-23T19:10:47","favoriteNum":null,"latitude":"39.1","localUri":null,"longitude":"32.1","playNum":0,"praiseNum":null,"uid":11555,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1524481847399da80cc3e-c9a6-4a7a-aa2a-da98bfcc867d.mp4","wid":388,"workDesc":null}]
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
         * cover : https://www.zhaoapi.cn/images/quarter/1524460515101head.jpg
         * createTime : 2018-04-23T13:15:15
         * favoriteNum : null
         * latitude : 39.1
         * localUri : null
         * longitude : 32.1
         * playNum : 0
         * praiseNum : null
         * uid : 11555
         * videoUrl : https://www.zhaoapi.cn/images/quarter/152446051510181ef85a6-ce99-479b-a815-538d93bfbe1d.mp4
         * wid : 378
         * workDesc : null
         */

        private Object commentNum;
        private String cover;
        private String createTime;
        private Object favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private Object praiseNum;
        private int uid;
        private String videoUrl;
        private int wid;
        private Object workDesc;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(Object favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public Object getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(Object workDesc) {
            this.workDesc = workDesc;
        }
    }
}
