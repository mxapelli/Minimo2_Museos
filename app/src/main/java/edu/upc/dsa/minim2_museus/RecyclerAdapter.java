package edu.upc.dsa.minim2_museus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import edu.upc.dsa.minim2_museus.models.Element;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private List<Element> values;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name;
        public View layout;
        public ImageView avatar;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            name = (TextView) v.findViewById(R.id.museumText);
            avatar = (ImageView) v.findViewById(R.id.museumImage);
        }
    }

    public void add(int position, Element item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public RecyclerAdapter(List<Element> myDataset) {
        values = myDataset;
        LayoutInflater inflater;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.recycler_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        final String name = values.get(position).getAdrecaNom();
        holder.name.setText(name);
        Context context = holder.avatar.getContext();
        Picasso.with(context).load(values.get(position).getImatge().get(0)).into(holder.avatar);

        holder.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.name.getContext(), MuseumDetail.class);
                intent.putExtra("nombre", name);
                intent.putExtra("descripcion", values.get(position).getDescripcio());
                intent.putExtra("direccionGrupo", values.get(position).getGrupAdreca().getAdreca());
                intent.putExtra("postalGrupo", values.get(position).getGrupAdreca().getCodiPostal());
                intent.putExtra("municipio", values.get(position).getGrupAdreca().getMunicipiNom());
                intent.putExtra("email", values.get(position).getEmail().get(0));
                intent.putExtra("telefono", values.get(position).getTelefonContacte().get(0));
                intent.putExtra("urlEscudo",values.get(position).getRelMunicipis().getMunicipiEscut());
                intent.putExtra("urlBandera",values.get(position).getRelMunicipis().getMunicipiBandera());
                intent.putExtra("urlMuseo",values.get(position).getImatge().get(0));
                intent.putExtra("numeroHabitantes",values.get(position).getRelMunicipis().getNombreHabitants());
                intent.putExtra("extension",values.get(position).getRelMunicipis().getExtensio());
                intent.putExtra("altitud",values.get(position).getRelMunicipis().getAltitud());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
