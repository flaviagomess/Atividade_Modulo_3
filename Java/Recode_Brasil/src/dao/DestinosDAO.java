package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Destinos;

public class DestinosDAO {

	//CREATE
	public void create (Destinos destino) {
		String sql = "insert into Destinos (nome_destino, descricao_destino, preco_destino) values (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getNome());
			pstm.setString(2, destino.getDescricao());
			pstm.setFloat(3, destino.getPreco());
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			 try {
				
				 if (pstm !=null) {
					 pstm.close();
				
				 }
				 if (conn !=null) {
					 conn.close();
				 }
				 
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
	}
		
	}

	//READ
	public List <Destinos> read(){
		List<Destinos> destinos = new ArrayList<Destinos>();
		String sql = "select * from Destinos";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Destinos destino = new Destinos();
				destino.setId (rset.getInt("id_destino"));
				destino.setNome (rset.getString("nome_destino"));
				destino.setDescricao (rset.getString("descricao_destino"));
				destino.setPreco (rset.getFloat("preco_destino"));
				
				destinos.add(destino);
			}
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
}
		
		return destinos;
	}
	
	//UPDATE
	public void update (Destinos destino) {
		String sql = "UPDATE Destinos SET nome_destino = ?, descricao_destino = ?, preco_destino = ? WHERE id_destino = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getNome());
			pstm.setString(2, destino.getDescricao());
			pstm.setFloat(3, destino.getPreco());
			
			pstm.setInt(4, destino.getId());
			
			pstm.execute();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
}
	} 
	
	//DELETE
	public void delete (int id) {
	String sql = "DELETE FROM Destinos WHERE id_destino = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionMySQL.createConnectionMySQL();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		pstm.execute();
	
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 
}
	}
	}
	//readById
	public Destinos readById (int id) {
		Destinos destino = new Destinos();
		String sql = "select * from Destinos WHERE id_destino = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			destino.setId(rset.getInt("id_destino"));
			destino.setNome(rset.getString("nome_destino"));
			destino.setDescricao(rset.getString("descricao_destino"));
			destino.setPreco(rset.getFloat("preco_destino"));
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				 if (pstm !=null) {
					 pstm.close();
				
				 }
				 if (conn !=null) {
					 conn.close();
				 }
				 
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
	    }
		return destino;
		}
	}

