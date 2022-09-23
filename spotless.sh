#!/bin/sh

(cd java-poc && mvnd spotless:apply)
(cd kotlin-poc && mvnd spotless:apply)