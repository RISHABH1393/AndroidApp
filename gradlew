CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar

# Check Java
if [ -n "$JAVA_HOME" ] ; then
    JAVA="$JAVA_HOME/bin/java"
else
    JAVA="java"
fi

exec "$JAVA" -Xmx64m -Xms64m -cp "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
