const express = require('express');
const path = require('path');
const proxy = express();
const request = require('request');

// 配置静态文件服务中间件
let serverUrl='http://localhost:8080';
proxy.use(express.static(path.join(__dirname, './')));//静态资源index.html和node代码在一个目录下
proxy.use('/api', function(req, res) {
  let url = serverUrl + req.url;
  req.pipe(request(url)).pipe(res);
});

//本地服务代理在8888端口
proxy.listen(8888,'127.0.0.1', function () {
  console.log('proxy server is running at port 8888');
});