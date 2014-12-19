package com.unidesign.codercalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Uni{
	public static int random(int dayseed, int indexseed) {
        int n = dayseed % 11117;
        for (int i = 0; i < 100 + indexseed; i++) {
            n = n * n;
            n = n % 11117;   // 11117 �Ǹ�����
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

    static String[] weeks = {"��","һ","��","��","��","��","��"};
    static String[] directions = {"����","������","����","���Ϸ�","�Ϸ�","���Ϸ�","����","������"};

    static act[] activities = {
        new act("д��Ԫ����","д��Ԫ���Խ����ٳ���","д��Ԫ���Իή����Ŀ���Ч��"),
        new act("ϴ��", "�㼸��ûϴ���ˣ�","�����Ʒ�������ϴ��", true),
        new act("����һ������", "�Ժ������˿鸹��","����û���Ķ��٣��Ե�ȴ����", true),
        new act("����", "������������������˼ά����","�������ˣ��������û��ϵ", true),
        new act("��������", "������������ǰ�ȫ��","���ܵ��������Ժ��"),
        new act("�ع�", "���������õ����","����п��ܻ�������̶"),
        new act("ʹ��%t", "�㿴��������Ʒλ","���˻��������װ��"),
        new act("����","�÷���ʱ�ͷ���","���ڵ�ǰ�ľ������ƣ������һ�ݹ���δ�ر�����ǿ"),
        new act("����","����ǰ��λ�г�Ϊţ�˵�Ǳ��","���˻�д������"),
        new act("����","���Թٽ�������ܺ�","���Թٲ�ˬ�����������"),
        new act("�ύ��ְ����", "��˾�ҵ���һ��������ܸɸ����˵ļһ�Ͳ�����Ͽ����","���ڵ�ǰ�ľ������ƣ������һ�ݹ���δ�ر�����ǿ"),
        new act("�����н","�ϰ��������ܺ�","��˾���ڿ��ǲ�Ա"),
        new act("���ϼӰ�","�����ǳ���Ա������õ�ʱ��","����������", true),
        new act("��������ǰ��ţ", "�����㰫��������","�ᱻʶ��", true),
        new act("ߣ��","���⻺�������","ǿߣ�ҷ�����", true),
        new act("���������վ", "��ʰ�����������","���������",  true),
        new act("��������\"%v\"","",""),
        new act("д����%l�еķ���", "��Ĵ�����֯�ĺܺã���һ��û��ϵ","��Ĵ��뽫���Ҳ��������Լ���������"),
        new act("�ύ����", "������ͻ�ļ�������͵�","��������һ��ѳ�ͻ����������Լ��ǲ���ʱ�䴩Խ��"),
        new act("���븴��", "������Ҫ����ļ��ʴ������","��ʲô���ⶼ���ֲ��ˣ��װ��˷�ʱ��"),
        new act("����","д����֮�����һ�´������潡��","С�ı���ʺ���ӱ��ڹ�"),
        new act("��DOTA", "�㽫��������","��ᱻŰ�ĺܲ�", true),
        new act("��������", "�����ǳ���Ա������õ�ʱ��","������Ѿ���ƣ������"),
        new act("�޸�BUG", "������BUG�����������","�²�����BUG�����޸��ĸ���"),
        new act("�������", "���������齫���ͷ�Է籩","���˽�ƣ�������������ô����"),
        new act("��������", "",""),
        new act("��΢��", "���췢�����²��ܴ��","�����΢������������", true),
        new act("��ABվ", "����Ҫ������","�������ֹ��һ�˵������", true)
    };

    static String[] tools = {"Eclipseд����", "MSOfficeд�ĵ�", "���±�д����", "Windows8", "Linux", "MacOS", "IE", "Android�豸", "iOS�豸"};

    static String[] varNames = {"jieguo", "huodong", "pay", "expire", "zhangdan", "every", "free", "i1", "a", "virtual", "ad", "spider", "mima", "pass", "ui"};

    static String[] drinks = {"ˮ","��","���","�̲�","����","�̲�","����","ţ��","����","��֭","��ζ��ˮ","�մ�ˮ","�˶�����","����","��"};

    public static String getTodayString() {
        return "������" + today.get(Calendar.YEAR) + "��" + (today.get(Calendar.MONTH) + 1) + "��" + today.get(Calendar.DATE) + "�� ����" + weeks[today.get(Calendar.DAY_OF_WEEK)-1];
    }

    public static String star(int num) {
        String result = "";
        int i = 0;
        while (i < num) {
            result += "��";
            i++;
        }
        while(i < 5) {
            result += "��";
        i++;
        }
        return result;
    }

    // ���ɽ�������
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

    // ȥ��һЩ���Ͻ��յ��¼�
    public static act[] filter(act[] activities) {

        ArrayList<act> list=new ArrayList<act>();

        // ��ĩ�Ļ���ֻ���� weekend = true ���¼�
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

    // �� activities �������ѡ size ��
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

    // �������������ѡ size ��
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

    // ����ռλ�����滻���������
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