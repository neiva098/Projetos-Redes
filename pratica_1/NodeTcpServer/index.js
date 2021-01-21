const net = require('net');
const localip = require('local-ip');

const iface = 'wlan0';
const ip = localip()

console.log('My local ip address on ' + iface + ' is ' + ip);

const server = net.createServer(function(socket) {
    socket.on('data', function(data) {
        const textChunk = data.toString('utf8');

        console.log(`Recebi ${textChunk}`)

        socket.write(textChunk.toUpperCase());

        server.close()
    });
});

server.listen(1337, ip);