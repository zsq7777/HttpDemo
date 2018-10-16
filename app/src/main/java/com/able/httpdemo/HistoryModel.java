package com.able.httpdemo;

import java.util.List;

public class HistoryModel {

    /**
     * reason : success
     * result : [{"day":"1/1","date":"前45年01月01日","title":"罗马共和国开始使用儒略历","e_id":"1"},{"day":"1/1","date":"404年01月01日","title":"东晋将领桓玄正式称帝，国号楚","e_id":"2"},{"day":"1/1","date":"860年01月01日","title":"西法兰克国王厄德一世诞生","e_id":"3"},{"day":"1/1","date":"976年01月01日","title":"南唐后主李煜被俘，南唐灭亡。","e_id":"4"},{"day":"1/1","date":"1085年01月01日","title":"司马光主持编撰的《资治通鉴》成书","e_id":"5"},{"day":"1/1","date":"1788年01月01日","title":"伦敦《泰晤士报》首次出版","e_id":"6"},{"day":"1/1","date":"1804年01月01日","title":"海地独立","e_id":"7"},{"day":"1/1","date":"1814年01月01日","title":"太平天国农民起义领袖洪秀全诞辰","e_id":"8"},{"day":"1/1","date":"1823年01月01日","title":"匈牙利诗人斐多菲诞生","e_id":"9"},{"day":"1/1","date":"1863年01月01日","title":"奥林匹克运动创始人顾拜旦诞辰","e_id":"10"},{"day":"1/1","date":"1864年01月01日","title":"著名画家、篆刻家齐白石诞生","e_id":"11"},{"day":"1/1","date":"1904年01月01日","title":"京剧表演艺术家程砚秋诞辰","e_id":"12"},{"day":"1/1","date":"1912年01月01日","title":"中华民国成立","e_id":"13"},{"day":"1/1","date":"1912年01月01日","title":"中华书局创办","e_id":"14"},{"day":"1/1","date":"1916年01月01日","title":"袁世凯复辟帝制","e_id":"15"},{"day":"1/1","date":"1917年01月01日","title":"胡适发起文学改良运动","e_id":"16"},{"day":"1/1","date":"1923年01月01日","title":"彭湃担任海丰县农会会长","e_id":"17"},{"day":"1/1","date":"1926年01月01日","title":"中国国民党第二次全国代表大会召开","e_id":"18"},{"day":"1/1","date":"1933年01月01日","title":"中国驻檀香山领事馆落成","e_id":"19"},{"day":"1/1","date":"1934年01月01日","title":"德国实施优生法","e_id":"20"},{"day":"1/1","date":"1939年01月01日","title":"国民党中常会决定开除汪精卫党籍","e_id":"21"},{"day":"1/1","date":"1939年01月01日","title":"惠普公司创办","e_id":"22"},{"day":"1/1","date":"1942年01月01日","title":"中苏美英等26国签署《联合国家共同宣言》","e_id":"23"},{"day":"1/1","date":"1946年01月01日","title":"天皇非神宣言发表","e_id":"24"},{"day":"1/1","date":"1948年01月01日","title":"中国国民党革命委员会在香港成立","e_id":"25"},{"day":"1/1","date":"1949年01月01日","title":"联合国促成克什米尔停火","e_id":"26"},{"day":"1/1","date":"1950年01月01日","title":"巴黎统筹委员会成立","e_id":"27"},{"day":"1/1","date":"1956年01月01日","title":"《解放军报》创刊","e_id":"28"},{"day":"1/1","date":"1956年01月01日","title":"苏丹独立","e_id":"29"},{"day":"1/1","date":"1957年01月01日","title":"萨尔在第二次世界大战后重归德国","e_id":"30"},{"day":"1/1","date":"1958年01月01日","title":"宝(宝鸡)成(成都)铁路正式通车","e_id":"31"},{"day":"1/1","date":"1959年01月01日","title":"古巴革命胜利","e_id":"32"},{"day":"1/1","date":"1960年01月01日","title":"刘家峡水利枢纽胜利截流","e_id":"33"},{"day":"1/1","date":"1960年01月01日","title":"喀麦隆独立","e_id":"34"},{"day":"1/1","date":"1962年01月01日","title":"西萨摩亚独立","e_id":"35"},{"day":"1/1","date":"1963年01月01日","title":"《铁臂阿童木》首播","e_id":"36"},{"day":"1/1","date":"1965年01月01日","title":"法塔赫领导的武装斗争开始","e_id":"37"},{"day":"1/1","date":"1976年01月01日","title":"著名传媒人柴静出生","e_id":"38"},{"day":"1/1","date":"1979年01月01日","title":"告台湾同胞书发表","e_id":"39"},{"day":"1/1","date":"1979年01月01日","title":"中国与美国建立外交关系","e_id":"40"},{"day":"1/1","date":"1980年01月01日","title":"首都国际机场正式启用","e_id":"41"},{"day":"1/1","date":"1981年01月01日","title":"《中华人民共和国婚姻法》（修正草案）公布施行","e_id":"42"},{"day":"1/1","date":"1981年01月01日","title":"我国正式实行学位制度","e_id":"43"},{"day":"1/1","date":"1982年01月01日","title":"全国农村工作会议纪要","e_id":"44"},{"day":"1/1","date":"1984年01月01日","title":"中国工商银行成立","e_id":"45"},{"day":"1/1","date":"1984年01月01日","title":"中国正式成为国际原子能机构成员国","e_id":"46"},{"day":"1/1","date":"1984年01月01日","title":"关于1984年农村工作的通知","e_id":"47"},{"day":"1/1","date":"1984年01月01日","title":"文莱独立","e_id":"48"},{"day":"1/1","date":"1985年01月01日","title":"活跃农村经济，中共中央、国务院出台新政策","e_id":"49"},{"day":"1/1","date":"1986年01月01日","title":"里根与戈尔巴乔夫互致问候","e_id":"50"},{"day":"1/1","date":"1988年01月01日","title":"天安门城楼正式对外开放","e_id":"51"},{"day":"1/1","date":"1992年01月01日","title":"布特罗斯·加利成为联合国秘书长","e_id":"52"},{"day":"1/1","date":"1993年01月01日","title":"兰桂坊惨剧","e_id":"53"},{"day":"1/1","date":"1993年01月01日","title":"捷克和斯洛伐克两共和国解体","e_id":"54"},{"day":"1/1","date":"1994年01月01日","title":"欧洲经济区成立","e_id":"55"},{"day":"1/1","date":"1994年01月01日","title":"我国正式成为《专利合作条约》(PCT)成员国","e_id":"56"},{"day":"1/1","date":"1995年01月01日","title":"世界贸易组织成立","e_id":"57"},{"day":"1/1","date":"1998年01月01日","title":"我国与南非建交","e_id":"58"},{"day":"1/1","date":"1999年01月01日","title":"欧元诞生","e_id":"59"},{"day":"1/1","date":"2000年01月01日","title":"百度公司成立","e_id":"60"},{"day":"1/1","date":"2002年01月01日","title":"欧元正式进入流通","e_id":"61"},{"day":"1/1","date":"2002年01月01日","title":"国务院发布《中华人民共和国反补贴条例》","e_id":"62"},{"day":"1/1","date":"2006年01月01日","title":"中国政府废止农业税","e_id":"63"},{"day":"1/1","date":"2010年01月01日","title":"中国－东盟自贸区正式建成","e_id":"64"},{"day":"1/1","date":"2016年01月01日","title":"全面两孩元旦施行","e_id":"65"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "HistoryModel{" +
                "reason='" + reason + '\'' +
                ", error_code=" + error_code +
                ", result=" + result +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * day : 1/1
         * date : 前45年01月01日
         * title : 罗马共和国开始使用儒略历
         * e_id : 1
         */

        private String day;
        private String date;
        private String title;
        private String e_id;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "day='" + day + '\'' +
                    ", date='" + date + '\'' +
                    ", title='" + title + '\'' +
                    ", e_id='" + e_id + '\'' +
                    '}';
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getE_id() {
            return e_id;
        }

        public void setE_id(String e_id) {
            this.e_id = e_id;
        }
    }
}
