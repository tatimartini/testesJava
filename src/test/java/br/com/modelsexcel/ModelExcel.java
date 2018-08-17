package br.com.modelsexcel;

import com.poiji.annotation.ExcelCellName;

/**
 * @author Paulo Lobo Neto
 *
 */
public class ModelExcel {

	@ExcelCellName("Url")
	public String url;

	@ExcelCellName("Andar")
	public String andar;
	
	@ExcelCellName("Sala")
	public String sala;
	
	@ExcelCellName("Nome do Solicitante")
	public String nomeSolicitante;

}
