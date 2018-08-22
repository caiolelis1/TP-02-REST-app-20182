package br.ufmg.coltec.lolzinho;
/**
 * Created by a2016951782 on 02/08/18.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SummonerService {

    @GET("/lol/static-data/v3/champions?api_key=RGAPI-ae176889-2fc2-4094-919d-a915be331c9b")
    Call<List<Champion>> getChampionList();

}

