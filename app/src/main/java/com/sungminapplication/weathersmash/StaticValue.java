package com.sungminapplication.weathersmash;


import java.util.Calendar;

public class StaticValue {
    public static String BaseURL = "https://data.kma.go.kr/apiData/"; //baseURL
    public int Location = 108; //stnIds 숫자로 지역 구분
    public int StartDate = 20181204; //시작날짜(어제 날짜)
    public String CurrentHh = "00"; //시작시간(현재 시간 기준)
    public int EndDate =20181204; //마지막날자(startDate와 같은 날짜)

    public final String type = "json"; //response 타입(json 고정)
    public final String dataCd = "ASOS"; //data 분류 형식(ASOS 고정)
    public final String dateCd = "HR"; //리스트 분류 형식(HR 고정)
    public final String EndHh="23"; //마지막시간(23시 고정)
    public final int schListCnt=20; //한번에 나타낼 리스트 크기(20 고정)
    public final int pageIndex=1; //리스트를 나타낼 페이지수(1 고정)
    //String에서 "%2B" 는 "+" 일수도 있으니 주의 할 것
    public final String ApiKey = "5BDQ0BSBUOHk+iBVBcTHNCgHajhMsCVJLUipiRim9420Ul8Luq8AI7GTNyRatwMt"; //MY_OWN_KEY_VALUE

    public Calendar calendar;

    public static StaticValue staticValue = new StaticValue();
    public static StaticValue getInstance(){
        return staticValue;
    }

    //Calendar로 어제 날짜 구하기
    public int getStartDate() {
        this.calendar = Calendar.getInstance();
        calendar.add(calendar.get(Calendar.DAY_OF_MONTH), -1);
        Integer Year = calendar.get(Calendar.YEAR);
        Integer Month = calendar.get(Calendar.MONTH)+1;
        Integer Date = calendar.get(Calendar.DAY_OF_MONTH);
        String sDate;
        if(Date < 10){
            sDate = "0" + Date.toString();
        }
        else{
            sDate = Date.toString();
        }

        this.StartDate = Integer.parseInt(Year.toString()+Month.toString()+sDate);
        return this.StartDate;
    }

    //Calendar로 현재 시간 구하기, 타입은 String으로
    public String getCurrentHr() {
        this.calendar = Calendar.getInstance();
        Integer hour = calendar.get(Calendar.HOUR_OF_DAY);

        if(hour < 10){
            this.CurrentHh = "0" + hour.toString();
        }
        else {
            this.CurrentHh = hour.toString();
        }
        return this.CurrentHh;
    }

    //startDate와 같은 value를 가짐
    public int getEndDate() {
        this.EndDate = this.getStartDate();
        return this.EndDate;
    }

    //stnIds 가져옴
    public int getLocation() {
        return this.Location;
    }
}
