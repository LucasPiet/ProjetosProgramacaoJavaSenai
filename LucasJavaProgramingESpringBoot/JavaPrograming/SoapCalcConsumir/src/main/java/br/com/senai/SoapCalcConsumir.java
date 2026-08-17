package br.com.senai;

import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.URL;

public class SoapCalcConsumir {

    public static void main(String[] args){

        String wsdl = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL";
        String target = "http://www.dataaccess.com/webservicesserver/";
        String name = "NumberConversion";

        URL url = new URL(wsdl);
        QName qName = new QName(target,name);
        Service service = Service.create(url, qName);

    }
}
