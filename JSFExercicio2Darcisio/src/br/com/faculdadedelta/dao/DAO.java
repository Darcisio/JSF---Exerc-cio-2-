package br.com.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.faculdadedelta.modelo.DescricaoDarcisio;
import br.com.faculdadedelta.util.Conexao;

public class DAO {
	public void incluir(DescricaoDarcisio desc) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection connect = conexao.conectarNoBanco();
		String sql = "INSERT cliente (desc_cliente, desc_servico, valor_unitario_servico, qtde_servico, data_exec_servico) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1,  desc.getDesc());
		ps.setString(2, desc.getEspecificacao());
		ps.setString(3, desc.getDep());
		ps.setInt(4, desc.getValor());
		ps.setInt(5, desc.getData());
		
		ps.executeUpdate();
		ps.close();
		connect.close();
	}
	
	public void alterarCliente(DescricaoDarcisio cliente) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection connect = conexao.conectarNoBanco();
		String sql = "UPDATE cliente SET desc_cliente = ?,  desc_servico = ?, valor_unitario_servico = ?, qtde_servico = ?, data_exec_servico = ? WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1,  cliente.getDesc());
		ps.setString(2, cliente.getEspecificacao());
		ps.setString(3, cliente.getDep());
		ps.setInt(4, cliente.getValor());
		ps.setInt(5, cliente.getData());
		
		ps.executeUpdate();
		ps.close();
		connect.close();
	}
	
	public void excluir(DescricaoDarcisio cliente) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection connect = conexao.conectarNoBanco();
		String sql = "DELETE FROM alunos WERE id = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setLong(1, cliente.getId());
		
		ps.executeUpdate();
		ps.close();
		connect.close();
	}
	
	public List<DescricaoDarcisio> listar() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection connect = conexao.conectarNoBanco();
		String sql = "SELECT * FROM cliente";
		PreparedStatement ps = connect.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<DescricaoDarcisio> listaRetorno = new ArrayList<DescricaoDarcisio>();
		while(rs.next()) {
			DescricaoDarcisio cliente = new DescricaoDarcisio();		
			cliente.setId(rs.getLong("id"));
			cliente.setDesc(rs.getString("desc_descricao"));
			cliente.setEspecificacao(rs.getString("desc_especificacao"));
			cliente.setValor(rs.getInt("valor_unitario_servico"));
			cliente.setDep(rs.getString("dep"));
			cliente.setData(rs.getInt("data_exec_servico"));
			listaRetorno.add(cliente);
		}
		ps.close();
		rs.close();
		connect.close();
		
		return listaRetorno;
	}
}
