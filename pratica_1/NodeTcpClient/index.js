const Console = require('./Console');
const net = require('net');
const { exit } = require('process');

async function main() {
    const host = await Console.input(
        'Informe host',
    );

    const frase = await Console.input(
        'Informe a frase',
    );

    const client = new net.Socket();

    client.connect(1337, host, function () {
        console.log('Connected');

        client.write(frase);
    });

    client.on('data', function (data) {
        console.log('Received: ' + data);

        client.destroy();
    });

    client.on('close', function () {
        console.log('Connection closed');

        exit()
    });
}



main()