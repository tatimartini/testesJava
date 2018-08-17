package br.com.gerenciadores;

import br.com.leitoresdedados.LeitorDeDadosExcel;

/**
 * @author Paulo Lobo Neto
 * @category Classe responsável pelo gerenciamento de todos os arquivos Excel,
 *           Json, Propriedades e Txt. Com essa classe, utilizo o padrão
 *           singleton, mantendo uma única instância para cada classe.
 */
public class GerenciadorDeTodosOsArquivos {

	private static GerenciadorDeTodosOsArquivos gerenciadorDeTodosOsArquivos = new GerenciadorDeTodosOsArquivos();
	private static GerenciadorDoArquivoDeConfiguracao gerenciadorDoArquivoDeConfiguracao;
	private static LeitorDeDadosExcel excelDataReader;

	/**
	 * 
	 */
	private GerenciadorDeTodosOsArquivos() {
	}

	/**
	 * @return instancia da classe
	 */
	public static GerenciadorDeTodosOsArquivos getInstance() {
		return gerenciadorDeTodosOsArquivos;
	}

	/**
	 * @return
	 */
	public GerenciadorDoArquivoDeConfiguracao getGerenciadorDoArquivoDeConfiguracao() {
		return (gerenciadorDoArquivoDeConfiguracao == null) ? new GerenciadorDoArquivoDeConfiguracao()
				: gerenciadorDoArquivoDeConfiguracao;
	}

	/**
	 * @return
	 */

	/**
	 * @return
	 */
	public LeitorDeDadosExcel lerDadosExcel() {
		return (excelDataReader == null)
				? new LeitorDeDadosExcel(getGerenciadorDoArquivoDeConfiguracao().getCaminhoDaPlanilhaExcel(),
						getGerenciadorDoArquivoDeConfiguracao().getCaminhoDaPlanilhaExcelDeElementos())
				: excelDataReader;
	}
}
