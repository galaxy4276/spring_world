import { resolve } from 'path';
import { Configuration } from 'webpack';
import { Configuration as DevServerConfig } from 'webpack-dev-server';
import HtmlWebpackPlugin from 'html-webpack-plugin';
// import * as CleanWebpackPlugin from 'clean-webpack-plugin';

const configuration: Configuration & DevServerConfig = {
  mode: 'development',
  entry: './src/config/index.html',
  module: {
    rules: [
      {
        test: /\.tsx?$/,
        use: 'ts-loader',
        exclude: /node_modules/,
      },
    ],
  },
  resolve: {
    extensions: ['.tsx', '.ts', '.js'],
  },
  output: {
    filename: 'bundle.js',
    path: resolve(__dirname, 'dist'),
  },
  plugins: [
    // new CleanWebpackPlugin({
    //   cleanStaleWebpackAssets: false,
    // }),
    new HtmlWebpackPlugin({
      template: './src/config/index.html'
    }),
  ],
  devServer: {
    port: 3000,
    compress: true,
    static: {
      directory: resolve(__dirname, 'src', 'config', 'index.html'),
    },
  },
};

export default configuration;
