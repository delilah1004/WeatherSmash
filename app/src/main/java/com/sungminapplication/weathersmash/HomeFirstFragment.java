package com.sungminapplication.weathersmash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.sungminapplication.weathersmash.Commuication.NetworkService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFirstFragment extends Fragment {

    public static HomeFirstFragment homeFirstFragment = new HomeFirstFragment();
    public static HomeFirstFragment getInstance(){
        return homeFirstFragment;
    }
    public View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        CallData();
        return view;
    }

    public void CallData(){
        StaticValue staticValue = StaticValue.getInstance();

        Call<ArrayList<JsonObject>> call = NetworkService.getInstance().getNetworkInterface()
        //.getApiKey("json", "ASOS", "HR", 20181205, "15", 20181205,"23", 108, 20, 1, "5BDQ0BSBUOHk+iBVBcTHNCgHajhMsCVJLUipiRim9420Ul8Luq8AI7GTNyRatwMt");
        .getApiKey(staticValue.type, staticValue.dataCd, staticValue.dateCd,
                   staticValue.getStartDate(), staticValue.getCurrentHr(),
                   staticValue.getEndDate(), staticValue.EndHh, staticValue.getLocation(),
                   staticValue.schListCnt, staticValue.pageIndex, staticValue.ApiKey);

        call.enqueue(new Callback<ArrayList<JsonObject>>() {
            @Override
            public void onResponse(Call<ArrayList<JsonObject>> call, Response<ArrayList<JsonObject>> response) {
                //4번째 object "info" -> Array 얻고 -> 1번째 object를 가지고 옴, 시작시간이 현재 기준으로 해당 hour이므로 최근 hour를 가져온다.
                JsonObject jsonObject = response.body().get(3).getAsJsonObject().get("info").getAsJsonArray().get(0).getAsJsonObject();

                String temper = jsonObject.get("TA").toString();
                String time = jsonObject.get("TM").toString();

                TextView currentTem = view.findViewById(R.id.nowTemper);
                Log.d("CurrentTime", time);
                Log.d("CurrentTemperature", temper);
                currentTem.setText(temper);

                Log.d("Success", String.valueOf(response.body()));
                Log.d("Success", response.message() + " " + String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<ArrayList<JsonObject>> call, Throwable t) {
                StaticValue staticValue = StaticValue.getInstance();
                Log.d("Temperature", t.getMessage());
                Log.d("StaticValue", "URL : " + StaticValue.BaseURL + "getData?type=" + staticValue.type + "&dataCd=" +  staticValue.dataCd + "&dateCd=" + staticValue.dateCd+ "&startDt=" +staticValue.getStartDate()+ "&startHh=" +staticValue.getCurrentHr()+ "&endDt=" +
                        staticValue.getEndDate()+ "&endHh=" +staticValue.EndHh+ "&stnIds=" +staticValue.getLocation()+ "&schListCnt=" +staticValue.schListCnt+ "&pageIndex=" +staticValue.pageIndex+ "&apiKey=" +staticValue.ApiKey);
            }
        });

    }

}
