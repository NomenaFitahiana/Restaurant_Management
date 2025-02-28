package dao;

import java.util.List;

import dao.entity.Criteria;
import dao.entity.SortCriteria;

public interface CrudOperation  <T>{
     List<T> getAll(int pageSize, int page, List<Criteria> criterias, SortCriteria sort);
     T getById(int id);
}
