/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,

  // https://stackoverflow.com/questions/60925133/proxy-to-backend-with-default-next-js-dev-server
  async rewrites() {
    return [
      {
        source: '/api/:path*',
        destination: 'http://localhost:8080/api/:path*' // Proxy to Backend
      },
      {
        source: '/swagger-ui/:path*',
        destination: 'http://localhost:8080/swagger-ui/:path*' // Proxy to Backend
      },
      {
        source: '/swagger-ui.html',
        destination: 'http://localhost:8080/swagger-ui.html' // Proxy to Backend
      },
      {
        source: '/v3/:path*',
        destination: 'http://localhost:8080/v3/:path*' // Proxy to Backend
      },
      {
        source: '/login',
        destination: 'http://localhost:8080/login' // Proxy to Backend
      },
      {
        source: '/logout',
        destination: 'http://localhost:8080/logout' // Proxy to Backend
      },
    ]
  }
}

module.exports = nextConfig
