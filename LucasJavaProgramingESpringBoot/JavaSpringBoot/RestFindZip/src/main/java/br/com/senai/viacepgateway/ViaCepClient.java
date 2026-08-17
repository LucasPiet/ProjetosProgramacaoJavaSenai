package br.com.senai.viacepgateway;

import br.com.senai.exception.ZipNotFoundException;
import br.com.senai.model.Endereco;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class ViaCepClient {

    public static Endereco showAddress(String zip){

        String url = "https://viacep.com.br/ws/"+zip+"/json/";
        try {
            String address = Request.Get(url)
                    .connectTimeout(10000)
                    .socketTimeout(10000)
                    .execute()
                    .returnContent()
                    .asString();

            JsonObject json = JsonParser.parseString(address).getAsJsonObject();

            if (json.has("erro")&& json.get("erro").getAsBoolean()){
                throw new ZipNotFoundException("CEP não existe na base de dados: " + zip);
            }

            Gson gson = new Gson();

            return gson.fromJson(json,Endereco.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
