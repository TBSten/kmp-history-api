
console.log(config.module)
if (!config.devServer) config.devServer = {}

console.log("config.devServer:", config.devServer)
//config.devServer = {
//    historyApiFallback: {
//        rewrites: [{ from: /^.*$/, to: '/index.html' }],
//    }
//}

// config.devServer.historyApiFallback = true
config.devServer.historyApiFallback = {
    rewrites: [
        { from: /^.*KmpSpa-composeApp-wasm-js\.wasm$/, to: "/KmpSpa-composeApp-wasm-js.wasm" },
        { from: /^.*6337cac22290173dbf0b\.wasm$/, to: "/6337cac22290173dbf0b.wasm" },
        { from: /^.*$/, to: '/index.html' },
    ],
}

const port = process.env["PORT"] ?? "8080"

config.devServer.port = port
