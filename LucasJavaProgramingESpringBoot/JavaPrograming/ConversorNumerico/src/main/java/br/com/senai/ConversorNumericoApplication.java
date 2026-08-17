package br.com.senai;

import br.com.senai.stubclasses.NumberConversionSoapType;
import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ConversorNumericoApplication {

    public static void main (String[] args) throws MalformedURLException {
        Scanner sc = new Scanner(System.in);

        String wsdl = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL";
        String target = "http://www.dataaccess.com/webservicesserver/";
        String name = "NumberConversion";

        URL url = new URL(wsdl);
        QName qName = new QName(target,name);
        Service service = Service.create(url, qName);

        NumberConversionSoapType numberConversion = service.getPort(NumberConversionSoapType.class);
        System.out.println("Digite um numero: ");
        int num = sc.nextInt();

        String convertedNumber = numberConversion.numberToWords(BigInteger.valueOf(num));
        System.out.println(convertedNumber);

        System.out.println("Numero convertido: "+ convertedNumber);
    }
}
