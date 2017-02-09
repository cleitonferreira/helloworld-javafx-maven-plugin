package br.com.nuvemapp.helloworld;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppController {
	private static final Logger log = LoggerFactory.getLogger(AppController.class);

	@FXML
	private TextField inputPrimeiroNome;
	@FXML
	private TextField inputSobrenome;
	@FXML
	private Label mensagem;

	public void sayHello() {

		String primeiroNome = inputPrimeiroNome.getText();
		String sobrenome = inputSobrenome.getText();

		StringBuilder builder = new StringBuilder();

		if (!StringUtils.isEmpty(primeiroNome)) {
			builder.append(primeiroNome);
		}

		if (!StringUtils.isEmpty(sobrenome)) {
			if (builder.length() > 0) {
				builder.append(" ");
			}
			builder.append(sobrenome);
		}

		if (builder.length() > 0) {
			String nome = builder.toString();
			log.debug("Conversando com " + nome);
			mensagem.setText("Olá " + nome);
		} else {
			log.debug("O primeiro nome e o sobrenome não foi definido, dizendo olá para pessoa anônima");
			mensagem.setText("Olá pessoa misteriosa");
		}
	}

}
