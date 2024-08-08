package com.example.QuanLiSach.Service;

import java.util.ArrayList;

public interface BaseService <T> {
	ArrayList<T> findAll();
	void create(T t);
	void update (T t);
	void remove ( T t );
}
