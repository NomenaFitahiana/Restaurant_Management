package dao;

import java.util.List;

import dao.entity.Criteria;

public interface CrudOperation  <T>{
     List<T> getAll(int pageSize, int page, List<Criteria> criterias);
     T getById(int id);
}
