#!/bin/sh
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
exec java -jar ${DIR}/scalacd-assembly-1.0.jar "$@"
