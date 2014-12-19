package com.unidesign.codercalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Uni{
	public static int random(int dayseed, int indexseed) {
        int n = dayseed % 11117;
        for (int i = 0; i < 100 + indexseed; i++) {
            n = n * n;
            n = n % 11117;   // 11117 是个质数
        }
        return n;
    }

    public static class act{

        String name,good,bad;
        boolean weekend=false;

        public act(String name, String good, String bad){
            this.name=name;
            this.good=good;
            this.bad=bad;
        }

        public act(String name,String good,String bad,boolean weekend){
            this.name=name;
            this.good=good;
            this.bad=bad;
            this.weekend=weekend;
        }

    }

    static Calendar today = Calendar.getInstance();
    static int iday = today.get(Calendar.YEAR) * 10000 + (today.get(Calendar.MONTH) + 1) * 100 + today.get(Calendar.DATE);

    static String[] weeks = {"日","一","二","三","四","五","六"};
    static String[] directions = {"北方","东北方","东方","东南方","南方","西南方","西方","西北方"};

    static act[] activities = {
        new act("写单元测试","写单元测试将减少出错","写单元测试会降低你的开发效率"),
        new act("洗澡", "你几天没洗澡了？","会把设计方面的灵感洗掉", true),
        new act("锻炼一下身体", "以后可以秀八块腹肌","能量没消耗多少，吃得却更多", true),
        new act("抽烟", "抽烟有利于提神，增加思维敏捷","除非你活够了，死得早点没关系", true),
        new act("白天上线", "今天白天上线是安全的","可能导致灾难性后果"),
        new act("重构", "代码质量得到提高","你很有可能会陷入泥潭"),
        new act("使用%t", "你看起来更有品位","别人会觉得你在装逼"),
        new act("跳槽","该放手时就放手","鉴于当前的经济形势，你的下一份工作未必比现在强"),
        new act("招人","你面前这位有成为牛人的潜质","这人会写程序吗？"),
        new act("面试","面试官今天心情很好","面试官不爽，会拿你出气"),
        new act("提交辞职申请", "公司找到了一个比你更能干更便宜的家伙，巴不得你赶快滚蛋","鉴于当前的经济形势，你的下一份工作未必比现在强"),
        new act("申请加薪","老板今天心情很好","公司正在考虑裁员"),
        new act("晚上加班","晚上是程序员精神最好的时候","明天你会崩溃", true),
        new act("在妹子面前吹牛", "改善你矮穷挫的形象","会被识破", true),
        new act("撸管","避免缓冲区溢出","强撸灰飞烟灭", true),
        new act("浏览成人网站", "重拾对生活的信心","你会心神不宁",  true),
        new act("命名变量\"%v\"","",""),
        new act("写超过%l行的方法", "你的代码组织的很好，长一点没关系","你的代码将混乱不堪，你自己都看不懂"),
        new act("提交代码", "遇到冲突的几率是最低的","你遇到的一大堆冲突会让你觉得自己是不是时间穿越了"),
        new act("代码复审", "发现重要问题的几率大大增加","你什么问题都发现不了，白白浪费时间"),
        new act("开会","写代码之余放松一下打个盹，有益健康","小心被扣屎盆子背黑锅"),
        new act("打DOTA", "你将有如神助","你会被虐的很惨", true),
        new act("晚上上线", "晚上是程序员精神最好的时候","你白天已经筋疲力尽了"),
        new act("修复BUG", "你今天对BUG的嗅觉大大提高","新产生的BUG将比修复的更多"),
        new act("设计评审", "设计评审会议将变成头脑风暴","人人筋疲力尽，评审就这么过了"),
        new act("需求评审", "",""),
        new act("上微博", "今天发生的事不能错过","今天的微博充满负能量", true),
        new act("上AB站", "还需要理由吗？","满屏的兄贵我会说出来？", true)
    };

    static String[] tools = {"Eclipse写程序", "MSOffice写文档", "记事本写程序", "Windows8", "Linux", "MacOS", "IE", "Android设备", "iOS设备"};

    static String[] varNames = {"jieguo", "huodong", "pay", "expire", "zhangdan", "every", "free", "i1", "a", "virtual", "ad", "spider", "mima", "pass", "ui"};

    static String[] drinks = {"水","茶","红茶","绿茶","咖啡","奶茶","可乐","牛奶","豆奶","果汁","果味汽水","苏打水","运动饮料","酸奶","酒"};

    public static String getTodayString() {
        return "今天是" + today.get(Calendar.YEAR) + "年" + (today.get(Calendar.MONTH) + 1) + "月" + today.get(Calendar.DATE) + "日 星期" + weeks[today.get(Calendar.DAY_OF_WEEK)-1];
    }

    public static String star(int num) {
        String result = "";
        int i = 0;
        while (i < num) {
            result += "★";
            i++;
        }
        while(i < 5) {
            result += "☆";
        i++;
        }
        return result;
    }

    // 生成今日运势
    public static String[][] pickTodaysLuck() {
        act[] _activities = filter(activities);

        int numGood = random(iday, 98) % 3 + 2;
        int numBad = random(iday, 87) % 3 + 2;
        List<act> eventArr = pickRandomActivity(_activities, numGood + numBad);
        String[][] luck=new String[2][10];
        
        for (int i = 0; i < numGood; i++) {
            luck[0][2*i]=eventArr.get(i).name;
            luck[0][2*i+1]=eventArr.get(i).good;
        }
        
        for (int i = 0; i < numBad; i++) {
            luck[1][2*i]=eventArr.get(numGood+i).name;
            luck[1][2*i+1]=eventArr.get(numGood+i).bad;
        }
        
        return luck;
    }

    // 去掉一些不合今日的事件
    public static act[] filter(act[] activities) {

        ArrayList<act> list=new ArrayList<act>();

        // 周末的话，只留下 weekend = true 的事件
        if (isWeekend()==true) {
            for (int i = 0; i < activities.length; i++) {
                if (activities[i].weekend) {
                    list.add(activities[i]);
                }
            }
            return (act[])list.toArray(new act[0]);
        }
        return activities;
    }

    public static boolean isWeekend() {
        return today.get(Calendar.DAY_OF_WEEK) == 1 || today.get(Calendar.DAY_OF_WEEK) == 7 ;
    }

    // 从 activities 中随机挑选 size 个
    public static List<act> pickRandomActivity(act[] activities, int size) {

        ArrayList<act> picked_events=new ArrayList<act>();

        for (int i = 0; i < activities.length; i++) {
            picked_events.add(activities[i]);
        }

        for (int j = 0; j < activities.length - size; j++) {
            int index = random(iday, j) % picked_events.size();
            picked_events.remove(index);
        }

        for (int i = 0; i < picked_events.size(); i++) {
            picked_events.set(i,parse((act) picked_events.get(i)));
        }

        return picked_events;
    }

    // 从数组中随机挑选 size 个
    public static ArrayList<String> pickRandom(String[] array, int size) {

        ArrayList<String> list=new ArrayList<String>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        for (int j = 0; j < array.length - size; j++) {
            int index = random(iday, j) % list.size();
            list.remove(index);
        }

        return list;
    }

    public static String printRandom(){
        ArrayList<String> pre=pickRandom(drinks,2);
        String post="";
        for(int i=0; i<pre.size(); i++){
            if(i>0 && i< pre.size()){
                post += ", ";
            }
            post += pre.get(i);
        }
        return post;
    }

    // 解析占位符并替换成随机内容
    public static act parse(act event) {
        act result = new act(event.name, event.good, event.bad , event.weekend);  // clone

        if (result.name.indexOf("%v") != -1) {
            result.name = result.name.replace("%v", varNames[random(iday, 12) % varNames.length]);
        }

        if (result.name.indexOf("%t") != -1) {
            result.name = result.name.replace("%t", tools[random(iday, 11) % tools.length]);
        }

        if (result.name.indexOf("%l") != -1) {
            result.name = result.name.replace("%l", Integer.toString(random(iday, 12) % 247 + 30));
        }

        return result;
    }
}