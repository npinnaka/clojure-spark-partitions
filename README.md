# clojure-spark-partitions

A Sample clojure project to write Apache Spark Partitons 

## Installation

## Usage

    $ java -jar clojure-spark-partitions-0.1.0-standalone.jar [args]
    {"id": 1, "state": "TX","name": "john", "age": 23}
    {"id": 2, "state": "TN","name": "jim", "age": 43}
    {"id": 3, "state": "MI","name": "james", "age": 28}
    {"id": 4, "state": "IL","name": "jordon", "age": 21}
    
    if you issue ls -ltr out/employee-partition.json/
    
    total 0
    -rw-r--r--  1 pinnaka  staff    0 Dec 16 00:01 _SUCCESS
    drwxr-xr-x  4 pinnaka  staff  128 Dec 16 00:01 state=IL
    drwxr-xr-x  4 pinnaka  staff  128 Dec 16 00:01 state=MI
    drwxr-xr-x  4 pinnaka  staff  128 Dec 16 00:01 state=TN
    drwxr-xr-x  4 pinnaka  staff  128 Dec 16 00:01 state=TX
    
    cat out/employee-partition.json/state\=IL/part-00000-7ed358f8-3833-4349-955a-cce22a946e09.c000.json
    {"age":21,"id":4,"name":"jordon"}
    
## Options

## Examples

...

### Bugs


## License

Copyright © 2018 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
