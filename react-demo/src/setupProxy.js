//注意： 你无需在任何位置导入此文件。 它在启动开发服务器时会自动注册。
const proxy = require('http-proxy-middleware');

module.exports = function (app) {
    app.use(
        '/api',//表示请求的接口以/api/开头
        proxy.createProxyMiddleware({
            target: 'http://localhost:8000', // 目标服务器 host
            changeOrigin: true, // 默认false，是否需要改变原始主机头为目标URL
            pathRewrite: {
                '^/api': '',     // 重写请求，比如我们源访问的是api/user，那么请求会被解析为/user
            },
        })
    )
}
