package com.sportyshoes.repository;

import java.util.List;

public interface GenericRepository<T> {
	
	public List<T> getList();
	public T getById(Integer id);
	public void updateById(Integer id);
	public void deleteById(Integer id);

}
