package com.sportyshoes.repository;

import java.util.List;

public interface GenericRepository<T> {
	
	public List<T> getList();
	public T getById(Integer id);
	public void save(T targetObj);
	public void deleteById(Integer id);

}
