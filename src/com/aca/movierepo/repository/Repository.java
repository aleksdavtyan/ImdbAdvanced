package com.aca.movierepo.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public abstract class Repository<T extends Serializable, V extends Serializable> {

    public abstract void put(String key, V value, String fileName) throws IOException;

    public abstract Object get(String key, String fileName) throws IOException, ClassNotFoundException;
}