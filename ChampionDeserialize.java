package br.ufmg.coltec.lolzinho;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ChampionDeserialize implements JsonDeserializer<Champion> {
    @Override
    public Champion deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
        Log.e("kpda", "djoadw");
        Champion champion = new Champion();
        champion.name = jsonObject.get("name").getAsString();
        champion.title = jsonObject.get("title").getAsString();

        return champion;
    }
}
