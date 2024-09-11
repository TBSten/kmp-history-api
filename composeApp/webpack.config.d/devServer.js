
console.log(config.module)
config.devServer = {
    historyApiFallback: {
        rewrites: [{ from: /^\/test$/, to: '/index.html' }],
    }
}

//
//module.exports = {
//  // 他の設定...
//  devServer: {
//    historyApiFallback: {
//      rewrites: [
//        { from: /./, to: '/404.html' }, // 404にリダイレクト
//      ],
//    },
//  },
//};
