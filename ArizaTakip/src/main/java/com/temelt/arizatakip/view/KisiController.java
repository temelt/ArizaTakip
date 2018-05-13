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

import com.temelt.arizatakip.entity.Kisi;
import com.temelt.arizatakip.entity.Personel;
import com.temelt.arizatakip.service.KisiService;
import com.temelt.arizatakip.service.PersonelService;


@Controller("kisiController")
@Scope("session")
public class KisiController implements Serializable{
	
	private static final long serialVersionUID = 2324054627791585677L;

	@Autowired
	private KisiService kisiService;
	
	@Autowired
	private PersonelService personelService;
	
	private LazyDataModel<Kisi> kisiListe ;
	private Kisi kisi;

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
		kisi = kisiService.findOne(id);
	}
	
	public void yeni() {
		kisi = new Kisi();
	}
	
	public void kaydet(){
		kisiService.save(kisi);
		listele();
		yeni();
	}
	
	public void sil(Long id){
		kisiService.delete(id);
		listele();
	}
	public void listele(){
		kisiListe =new LazyDataModel<Kisi>() {
			
			List<Kisi> list;
			/**
			 * 
			 */
			private static final long serialVersionUID = 6120622133867511444L;
			
			@Override
			public List<Kisi> load(int first, int pageSize, String sortField, SortOrder sortOrder,
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
							
				String ad="";
				if(filters.get("ad")!=null) {
					ad =filters.get("ad").toString();
				}
				
				Page<Kisi> liste = kisiService.findByAdContainingIgnoreCase(ad,new PageRequest(offset, pageSize,s));
				this.setRowCount(Integer.parseInt(String.valueOf(liste.getTotalElements())));
				list = liste.getContent();
				return list;
			}
			
		    @Override
		    public Kisi getRowData(String rowKey) {
		        for(Kisi c : list) {
		            if(c.getId().equals(rowKey))
		                return c;
		        }
		 
		        return null;
		    }
		 
		    @Override
		    public Object getRowKey(Kisi c) {
		        return c.getId();
		    }
			
		};
	}
	
	public LazyDataModel<Kisi> getKisiListe() {
		return kisiListe;
	}
	
	
	public Kisi getKisi() {
		return kisi;
	}
	
	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}


}