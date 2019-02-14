#!/usr/bin/env bash

## variable
#whom_variable="World"
#printf "Hello, %s\n" "$whom_variable"

## with User Input
#echo "Who are you?"
#read name
#echo "Hello, ${name}, weclome come"

## Hello World in "Debug" mode
#echo "Hello World\n"
#adding_string_to_number="s"
#v=$(expr 5 + $adding_string_to_number)

deploy=false
uglify=false

while (( $# > 1 )); do case $1 in
    --deploy) deploy="$2";;
    --uglify) uglify="$2";;
    *) break;
  esac; shift 2
done

$deploy && echo "will deploy... deploy = $deploy"
$uglify && echo "will uglify... uglify = $uglify"