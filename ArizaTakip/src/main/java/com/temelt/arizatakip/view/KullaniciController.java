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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import com.temelt.arizatakip.entity.Cagri;
import com.temelt.arizatakip.entity.Kisi;
import com.temelt.arizatakip.entity.Kullanici;
import com.temelt.arizatakip.service.KisiService;
import com.temelt.arizatakip.service.KullaniciService;

@Controller("kullaniciController")
@Scope("session")
public class KullaniciController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980806834126346266L;
	@Autowired
	private KullaniciService kservice;
	@Autowired
	private KisiService kisiservice;
	private LazyDataModel<Kullanici> kullaniciL;
	private Kullanici kullanici;

	public void yeni() {
		kullanici = new Kullanici();
	}

	public Kullanici getKullanici() {
		return kullanici;
	}

	public List<Kisi> kisiAcomp(String term) {
		List<Kisi> klist = kisiservice.getByTc(term);
		return klist;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}

	public LazyDataModel<Kullanici> getkullaniciL() {
		return kullaniciL;
	}

	@PostConstruct
	private void init() {
		listele();
		yeni();
	}

	public void show(Long id) {
		kullanici = kservice.findOne(id);
	}

	public void save() {
		kservice.save(kullanici);
		listele();
		yeni();
	}

	public void delete(Long id) {
		kservice.delete(id);
		listele();
	}

	public void listele() {
		kullaniciL=new LazyDataModel<Kullanici>() {
			List<Kullanici> klist;

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public List<Kullanici> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				int offset=0;
				if(first>0) {
					offset = first/pageSize;
				}
				
				Sort s=null;
				if(sortOrder!=null && sortField !=null) {
					if(sortOrder.equals(SortOrder.ASCENDING)) {
						s =new Sort(Sort.Direction.ASC,sortField);
					}else if(sortOrder.equals(SortOrder.DESCENDING)) {
						s =new Sort(Sort.Direction.DESC,sortField);
					}
				}
							
				String usrnm="";
				if(filters.get("usrnm")!=null) {
					usrnm=filters.get("usrnm").toString();
				}
				
				Page<Kullanici> liste = kservice.findByUsrnmContainingIgnoreCase(usrnm,new PageRequest(offset, pageSize,s));
				this.setRowCount(Integer.parseInt(String.valueOf(liste.getTotalElements())));
				klist = liste.getContent();
				return klist;
			}
			
		    @Override
		    public Kullanici getRowData(String rowKey) {
		        for(Kullanici c : klist) {
		            if(c.getId().equals(rowKey))
		                return c;
		        }
		 
		        return null;
		    }
		 
		    @Override
		    public Object getRowKey(Kullanici c) {
		        return c.getId();
		    }
			
		};
	}
			
		
		
		
		
		
		
	}


