package com.temelt.arizatakip.view;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Cagri;
import com.temelt.arizatakip.entity.Personel;
import com.temelt.arizatakip.service.CagriService;
import com.temelt.arizatakip.service.PersonelService;

@Controller("cagriController")
@Scope("session")
public class CagriController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2324054627791585677L;
	
	@Autowired
	private CagriService cagriService;
	@Autowired
	private PersonelService personelService;
	
	private LazyDataModel<Cagri> cagriListe ;
	private Cagri cagri;

	@PostConstruct
	private void init(){
		listele();
		yeni();
		
	}
	
	public List<Personel> personelAcomp(String term) {
		List<Personel> liste = personelService.getBySicilNoIgnoreCaseContaining(term);
		return liste;
	}
	
	public void goster(Long id) {
		cagri = cagriService.findOne(id);
	}
	
	public void yeni() {
		cagri = new Cagri();
	}
	
	public void kaydet(){
		cagriService.save(cagri);
		listele();
		yeni();
	}
	
	public void sil(Long id){
		cagriService.delete(id);
		listele();
	}
	
	public void listele(){
		cagriListe =new LazyDataModel<Cagri>() {
			
			List<Cagri> list;
			/**
			 * 
			 */
			private static final long serialVersionUID = 6120622133867511444L;
			
			@Override
			public List<Cagri> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				int offset=0;
				if(first>0) {
					offset = first/pageSize;
				}
				Page<Cagri> liste = cagriService.findAll(new PageRequest(offset, pageSize,null));
				this.setRowCount(Integer.parseInt(String.valueOf(liste.getTotalElements())));
				list = liste.getContent();
				return list;
			}
			
		    @Override
		    public Cagri getRowData(String rowKey) {
		        for(Cagri c : list) {
		            if(c.getId().equals(rowKey))
		                return c;
		        }
		 
		        return null;
		    }
		 
		    @Override
		    public Object getRowKey(Cagri c) {
		        return c.getId();
		    }
			
		};
	}
	
	public LazyDataModel<Cagri> getCagriListe() {
		return cagriListe;
	}
	
	public Cagri getCagri() {
		return cagri;
	}
	
	public void setCagri(Cagri cagri) {
		this.cagri = cagri;
	}
}
