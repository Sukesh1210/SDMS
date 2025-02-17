package com.jspiders.cardekho_with_servletsandjsp.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspiders.cardekho_with_servletsandjsp.entity.CarEntity;


public class CarJDBC {
	private Driver driver;
	private  Connection connection;
	private  PreparedStatement preparedStatement;
	private  String query;
	private  ResultSet resultSet;
	
	
	private  void openConnection() throws SQLException {
		Driver driver=new com.mysql.cj.jdbc.Driver();
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");
	}
	private void closeConnection() throws SQLException {
		if(resultSet!=null) {
			resultSet.close();
		}
		if(preparedStatement!=null) {
			preparedStatement.close();
		}
		if(connection!=null) {
			connection.close();
		}
	}
	int res;
	public int addCar(int id, String name, String brand, double price) {
		try {
			openConnection();
			query="INSERT INTO cardekho VALUES(?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, brand);
			preparedStatement.setDouble(4, price);
			res = preparedStatement.executeUpdate();
			System.out.println(res+"row(s) affected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}
	public List<CarEntity> getAllCars() {
		List<CarEntity> cars=new ArrayList<CarEntity>();
		try {
			openConnection();
			query="SELECT * FROM cardekho";
			preparedStatement=connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CarEntity carEntity=new CarEntity();
				carEntity.setId(resultSet.getInt(1));
				carEntity.setName(resultSet.getString(2));
				carEntity.setBrand(resultSet.getString(3));
				carEntity.setPrice(resultSet.getDouble(4));
				cars.add(carEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cars;
	}
	public int deleteCar( int id) {
		int res=0;
		try {
			openConnection();
			query="DELETE  FROM cardekho WHERE id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			res=preparedStatement.executeUpdate();
			System.out.println(res+"row(s) affected");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}
	public CarEntity getCarById(int id) {
		CarEntity carEntity=null;
		try {
			openConnection();
			query="SELECT * FROM cardekho WHERE id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				carEntity=new CarEntity();
				carEntity.setId(resultSet.getInt(1));
				carEntity.setName(resultSet.getString(2));
				carEntity.setBrand(resultSet.getString(3));
				carEntity.setPrice(resultSet.getDouble(4));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return carEntity;
	}
	public void updateCar(int id, String name, String brand, double price) {
		try {
			openConnection();
			query="UPDATE cardekho SET name=?,brand=?,price=? WHERE id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, brand);
			preparedStatement.setDouble(3, price);
			preparedStatement.setInt(4, id);
			int res = preparedStatement.executeUpdate();
			System.out.println(res+"row(s) affected");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
