package br.ufmg.coltec.lolzinho;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ChampionListDeserializer  implements JsonDeserializer<List>{


        @Override
        public List deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
        JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        List<Champion> champions = new ArrayList<>();

            Log.e("hdiah", "pdde");
        JsonObject p = jsonObject.getAsJsonObject("data");
        Champion champs = context.deserialize(p.get("Jax"), Champion.class);
        Log.e("hdiah", "pdde");


        champions.add(champs);

        return champions;
    }

}
