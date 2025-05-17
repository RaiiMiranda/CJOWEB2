package br.edu.ifspcjo.ads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import br.edu.ifspcjo.ads.web2.model.User;
import br.edu.ifsp.ads.web2.utils.PasswordEncoder;

public class UserDao 
{
	private DataSource dataSource;

	public UserDao(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}

	public Boolean save(User user) 
	{
	    Optional<User> existing = getUserByEmail(user.getEmail());
	    
	    if(existing.isPresent()) return false;

	    String encryptedPassword = PasswordEncoder.encode(user.getPassword());
	    String sql = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";
	    
	    try(Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) 
	    {
	        ps.setString(1, user.getName());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, encryptedPassword);
	        ps.executeUpdate();
	        return true;
	    } catch(SQLException e) {
	        throw new RuntimeException("Erro ao salvar usuário", e);
	    }
	}


	public Optional<User> getUserByEmail(String email) 
	{
		String sql = "SELECT id, name, email, password FROM user WHERE email=?";
		
		try(Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setString(1, email);
			try(ResultSet rs = ps.executeQuery()) 
			{
				if (rs.next()) {
					User u = new User();
					u.setId(rs.getLong("id"));
					u.setName(rs.getString("name"));
					u.setEmail(rs.getString("email"));
					u.setPassword(rs.getString("password"));
					return Optional.of(u);
				}
			}
		} catch(SQLException e) {
			throw new RuntimeException("Erro na consulta", e);
		}
		
		return Optional.empty();
	}

	public Optional<User> getUserByEmailAndPassword(String email, String password) 
	{
		String passwordEncripted = PasswordEncoder.encode(password);
	    String sql = "SELECT id, name, email, password FROM user WHERE email=? AND password=?";
	    
	    try(Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) 
	    {
	        ps.setString(1, email);
	        ps.setString(2, passwordEncripted);
	        
	        try(ResultSet rs = ps.executeQuery()) 
	        {
	            if(rs.next()) 
	            {   
	                User u = new User();
	                u.setId(rs.getLong("id"));
	                u.setName(rs.getString("name"));
	                u.setEmail(rs.getString("email"));
	                u.setPassword(rs.getString("password"));
	                return Optional.of(u);
	            }
	        }
	    } catch(SQLException e) {
	        throw new RuntimeException("Erro no login", e);
	    }
	    
	    return Optional.empty();
	}
}
