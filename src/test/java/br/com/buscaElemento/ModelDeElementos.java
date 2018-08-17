package br.com.buscaElemento;

import com.poiji.annotation.ExcelCellName;

public class ModelDeElementos {

	@ExcelCellName("identificador")
	public String identificador;

	@ExcelCellName("tipoDoElemento")
	public String tipoDoElemento;

	@ExcelCellName("elemento")
	public String elemento;

}
