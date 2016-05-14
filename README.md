# citedown


The goal of this project  is a pandoc filter and/or simple indepednent utility supporting use of pure URNs wherever you would use URLs in linking or embedding references in a markdown document.  Still in initial planning phases.

## Requires

- pandoc
- scala + sbt


## Run

While in development, options include:

- use `sbt` in this directory to filter a file in pandoc json format:

    sbt 'run-main PandocJsonFilter <FILE>'

- `sbt assembly` builds a fat jar in `target/scala-2.11`. You can run it with:
    - `java -jar scpd-assembly-1.0.jar <FILE>`

You can also make the included sh script `cd.sh`executable and put it in the same directory with the fat jar.  This lets you just run `cd.sh <FILE>`
