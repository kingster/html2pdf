# HTML to PDF Converter

A command-line tool to convert HTML files to PDF using iText HTML2PDF.


## Installation

### Using pre-built binaries

Download the appropriate binary for your architecture from the [releases page](https://github.com/kingster/html2pdf/releases/latest):

```bash
# For AMD64 (x86_64)
curl -L https://github.com/kingster/html2pdf/releases/latest/download/html2pdf-amd64 -o html2pdf
# OR for ARM64
curl -L https://github.com/kingster/html2pdf/releases/latest/download/html2pdf-arm64 -o html2pdf

chmod +x html2pdf
sudo mv html2pdf /usr/local/bin/
```

### Building from Source

#### Prerequisites

- Java 21 or higher (for JAR version)
- GraalVM 21 or higher (for building native binary)

#### Building

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
