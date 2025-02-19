#!/bin/sh

find . -type f -name "*.markdown" | while read -r file; do

    filename="${file%.md}"

    pandoc "$file" -o "${filename}".pdf --from markdown --to pdf --pdf-engine=lualatex -V geometry:margin=1.5cm

done