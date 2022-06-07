package repository;

import model.Shoes;

import java.util.ArrayList;

public interface IShoesRepository {
    ArrayList<Shoes> getAll();
    Shoes findById(int id);
    void add(Shoes shoes);
    void delete(Shoes shoes);
}
