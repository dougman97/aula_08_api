package br.com.bossini.ws.usjt_ccp3bnmcb_rest_json.URL;

public class ConsumoURL {
	
	public String montaUrl(String... args) {
		StringBuilder sb = new StringBuilder();
		for (String s : args) {
			sb.append(s);
		}
		return sb.toString();
	}
}