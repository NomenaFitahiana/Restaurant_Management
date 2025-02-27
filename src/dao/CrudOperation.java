package dao;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudOperation  <T>{
     List<T> getAll();
}
