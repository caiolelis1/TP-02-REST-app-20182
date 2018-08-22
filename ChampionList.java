package br.ufmg.coltec.lolzinho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChampionList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_list);

        final ListView champList = findViewById(R.id.Champions);

        SummonerService service = new RetrofitConfig().getSummonerService();
        Call<List<Champion>> ChampListCall = service.getChampionList();

        ChampListCall.enqueue(new Callback<List<Champion>>() {
            @Override
            public void onResponse(Call<List<Champion>> call, Response<List<Champion>> response) {
                Log.e("dsa","asd");
                List<Champion> champions = response.body();

                champList.setAdapter(new ChampionsAdapter(ChampionList.this, champions));

                champList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(ChampionList.this, ChampionPage.class);
                        Bundle args = new Bundle();
                        Champion currentChampion = (Champion) champList.getItemAtPosition(champList.getPositionForView(view));

                        args.putString("name", currentChampion.name);
                        args.putString("title", currentChampion.title);
                        args.putInt("id", currentChampion.id);
                        intent.putExtras(args);
                        startActivity(intent);

                        return false;
                    }
                });

            }

            @Override
            public void onFailure(Call<List<Champion>> call, Throwable t) {
                Log.e("kdw", "dkawodo", t);

            }
        });


    }
}
