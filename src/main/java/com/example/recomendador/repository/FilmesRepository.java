package com.example.recomendador.repository;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
public class FilmesRepository {

    private DataModel getModelo(String path) {
        File file = new File("src/main/resources/csv/" + path);
        try {
            return new FileDataModel(file);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public DataModel getModeloDeFilmes(){

        return getModelo("filmes.csv");
    }

}
