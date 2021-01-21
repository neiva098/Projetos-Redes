const readLine = require("readline");

module.exports = class Console {
    static rl = readLine.createInterface({
        input: process.stdin,
        output: process.stdout,
    });

    static input = async (message) =>
        new Promise(resolve =>
            Console.rl.question(`${message}: `, awser => {
                return resolve(awser);
            }),
        );

    close = () => Console.rl.close();
}
