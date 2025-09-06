#!/usr/bin/env sh

DIRNAME=$(dirname "$0")
APP_BASE_NAME=$(basename "$0")
APP_HOME=$(cd "$DIRNAME" && pwd)

exec "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" "$@"
