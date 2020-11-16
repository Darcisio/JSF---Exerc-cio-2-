package br.com.faculdadedelta.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.sun.security.ntlm.Client;

import br.com.faculdadedelta.dao.DAO;
import br.com.faculdadedelta.modelo.DescricaoRichard;

@ManagedBean
public class ControllerBensRichard {
	private DescricaoRichard desc = new DescricaoRichard();
	private DAO dao = new DAO();
	public DescricaoRichard getCliente() {
		return desc;
	}


	public void setCliente(DescricaoRichard desc) {
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
	
	public List<DescricaoRichard> getLista() {
		List<DescricaoRichard> listaRetorno = new ArrayList<DescricaoRichard>();
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
