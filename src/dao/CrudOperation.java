package dao;

import java.util.List;

public interface CrudOperation  <T>{
     List<T> getAll();
}
