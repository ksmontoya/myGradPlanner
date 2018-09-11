mvn package

echo Please input your username

read username

serverAddress="@proj309-TG-02.misc.iastate.edu:"
serverJarDir="target/experiment-0.0.1-SNAPSHOT.jar"

echo sending $serverJarDir to $username$serverAddress

scp $serverJarDir $username$serverAddress