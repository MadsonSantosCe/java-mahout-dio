package com.example.recomendador.service;

import com.example.recomendador.recommender.RecomendadorBuilder;
import com.example.recomendador.repository.FilmesRepository;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FilmesService {

    @Autowired
    FilmesRepository repository;

    public List<RecommendedItem> getRecommendations() {
        DataModel filmes = repository.getModeloDeFilmes();
        Recommender recommender = new RecomendadorBuilder().buildRecommender(filmes);

        try {
            List<RecommendedItem> recommendations = recommender.recommend(1, 5);
            return recommendations;

        } catch (TasteException e) {
            e.printStackTrace();
            return null;

        }

    }


}
