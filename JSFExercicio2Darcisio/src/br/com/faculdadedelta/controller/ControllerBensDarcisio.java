package br.com.faculdadedelta.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.sun.security.ntlm.Client;

import br.com.faculdadedelta.dao.DAO;
import br.com.faculdadedelta.modelo.DescricaoDarcisio;

@ManagedBean
public class ControllerBensDarcisio {
	private DescricaoDarcisio desc = new DescricaoDarcisio();
	private DAO dao = new DAO();
	public DescricaoDarcisio getCliente() {
		return desc;
	}


	public void setCliente(DescricaoDarcisio desc) {
		this.desc = desc;
	}


	public String salvar() {
		try {
			dao.incluir(desc);
			FacesMessage msg = new FacesMessage("Cadastro realizado!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage("ERROR!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		return "index.xhtml";
	}
	
	public List<DescricaoDarcisio> getLista() {
		List<DescricaoDarcisio> listaRetorno = new ArrayList<DescricaoDarcisio>();
		try {
			listaRetorno = dao.listar();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage("ERROR!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return listaRetorno;
	}
}
