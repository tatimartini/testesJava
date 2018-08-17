package br.com.buscaElemento;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import br.com.gerenciadores.GerenciadorDeTodosOsArquivos;

public class BuscaElemento {
	
	public By retornarElementoDaPlanilhaExcelDeElementos(String identificadorDoElemento) {
		List<ModelDeElementos> modelElementos = new ArrayList<>();
		modelElementos = GerenciadorDeTodosOsArquivos.getInstance().lerDadosExcel().getDadosExcelDeElementos();
		return procurarElemento(modelElementos, identificadorDoElemento);
	}
	
	private By procurarElemento(List<ModelDeElementos> objetoModelo, String identificadorDoElemento) {
		List<ModelDeElementos> objetos = new ArrayList<>();
		objetos = objetoModelo;
		String retorno = null;
		By elemento = null;

		for (ModelDeElementos objeto : objetos) {
			if (objeto.identificador != null && objeto.tipoDoElemento != null) {
				if (retorno == null) {
					if (objeto.identificador.equals(identificadorDoElemento)) {
						retorno = objeto.elemento;
						if (objeto.tipoDoElemento.equals("xpath")) {
							elemento = By.xpath(objeto.elemento);
						} else if (objeto.tipoDoElemento.equals("id")) {
							elemento = By.id(objeto.elemento);
						} else if (objeto.tipoDoElemento.equals("name")) {
							elemento = By.name(objeto.elemento);
						} else if (objeto.tipoDoElemento.equals("classname")) {
							elemento = By.className(objeto.elemento);
						} else if (objeto.tipoDoElemento.equals("cssselector")) {
							elemento = By.cssSelector(objeto.elemento);
						} else if (objeto.tipoDoElemento.equals("linktext")) {
							elemento = By.linkText(objeto.elemento);
						} else if (objeto.tipoDoElemento.equals("tagname")) {
							elemento = By.tagName(objeto.elemento);
						} else if (objeto.tipoDoElemento.equals("partiallinktext")) {
							elemento = By.partialLinkText(objeto.elemento);
						}
					}
				}
			}
		}
		return elemento;
	}
}
