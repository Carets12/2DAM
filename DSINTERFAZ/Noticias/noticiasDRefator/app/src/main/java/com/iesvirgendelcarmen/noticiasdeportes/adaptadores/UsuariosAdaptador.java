package com.iesvirgendelcarmen.noticiasdeportes.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.iesvirgendelcarmen.noticiasdeportes.R;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.Usuario;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.api.VolleySingleton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matinal on 13/12/17.
 */

public class UsuariosAdaptador extends BaseAdapter{

    private Context context;
    private List<Usuario> usuarios;

    public UsuariosAdaptador(Context context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        UsuariosAdaptador.ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.usuarios_row_item, viewGroup, false);
            viewHolder = new UsuariosAdaptador.ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (UsuariosAdaptador.ViewHolder) view.getTag();
        }

        Usuario usuario = (Usuario) getItem(i);

        viewHolder.id.setText(usuario.getId());
        viewHolder.first_name.setText(usuario.getFirst_name());
        viewHolder.last_name.setText(usuario.getLast_name());
        viewHolder.email.setText(usuario.getEmail());

/*
        viewHolder.titulo.setText(noticia.getTitle());
        viewHolder.autor.setText(noticia.getAuthor());
        viewHolder.fecha.setText(noticia.getFormatPublishedAt());
        viewHolder.imagen.setImageUrl(noticia.getUrlToImage(), VolleySingleton.getInstance(context).getImageLoader());
*/
        return view;
    }

    public static class ViewHolder {
        @BindView(R.id.id)
        TextView id;
        @BindView(R.id.first_name)
        TextView first_name;
        @BindView(R.id.last_name)
        TextView last_name;
        @BindView(R.id.email)
        TextView email;
       /* @BindView(R.id.titulo)
        TextView titulo;
        @BindView(R.id.autor)
        TextView autor;
        @BindView(R.id.fecha)
        TextView fecha;
        @BindView(R.id.imagen)
        NetworkImageView imagen;*/

        public ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
