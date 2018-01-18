package com.iesvirgendelcarmen.noticiasdeportes.modelos;

import java.util.ArrayList;
import java.util.Date;


public class NoticiasMock implements NoticiasDataSource {
    @Override
    public void getNoticias(CargaNoticiasCallback callback) {
        ArrayList<Noticia> lista = new ArrayList<>();

        Noticia n = new Noticia();
        n.setAuthor("Luis Molina");
        n.setTitle("El Barcelona pierde todas las competiciones");
        n.setDescription("El Barcelona FC pierde todas las competiciones en las que juega.");
        n.setPublishedAt(new Date());
        n.setUrlToImage("http://e00-marca.uecdn.es/assets/multimedia/imagenes/2017/12/18/15135533241653_310x174.jpg");

        lista.add(n);

        n = new Noticia();
        n.setAuthor("Luis Molina");
        n.setTitle("El Madrid gana todas las competiciones");
        n.setDescription("El Madrid FC gana todas las competiciones en las que juega.");
        n.setPublishedAt(new Date());
        n.setUrlToImage("https://marcaesports-prod-images.imgix.net/2017/12/18141318/videojuegos-series.jpg?fit=crop&fm=pjpg&h=383&w=680&wpsize=marcaesports_large");

        lista.add(n);


        callback.onNoticiasCargadas(lista);

    }

    @Override
    public void getNoticia(int posicion, CargaNoticiaCallback callback) {

        Noticia n1 = new Noticia();
        n1.setAuthor("Luis Molina");
        n1.setTitle("El Barcelona pierde todas las competiciones");
        n1.setDescription("El Barcelona FC pierde todas las competiciones en las que juega.");
        n1.setPublishedAt(new Date());
        n1.setUrlToImage("http://e00-marca.uecdn.es/assets/multimedia/imagenes/2017/12/18/15135533241653_310x174.jpg");

        Noticia n2 = new Noticia();
        n2.setAuthor("Luis Molina");
        n2.setTitle("El Madrid gana todas las competiciones");
        n2.setDescription("El Madrid FC gana todas las competiciones en las que juega.");
        n2.setPublishedAt(new Date());
        n2.setUrlToImage("https://marcaesports-prod-images.imgix.net/2017/12/18141318/videojuegos-series.jpg?fit=crop&fm=pjpg&h=383&w=680&wpsize=marcaesports_large");

        if (posicion == 1) callback.onNoticiaCargada(n1);
        else callback.onNoticiaCargada(n2);

    }
}
