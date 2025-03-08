#!/bin/bash

DIR="${1:-.}"

find "$DIR" -type f -name "*.markdown" | while read file; do
    mv "$file" "${file%.markdown}.md"
done

echo "Done."
