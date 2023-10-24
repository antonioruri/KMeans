package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



import database.TableSchema.Column;


public class TableData {

	DbAccess db;

	
	
	public TableData(DbAccess db) {
		this.db=db;
	}

	public List<Example> getDistinctTransazioni(String table) throws SQLException, EmptySetException, DatabaseConnectionException {
		TableSchema tableSchema = new TableSchema(db,table);
		List<Example> list = new ArrayList<>();
		Connection conn = db.getConnection();
		Statement s = conn.createStatement();
		String query = "SELECT DISTINCT * FROM " + table + ";";
		ResultSet resultSet = s.executeQuery(query);
		while(resultSet.next()) {
			Example example = new Example();
			for (int i = 0; i < tableSchema.getNumberOfAttributes(); i++) {
				if (tableSchema.getColumn(i).isNumber())
					example.add(resultSet.getDouble(tableSchema.getColumn(i).getColumnName()));
				else
					example.add(resultSet.getDouble(tableSchema.getColumn(i).getColumnName()));;
			}

		list.add(example);
		}
		resultSet.close();
		s.close();
		if(list.isEmpty())
			throw new EmptySetException();
		return list;
	}

	
	public  Set<Object>getDistinctColumnValues(String table,Column column) throws SQLException, DatabaseConnectionException {
		Set<Object> values = new TreeSet<>();
		Connection conn = db.getConnection();
		Statement s = conn.createStatement();
		String query = "SELECT DISTINCT " + column.getColumnName() + " FROM "+ table + ";";
		ResultSet resultSet = s.executeQuery(query);
		while(resultSet.next()){
			if(column.isNumber())
				values.add(resultSet.getDouble(column.getColumnName()));
			else
				values.add(resultSet.getString(column.getColumnName()));
		}
		resultSet.close();
		s.close();
		return values;
	}

	public  Object getAggregateColumnValue(String table,Column column,QUERY_TYPE aggregate) throws SQLException,NoValueException{
		\\ to do
	}

	

	

}
