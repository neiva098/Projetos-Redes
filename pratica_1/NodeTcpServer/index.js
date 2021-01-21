const net = require('net');

const server = net.createServer(function (socket) {
    socket.on('data', function (data) {
        const textChunk = data.toString('utf8');

        console.log(`Recebi ${textChunk}`)

        socket.write(textChunk.toUpperCase());

        server.close()
    });
});

server.listen(1337, 'localhost');
