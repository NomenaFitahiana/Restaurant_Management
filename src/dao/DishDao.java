package dao;

import java.sql.Connection;
import java.util.List;

import db.DataSource;

public class DishDao  extends CrudOperation <Dish>{
    DataSource dataSource = new DataSource();
    Connection connection = dataSource.getConnection();

    public List<Dish> getAll(int page, int size){
        private 
    }
}
