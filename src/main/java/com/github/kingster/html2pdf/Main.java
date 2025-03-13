package com.github.kingster.html2pdf;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "html2pdf", 
        mixinStandardHelpOptions = true, 
        version = "1.0",
        description = "Converts HTML files to PDF")
public class Main implements Callable<Integer> {

    @Parameters(index = "0", description = "Input HTML file")
    private File inputFile;

    @Parameters(index = "1", description = "Output PDF file")
    private File outputFile;

    @Option(names = {"-m", "--mode"}, 
            description = "Conversion mode: print/screen",
            defaultValue = "print")
    private String mediaFormat;

    @Option(names = {"-b", "--base-dir"}, 
            description = "Base directory for resolving relative paths")
    private File baseDir;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        generateHtmlToPdf();
        return 0;
    }

    private void generateHtmlToPdf() throws Exception {

        String baseURI = baseDir != null ? baseDir.getAbsolutePath() : inputFile.getParent();

        Document inputHtml = createWellFormedHtml(inputFile);

        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri(baseURI);
        converterProperties.setMediaDeviceDescription(new MediaDeviceDescription(mediaFormat));

        HtmlConverter.convertToPdf(
            inputHtml.html(), 
            new FileOutputStream(outputFile), 
            converterProperties
        );
        
        System.out.println("PDF generation completed successfully!");
    }

    private static Document createWellFormedHtml(File inputHTML) throws IOException {
        Document document = Jsoup.parse(inputHTML, "UTF-8");
        document.outputSettings()
                .syntax(Document.OutputSettings.Syntax.xml);
        return document;
    }
}