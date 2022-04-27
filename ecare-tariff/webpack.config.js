var path = require('path');
const NodePolyfillPlugin = require("node-polyfill-webpack-plugin")

module.exports = {
    entry: {
        src: {import: './src/main/js/app.js', filename: './src/main/resources/static/built/bundle.js'},
        target: {import: './src/main/js/app.js', filename: './target/classes/static/built/bundle.js'}
    },
    devtool: 'eval-source-map',
    cache: true,
    mode: 'development',
    plugins: [
        new NodePolyfillPlugin()
    ],
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ["@babel/preset-env", "@babel/preset-react"]
                    }
                }]
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            }
        ]
    }
};