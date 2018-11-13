# RemoteVideoProject
### Authors:
* TheDutchMC04
* KaptainWutax
* StrikerRocker
* TreeOfChaos
### What is RemoteVideoProject
RemoteVideoProject, or RVP for short is a program that allows you to play videos from YouTube on a client. The client obtains the video key, or ID from the server.

### How does it work
RVP uses Java sockets to communicate between server and client. Whenever the client's sensor is triggered it will send a videoKey request to the server. The server will pick a specified amount of keys from a database and send those to the client. The client will play the videos from YouTube until the sensor is no longer triggered. If the client runs out of keys before the sensor isn't triggered anymore, it will request more keys.

After the sensor isn't triggered anymore and the video has stopped playing, it will notify the server on what is played and what not. The server will note this down.

### In what state is the program
It is currently in development, no alphas available yet.
