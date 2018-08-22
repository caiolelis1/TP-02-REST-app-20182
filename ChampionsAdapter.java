package br.ufmg.coltec.lolzinho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChampionsAdapter extends BaseAdapter {

    private List<Champion> champions;
    private Context context;


    public ChampionsAdapter(Context context, List<Champion> champs)  {
        this.context = context;
        this.champions = champs;
        //... carrega dados da lista
    }

    @Override
    public int getCount() {
        return this.champions.size();
    }

    @Override
    public Object getItem(int i) {
        return this.champions.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Champion currentChamp = this.champions.get(i);

        // recupera a view do adapter que será customizada
        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_champion, viewGroup, false);

        TextView nome = newView.findViewById(R.id.nameCampeao);
        nome.setText(currentChamp.name);

        TextView titulo =newView.findViewById(R.id.titleCampeao);
        titulo.setText(currentChamp.title);

        return newView;
    }
}
