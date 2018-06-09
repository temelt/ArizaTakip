package com.temelt.arizatakip.rapor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

@Controller
@Scope("session")
public class RaporController {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void init() {

	}

	public void raporAl(Integer raporTip, Boolean isKisi, Long id) {
		try {

			Map<String, Object> params = new HashMap<String, Object>();

			String path = "/WEB-INF/classes/com/temelt/arizatakip/rapor/Invoice.jasper";

			if (isKisi) {
				path = "/WEB-INF/classes/com/temelt/arizatakip/rapor/KisiRapor.jasper";
				params.put("ID", id);
			}

			JasperPrint jasperPrint;

			String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(path);
			jasperPrint = JasperFillManager.fillReport(reportPath, params, dataSource.getConnection());

			HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
					.getExternalContext().getResponse();

			ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
			if (raporTip == 2) {
				httpServletResponse.addHeader("Content-disposition", "attachment; filename=RaporKisi.pdf");
				JRPdfExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
				exporter.exportReport();
			} else if (raporTip == 1) {
				httpServletResponse.addHeader("Content-disposition", "attachment; filename=RaporKisi.xls");
				JRXlsExporter exporter = new JRXlsExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
				exporter.exportReport();
			}

			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void raporAlGoster() {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("STATE", Boolean.TRUE);

			String path = "/WEB-INF/classes/com/temelt/arizatakip/rapor/Invoice.jasper";
			JasperPrint jasperPrint;

			String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(path);
			jasperPrint = JasperFillManager.fillReport(reportPath, params, dataSource.getConnection());

			OutputStream outputStream = new FileOutputStream(new File("C:\\TTEMEL\\129435Rpt.pdf"));
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
			exporter.exportReport();
			outputStream.flush();
			outputStream.close();
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
