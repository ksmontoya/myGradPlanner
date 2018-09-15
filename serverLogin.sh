echo Please input your username

read username

serverAddress="@proj309-TG-02.misc.iastate.edu"

echo loging into $username$serverAddress

ssh $username$serverAddress
