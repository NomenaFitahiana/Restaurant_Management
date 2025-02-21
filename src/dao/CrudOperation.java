package dao;

import java.util.List;

public class CrudOperation  <T>{
     List<T> getAll(int page, int size);
}
