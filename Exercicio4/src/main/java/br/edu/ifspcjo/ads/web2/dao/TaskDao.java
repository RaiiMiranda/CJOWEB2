package br.edu.ifspcjo.ads.web2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import br.edu.ifspcjo.ads.web2.model.Task;

public class TaskDao 
{
	private DataSource dataSource;

	public TaskDao(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}

	public Boolean save(Task task) 
	{
		String sql = "INSERT INTO task (description, date, user_id) VALUES (?, ?, ?)";
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setString(1, task.getDescription());
			ps.setDate(2, Date.valueOf(task.getDate()));
			ps.setLong(3, task.getUser().getId());
			ps.executeUpdate();
			
			return true;
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException("Erro ao salvar tarefa", e);
		}
	}
}
