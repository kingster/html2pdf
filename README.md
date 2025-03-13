# HTML to PDF Converter

A command-line tool to convert HTML files to PDF using iText HTML2PDF.


## Installation

### Prerequisites

- Java 21 or higher (for JAR version)
- GraalVM 21 or higher (for building native binary)

### Building from Source

```bash
git clone https://github.com/kingster/html2pdf.git
cd html2pdf
mvn clean package -Pnative

#install
cp ./target/html2pdf /usr/local/bin/
```

### Usage

```bash
$ html2pdf [options] <input.html> <output.pdf>

$ html2pdf --help
Usage: html2pdf [-hV] [-b=<baseDir>] [-m=<mediaFormat>] <inputFile> <outputFile>
Converts HTML files to PDF
      <inputFile>            Input HTML file
      <outputFile>           Output PDF file
  -b, --base-dir=<baseDir>   Base directory for resolving relative paths
  -h, --help                 Show this help message and exit.
  -m, --mode=<mediaFormat>   Conversion mode: print/screen
  -V, --version              Print version information and exit.
```
