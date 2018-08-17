package br.com.leitoresdedados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;

import br.com.buscaElemento.ModelDeElementos;
import br.com.modelsexcel.ModelExcel;

/**
 * @author Paulo Lobo Neto
 *
 */
public class LeitorDeDadosExcel {
	private String caminhoDoArquivoExcel;
	private String caminhoDoArquivoExcelDeElementos;
	private List<ModelExcel> modelExcel;
	private List<ModelDeElementos> modelExcelDeElementos;
	private InputStream stream;

	/**
	 * @param arquivo
	 * @param arquivoExcelDeElementos
	 */
	public LeitorDeDadosExcel(String arquivo, String arquivoExcelDeElementos) {
		this.caminhoDoArquivoExcel = arquivo;
		this.caminhoDoArquivoExcelDeElementos = arquivoExcelDeElementos;
	}

	/**
	 * @return
	 */
	public List<ModelExcel> getDadosExcel() {
		if (caminhoDoArquivoExcel.contains(".xlsx")) {
			try {
				stream = new FileInputStream(new File(caminhoDoArquivoExcel));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			modelExcel = Poiji.fromExcel(stream, PoijiExcelType.XLSX, ModelExcel.class);
		} else {
			try {
				stream = new FileInputStream(new File(caminhoDoArquivoExcel));
				modelExcel = Poiji.fromExcel(stream, PoijiExcelType.XLS, ModelExcel.class);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return modelExcel;
	}

	/**
	 * @return
	 */
	public List<ModelDeElementos> getDadosExcelDeElementos() {
		if (caminhoDoArquivoExcelDeElementos.contains(".xlsx")) {
			try {
				stream = new FileInputStream(new File(caminhoDoArquivoExcelDeElementos));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			modelExcelDeElementos = Poiji.fromExcel(stream, PoijiExcelType.XLSX, ModelDeElementos.class);
		} else {
			try {
				stream = new FileInputStream(new File(caminhoDoArquivoExcelDeElementos));
				modelExcelDeElementos = Poiji.fromExcel(stream, PoijiExcelType.XLS, ModelDeElementos.class);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return modelExcelDeElementos;
	}
}