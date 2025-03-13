package com.github.kingster.html2pdf;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.itextpdf.styledxmlparser.css.media.MediaType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length !=2) {
            System.out.println("Usage: java -jar html2pdf.jar <input.html> <output.pdf>");
            System.exit(1);
        }
        String input = args[0];
        String output = args[1];
        System.out.println("Hello, World!");

        generateHtmlToPdf(input, output);
        System.out.println("Doneeee!");
    }

    public static void generateHtmlToPdf(String inputFile, String outputFile) throws Exception {
        File inputF = new File(inputFile);
        String baseURI = inputF.getParent();

        Document inputHtml = createWellFormedHtml(inputF);

        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri(baseURI);

        converterProperties.setMediaDeviceDescription(new MediaDeviceDescription(MediaType.PRINT));
        HtmlConverter.convertToPdf(inputHtml.html(), new FileOutputStream(outputFile), converterProperties);
    }

    private static Document createWellFormedHtml(File inputHTML) throws IOException {
        Document document = Jsoup.parse(inputHTML, "UTF-8");
        document.outputSettings()
                .syntax(Document.OutputSettings.Syntax.xml);
        return document;
    }

}