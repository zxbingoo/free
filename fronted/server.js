var express = require('express');
var app = express();

app.use('/', require('connect-history-api-fallback')());
app.use('/', express.static('public'));

if (process.env.NODE_ENV !== 'production') {
  var webpack = require('webpack');
  var webpackConfig = require('./webpack.config.js');
  var webpackCompiled = webpack(webpackConfig);
  // 配置运行时打包
  var webpackDevMiddleware = require('webpack-dev-middleware');
  app.use(webpackDevMiddleware(webpackCompiled, {
    publicPath: "/",
    stats: {colors: true},
    lazy: false,
    watchOptions: {
        aggregateTimeout: 300,
        poll: true
    },
  }));
}

var server = app.listen(2000, function() {
  var port = server.address().port;
  console.log('Open http://localhost:%s', port);
});

作者：chardlau
链接：https://www.jianshu.com/p/9b0908087ed3
來源：简书
简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。